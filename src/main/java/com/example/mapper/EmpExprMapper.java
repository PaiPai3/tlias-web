package com.example.mapper;

import com.example.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

//    @Insert("insert into emp_expr(emp_id, begin, end, company, job) " +
//            "values (#{empId},#{begin},#{end},#{company},#{job})")
    void insertBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> empIds);
}
