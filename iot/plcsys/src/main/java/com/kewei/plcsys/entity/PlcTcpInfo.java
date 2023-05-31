package com.kewei.plcsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "plc_tcp_info")
public class PlcTcpInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer type;

    private String info;

    private Date createTime;

    private  String address;
}
