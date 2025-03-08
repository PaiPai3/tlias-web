package com.example.controller;

import com.example.pojo.*;
import com.example.service.ClazzService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    /*
        分页查询所有班级
     */
    @GetMapping
    public Result pageList(ClazzQueryParam clazzQueryParam){
        //调用list查询所有班级
        PageResult pageResult = clazzService.pageList(clazzQueryParam);
        return Result.success(pageResult);
    }

    /*
        根据ID删除班级
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        clazzService.deleteById(id);
        return Result.success();
    }

    /*
        添加新的班级
     */
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        clazzService.add(clazz);
        return Result.success();
    }

    /*
        根据ID查询
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    /*
        修改班级信息
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        clazzService.update(clazz);
        return Result.success();
    }

    /*
        查询所有班级
     */
    @GetMapping("/list")
    public Result list(){
        List<Clazz> list = clazzService.list();
        return Result.success(list);
    }


}
