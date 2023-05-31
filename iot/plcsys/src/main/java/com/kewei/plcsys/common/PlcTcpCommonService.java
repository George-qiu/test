package com.kewei.plcsys.common;


import com.digitalpetri.modbus.FunctionCode;
import com.digitalpetri.modbus.master.ModbusTcpMaster;
import com.digitalpetri.modbus.master.ModbusTcpMasterConfig;
import com.digitalpetri.modbus.requests.WriteSingleRegisterRequest;
import com.digitalpetri.modbus.responses.ModbusResponse;
import com.kewei.plcsys.Constant.ConfigFinal;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class PlcTcpCommonService {

    /**
     * tcp连接对象
     */
    private static ModbusTcpMaster modbusTcpMaster;


    /**
     * 日志记录
     */
    private static final Logger log = Logger.getLogger(PlcTcpCommonService.class);

    public  static Number readTellTable(){

    return null;
    }
    /**
     * 十进制
     */
    public   static String writeCoils(int coilAddress,Boolean flag) {

        return null;
    }



    public static Boolean writeTellTable(int value,int address){
        log.debug("ready write value="+value);
        String initRes = init();
        //如果初始化失败，则立即返回
        if (!ConfigFinal.SUCCESS_CODE.equals(initRes)) {
            return false;
        }
        String writeRes = writeHoldingRegisters(address, value, ConfigFinal.UNIT_ID);
        //如果写入失败，返回
        if (!ConfigFinal.SUCCESS_CODE.equals(writeRes)) {
            return false;
        }
        return true;
    }


    /**
     * @param address 寄存器地址
     * @param value   写入值
     * @param unitId  id
     * @description: 写HoldingRegister数据
     * @return: 结果值
     */
    public static String writeHoldingRegisters(Integer address, Integer value, Integer unitId) {
        ModbusResponse modbusResponse;
        try {
            // 发送单个寄存器数据，一般是无符号16位值：比如10
            CompletableFuture<ModbusResponse> future = modbusTcpMaster.sendRequest(new WriteSingleRegisterRequest(address, value), unitId);

            //获取写入的响应流
            modbusResponse = future.get();
            if (modbusResponse == null) {
                System.out.println("FCSC-ExternalConnection WriteHoldingRegisters：modbusResponse is null ");
                return ConfigFinal.WRITE_FAIL_CODE;
            }
            //获取写入的响应FunctionCode
            FunctionCode functionCode = modbusResponse.getFunctionCode();
            System.out.println("FCSC-ExternalConnection functionCode=" + functionCode + " value=" + value);
            if (functionCode == FunctionCode.WriteSingleRegister) {
                return ConfigFinal.SUCCESS_CODE;
            } else {
                return ConfigFinal.WRITE_FAIL_CODE;
            }
        } catch (Exception e) {
            log.error("ModbusMasterTCP::writeHoldingRegisters - " + e.getMessage() + ",value=" + value + "(0x000002)"
                    + "\r\n" + Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
            return ConfigFinal.EXEC_FAIL_CODE;
        } finally {
            // String releaseRes = release();
            // //如果释放连接失败，返回执行失败
            // if (!SUCCESS_CODE.equals(releaseRes)) {
            //     return releaseRes;
            // }
        }
    }


    /**
     * @description: 初始化连接
     * @param:
     * @return: 结果值
     */
    public static String init() {
        try {
            if (modbusTcpMaster == null) {
                // 创建配置
                ModbusTcpMasterConfig config = new ModbusTcpMasterConfig.Builder(ConfigFinal.IP).setPort(ConfigFinal.PORT).build();
                // 新建连接
                modbusTcpMaster = new ModbusTcpMaster(config);
            }
            return ConfigFinal.SUCCESS_CODE;
        } catch (Exception e) {
            log.error("ModbusMasterTCP::init - " + e.getMessage() + "(0x000001)" +
                    "\r\n" + Arrays.toString(e.getStackTrace()));
            return ConfigFinal.COON_FAIL_CODE;
        }
    }
}
