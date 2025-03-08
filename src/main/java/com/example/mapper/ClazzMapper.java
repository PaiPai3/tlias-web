package com.example.mapper;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClazzMapper {

    /*
        查询所有班级
     */
    List<Clazz> pageList(ClazzQueryParam clazzQueryParam);

    /*
        根据ID删除班级
     */
    @Delete("delete from clazz where id =#{id};")
    void deleteById(Integer id);

    /*
        新建班级
     */
    @Insert("insert into clazz(name,room,begin_date,end_date,master_id,subject, create_time, update_time) " +
            "values (#{name},#{room},#{beginDate},#{endDate},#{masterId}, #{subject}, #{createTime},#{updateTime} )")
    void add(Clazz clazz);

    /*
        根据ID查询班级
     */
    @Select("select * from clazz where id = #{id}")
    Clazz getById(Integer id);

    /*
        更新班级信息
     */
    @Update("update clazz set " +
            "name = #{name}, " +
            "room = #{room}, " +
            "begin_date = #{beginDate}, " +
            "end_date = #{endDate}, " +
            "master_id = #{masterId}, " +
            "subject = #{subject}, " +
            "update_time = #{updateTime} " +
            "where id = #{id} ")
    void update(Clazz clazz);

    /*
        无条件查询所有班级
     */
    @Select("select * from clazz")
    List<Clazz> list();
}
