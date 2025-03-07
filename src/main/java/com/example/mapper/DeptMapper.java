package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface DeptMapper {

    //起别名进行重新映射
    @Select("select id,name,create_time createTime, update_time updateTime " +
            "from dept " +
            "order by update_time desc ")
    List<Dept> findAll();


    @Delete("delete from dept where id = #{id}")
    Integer deleteById(Integer id);

    @Insert("insert into dept (name, create_time, update_time) " +
            "values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept findById(Integer id);

    @Update("update dept " +
            "set name = #{name}, update_time = #{updateTime} " +
            "where id = #{id}")
    void updateById(Dept dept);
}
