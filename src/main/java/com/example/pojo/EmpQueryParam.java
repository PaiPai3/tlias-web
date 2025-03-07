package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.ref.SoftReference;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
/*

 */
public class EmpQueryParam { //页面查询的传入参数
    private String name;//姓名
    private Integer gender;//性别，1男，2女
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;//入职实践
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //离职时间
    private Integer page = 1; //页数，默认1
    private Integer pageSize; //页面大小，默认10
}
