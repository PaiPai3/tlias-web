package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> findAll();

    Integer deleteById(Integer id);

    void insert(Dept dept);

    Dept findById(Integer id);

    void updateById(Dept dept);
}
