package com.example.service.impl;

import com.example.mapper.ClazzMapper;
import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import com.example.pojo.PageResult;
import com.example.service.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    /*
        依据日期范围以及班级名称条件分页查询班级
     */
    @Override
    public PageResult pageList(ClazzQueryParam clazzQueryParam) {
        //设置页数和页大小
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
        //查询
        List<Clazz> list = clazzMapper.pageList(clazzQueryParam);
        //将查询结果转为页结果
        Page<Clazz> p = (Page<Clazz>) list;
        return new PageResult(p.getTotal(),p.getResult());
    }

    /*
        根据ID删除
     */
    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    /*
        创建新班级
     */
    @Override
    public void add(Clazz clazz) {
        //设置创建始建与更新时间
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        //插入
        clazzMapper.add(clazz);
    }

    /*
        根据ID查询
     */
    @Override
    public Clazz getById(Integer id) {
        Clazz clazz = clazzMapper.getById(id);

        return clazz;
    }

    /*
        更新班级信息
     */
    @Override
    public void update(Clazz clazz) {
        //更新更新时间
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    /*
        无条件查询所有班级
     */
    @Override
    public List<Clazz> list() {
        List<Clazz> list = clazzMapper.list();
        return list;
    }
}
