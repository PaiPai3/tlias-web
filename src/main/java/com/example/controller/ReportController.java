package com.example.controller;

import com.example.pojo.*;
import com.example.service.EmpService;
import com.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /*
        查询员工的工作数据
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /*
        获取员工性别分布
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        List<Map<String,Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /*
        统计学历分布
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        List<StudentDegreeData> list = reportService.getStudentDegreeData();
        return Result.success(list);
    }

    /*
        统计班级人数
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        StudentCountData studentCountData = reportService.getStudentCountData();
        return Result.success(studentCountData);
    }
}
