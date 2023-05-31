package com.kewei.plcsys.request;

import lombok.Data;

/**
 * plc tcp通讯请求参数
 */
@Data
public class TestRequest {

    /**
     * 类型１是寄存器，２是线圈
     */
    public Integer type;

    /**
     * 记录内容
     */
    public  String info;

    /**
     * id
     */
    public  Long id;

}
