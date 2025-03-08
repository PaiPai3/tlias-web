package com.example.service;

import com.example.pojo.PageResult;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;

import java.util.List;


public interface StudentService {

    void add(Student student);

    PageResult<Student> pageList(StudentQueryParam studentQueryParam);

    void deleteByIds(List<Integer> ids);

    Student getById(Integer id);

    void update(Student student);

    void violationRecord(Integer id, Integer score);
}
