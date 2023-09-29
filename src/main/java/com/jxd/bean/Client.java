package com.jxd.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("Client")
public class Client {
    //    indicate primary key and type is auto-increment
    @TableId(type = IdType.AUTO)
    private Integer client_id;
    private String name;
    private int age;
    private String address;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birth_date;
    private String company;
}
