package com.example.service;

import com.example.pojo.EmpLog;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

public interface EmpLogService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)//需要在一个新的事务中运行，也就是新建了一个事务
    public void insertLog(EmpLog empLog);

}
