package com.example.service.impl;

import com.example.mapper.EmpExprMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.*;
import com.example.service.EmpLogService;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageResult<Emp> page(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        //方式1，手动计算页数
//        Long count = empMapper.count(); //查询记录数
//        Integer start = (page - 1) * pageSize; //计算起始页
//        List<Emp> rows = empMapper.list(start, pageSize); //查询页信息
//        return new PageResult<>(count, rows); //返回页面结果

        //方式2，使用pageHelper计算分页
//        PageHelper.startPage(page, pageSize);//使用pageHelper分页
//
//        List<Emp> list = empMapper.list(name, gender, begin, end);//查询所有员工
//
//        Page<Emp> p = (Page<Emp>) list;//将查询墙砖为Page类
//
//        return new PageResult<>(p.getTotal(), p.getResult());//返回结果
        return null;
    }

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) { //TODO 测试未通过
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        List<Emp> list = empMapper.list(empQueryParam);

        Page<Emp> p = (Page<Emp>) list;

        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    //事务注解，将方法标记为一个事务，如果中途执行了一般出错会进行事务回滚
    //该注解可以加在方法上，类上，接口上
    @Transactional(rollbackFor = {Exception.class})
    public void save(Emp emp) {
        try {
            //1.保存员工基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            //2.为工作经历设置员工id，这样以后才可以多表联合查询
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
            }

            //3.保存工作经历
            empExprMapper.insertBatch(exprList);
        } finally {
            //4.记录日志,无论回滚与否都要记录日志
            empLogService.insertLog(new EmpLog(null, LocalDateTime.now(), "新增员工：" + emp));
        }


    }

    @Override
    @Transactional(rollbackFor = {Exception.class}) //事务控制
    public void deleteByIds(List<Integer> ids) {

        empExprMapper.deleteByEmpIds(ids);
        empMapper.deleteByIds(ids);

    }

    @Override
    public Emp getById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void update(Emp emp) {
        //1.修改员工信息
        emp.setUpdateTime(LocalDateTime.now());//设置更新时间
        empMapper.updateById(emp);
        //2.删除工作经历
        empExprMapper.deleteByEmpIds(List.of(emp.getId()));
        //3.重新插入工作经历
        if(!CollectionUtils.isEmpty(emp.getExprList())){
            emp.getExprList().forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(emp.getExprList());
        }
    }

}
