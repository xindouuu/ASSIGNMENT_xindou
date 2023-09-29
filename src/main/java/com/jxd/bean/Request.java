package com.jxd.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("Request")
public class Request {
    //    indicate primary key and type is auto-increment
    @TableId(type = IdType.AUTO)
    private Integer request_id;
    private Integer client_id;
    private String request_message;
    private String current_status;
    private String assigned_to;
    private Date created_date;
}
