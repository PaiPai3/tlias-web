package com.example.controller;

import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*
        按条件分页查询
     */
    @GetMapping
    public Result pageList(StudentQueryParam studentQueryParam){
        //分页查询
        PageResult<Student> pageResult = studentService.pageList(studentQueryParam);

        return Result.success(pageResult);
    }

    /*
        按照ID批量删除学生
     */
    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids){
        studentService.deleteByIds(ids);
        return Result.success();
    }

    /*
    添加学生
 */
    @PostMapping
    public Result add(@RequestBody Student student){
        studentService.add(student);
        return Result.success();
    }

    /*
        根据ID查询
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    /*
        修改学员信息
     */
    @PutMapping
    public Result update(@RequestBody Student student){
        studentService.update(student);
        return Result.success();
    }

    /*
        违纪处理，根据ID扣分
     */
    @PutMapping("/violation/{id}/{score}")
    public Result violationRecord(@PathVariable(value = "id") Integer id, @PathVariable(value = "score") Integer score){
        studentService.violationRecord(id,score);
        return Result.success();
    }
}
