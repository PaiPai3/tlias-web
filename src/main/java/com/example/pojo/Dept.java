package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Dept {
    private Integer id;
    private String name;
    private LocalDateTime createTime;//驼峰格式映射到下划线格式，记得开启开关
    private LocalDateTime updateTime;

}
