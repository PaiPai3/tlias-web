package com.example.controller;


import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        List<Dept> all = deptService.findAll();
        return Result.success(all);
    }

    @DeleteMapping
    public Result deleteById(@RequestParam(value = "id", required = false) Integer id) {
        Integer integer = deptService.deleteById(id);
        return integer.equals(1) ? Result.success() : Result.error();
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept){ //@RequestBody将参数封装进类的对应的变量
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id){
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result updateById(@RequestBody Dept dept){
        deptService.updateById(dept);
        return Result.success();
    }
}
