package com.example.controller;

import com.example.exception.GlobalExceptionHandler;
import com.example.pojo.*;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;


    /*
        分页查询
    */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        //1.输出日志
        log.info("分页查询：{},{},{},{},{},{}",
                empQueryParam.getName(), empQueryParam.getGender(), empQueryParam.getBegin(),empQueryParam.getEnd(),  empQueryParam.getPage(), empQueryParam.getPageSize());
        //2.查询结果
//        PageResult<Emp> pageResult = empService.page(name,gender,begin,end, page, pageSize);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        //3.返回Result
        return Result.success(pageResult);
    }


    /*
        新增员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工:{}",emp);
        empService.save(emp);
        return Result.success();
    }

    /*
        删除员工
     */
    @DeleteMapping
    public Result deleteByIds(@RequestParam List<Integer> ids){

        empService.deleteByIds(ids);

        return Result.success();
    }

    /*
        根据ID查询单个员工
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }


    @PutMapping
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        return Result.success();
    }

}
