package com.example.service;

import com.example.pojo.JobOption;
import com.example.pojo.StudentCountData;
import com.example.pojo.StudentDegreeData;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    List<StudentDegreeData> getStudentDegreeData();

    StudentCountData getStudentCountData();
}
