package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzQueryParam {
    private String name;//班级姓名
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;//开始日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate end;//结束日期
    private Integer page;//页面数
    private Integer pageSize;//页面大小
}
