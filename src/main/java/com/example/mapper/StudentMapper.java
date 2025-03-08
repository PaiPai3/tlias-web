package com.example.mapper;

import com.example.pojo.Student;
import com.example.pojo.StudentCountData;
import com.example.pojo.StudentDegreeData;
import com.example.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    /*
        根据学历和班级条件查询
     */
    List<Student> pageList(StudentQueryParam studentQueryParam);


    /*
        批量删除学生
     */
    void deleteByIds(List<Integer> ids);

    /*
        添加学生
     */
    @Insert("insert into student(name, no, gender, phone, id_card,is_college,address,degree,graduation_date,clazz_id) " +
            "values (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId})")
    void add(Student student);

    /*
        根据ID查询
     */
    @Select("select * from student where id = #{id}")
    Student getById(Integer id);

    /*
        更新学生信息
     */
    @Update("update student set " +
            "name = #{name}, " +
            "no = #{no}, " +
            "phone = #{phone}, " +
            "gender= #{gender}, " +
            "degree = #{degree}, " +
            "id_card = #{idCard}, " +
            "is_college = #{isCollege}, " +
            "address = #{address}, " +
            "graduation_date = #{graduationDate}, " +
            "violation_count = #{violationCount}, " +
            "violation_score = #{violationScore}, " +
            "clazz_id = #{clazzId}, " +
            "update_time = #{updateTime} " +
            "where id = #{id}")
    void update(Student student);

    /*
        违纪扣分
     */
    @Update("update student set " +
            "violation_count = violation_count + 1, " +
            "violation_score = violation_score + #{score}, " +
            "update_time = now() " +
            "where id = #{id}")
    void violationRecord(Integer id, Integer score);

    /*
        统计学历分布
     */
    List<StudentDegreeData> getStudentDegreeData();

    /*
        统计班级人数
     */
    @MapKey(value = "name")
    List<Map<String,Object>> getStudentCountData();
}
