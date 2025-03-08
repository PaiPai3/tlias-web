package com.example.service.impl;

import com.example.mapper.StudentMapper;
import com.example.pojo.PageResult;
import com.example.pojo.Student;
import com.example.pojo.StudentQueryParam;
import com.example.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /*
        添加学生
     */
    @Override
    public void add(Student student) {
        studentMapper.add(student);
    }

    /*
            条件分页查询，根据学历班级分页
         */
    @Override
    public PageResult<Student> pageList(StudentQueryParam studentQueryParam) {
        //设置分页
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        //查询所有符合条件的同学
        List<Student> list = studentMapper.pageList(studentQueryParam);
        //强转为页
        Page<Student> p = (Page<Student>) list;

        return new PageResult<>(p.getTotal(),p.getResult());
    }

    /*
        按照ID批量删除
     */
    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    /*
        根据ID查询
     */
    @Override
    public Student getById(Integer id) {
        Student student = studentMapper.getById(id);
        return student;
    }

    /*
        更新学生信息
     */
    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    /*
        根据ID扣分
     */
    @Override
    public void violationRecord(Integer id, Integer score) {
        studentMapper.violationRecord(id, score);
    }


}
