package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.mapper.StudentMapper;
import com.example.pojo.JobOption;
import com.example.pojo.StudentCountData;
import com.example.pojo.StudentDegreeData;
import com.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        //1.获取统计数据
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        //2.将数据转换为JobOption对象的字段
        List<Object> posList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> numList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(posList, numList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    /*
        获取学生学历分布
     */
    @Override
    public List<StudentDegreeData> getStudentDegreeData() {
        List<StudentDegreeData> list = studentMapper.getStudentDegreeData();
        return list;
    }

    /*
        统计班级人数
     */
    @Override
    public StudentCountData getStudentCountData() {
        List<Map<String, Object>> list = studentMapper.getStudentCountData();

        List<Object> name = list.stream().map(map -> map.get("name")).toList();
        List<Object> num = list.stream().map(map -> map.get("num")).toList();

        return new StudentCountData(name, num);
    }
}
