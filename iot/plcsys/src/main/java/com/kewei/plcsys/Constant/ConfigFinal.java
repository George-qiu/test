package com.kewei.plcsys.Constant;

public class ConfigFinal {
    /**
     * modbus ip地址
     */
    public static final String IP = "192.168.6.6";
    /**
     * 端口
     */
    public static final Integer PORT = 502;
    /**
     * modubs从站ID
     */
    public static final Integer UNIT_ID = 1;
    /**
     * 成功代码
     */
    public static final String SUCCESS_CODE = "0x000000";
    /**
     * 与modubs连接异常
     */
    public static final String COON_FAIL_CODE = "0x000001";
    /**
     * 向modubs发送命令执行异常
     */
    public static final String EXEC_FAIL_CODE = "0x000002";

    /**
     * 数据写入失败
     */
    public static final String WRITE_FAIL_CODE = "0x000004";
    public static String LogName = "qiuhai";

}
