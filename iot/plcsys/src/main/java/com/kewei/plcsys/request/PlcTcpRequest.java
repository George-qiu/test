package com.kewei.plcsys.request;

import lombok.Data;

/**
 * plc tcp通讯请求参数
 */
@Data
public class PlcTcpRequest {

    /**
     * 线圈 ture 亮灯 false 灭灯
     */
    public Boolean flag;

    /**
     * 十进制
     */
    public  int coilAddress;

    /**
     * 寄存器地址
     */
    public  int address;

    /**
     * 寄存器Y0 0 灭灯  1亮灯
     */
    public  int value;
}
