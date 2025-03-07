package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    /*
    查询总记录数
     */
    @Select("select count(*) " +
            "from emp,dept " +
            "where emp.id = dept.id")
    Long count();


    /*
    查询所有用户
    将数据库列dept.name起别名deptName，从而使其可以映射到Emp类中的deptName字段
     */
//    @Select("select emp.*, dept.name deptName " +
//            "from emp,dept " +
//            "where emp.id = dept.id " +
//            "order by emp.update_time desc " +
//            "limit #{start}, #{pageSize}")
//    List<Emp> list(Integer start, Integer pageSize);

    //mybatis不支持重载！！！
//    @Select("select emp.*, dept.name deptName " +
//            "from emp,dept " +
//            "where emp.id = dept.id " +
//            "and emp.name like concat('%',#{name},'%')" + //注意模糊匹配的写法以及concat的使用
//            "and emp.gender = #{gender} " +
//            "between #{begin} and #{end}" +
//            "order by emp.update_time desc")
//    List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

//    @Select("select emp.*, dept.name deptName " +
//            "from emp,dept " +
//            "where emp.id = dept.id " +
//            "and emp.name like concat('%',#{name},'%')" + //注意模糊匹配的写法以及concat的使用
//            "and emp.gender = #{gender} " +
//            "between #{begin} and #{end}" +
//            "order by emp.update_time desc")

    //xml映射文件中已经写了sql语句
    List<Emp> list(EmpQueryParam empQueryParam);

    /*
    新增员工
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")//主键返回功能，将自动生成的ID返回给对象
    @Insert("insert emp(username, name, gender,phone, job, salary, image, entry_date, dept_id,create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job}, #{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /*
    删除员工
     */
    void deleteByIds(List<Integer> ids);

    /*
    按照id查询
     */
    Emp getById(Integer id);

    /*
    按照更新员工
     */
    void updateById(Emp emp);

    /*
    查询所有员工的工作分布
     */
    @MapKey("job")
    List<Map<String, Object>> countEmpJobData();

    @MapKey("gender")
    List<Map<String, Object>> countEmpGenderData();

}
