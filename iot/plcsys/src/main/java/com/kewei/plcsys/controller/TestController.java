package com.kewei.plcsys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kewei.plcsys.Constant.ConfigFinal;
import com.kewei.plcsys.common.PlcTcpCommonService;
import com.kewei.plcsys.entity.PlcTcpInfo;
import com.kewei.plcsys.request.PlcTcpRequest;
import com.kewei.plcsys.request.TestRequest;
import com.kewei.plcsys.service.PlcTcpInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

//@ApiModel(value = "test测试",description = "描述")
@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class TestController {

    @Resource
    private PlcTcpInfoService infoService;


    @GetMapping("/getList")
    public List<PlcTcpInfo> getList() {
        List<PlcTcpInfo> plcTcpInfoList = infoService.list();
        return plcTcpInfoList;
    }

    @GetMapping("/getOne")
    public PlcTcpInfo getInfo(Long id) {
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
        System.out.println("111111111");
        QueryWrapper<PlcTcpInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        PlcTcpInfo plcTcpInfo = infoService.getOne(wrapper);
        return plcTcpInfo;
    }


    /**
     * 写数据前端测试
     *
     * @param testRequest
     * @return
     */
    @PostMapping("/writeData")
    public boolean writeData(@RequestBody TestRequest testRequest) {
        PlcTcpInfo info  = new PlcTcpInfo();
        info.setType(testRequest.getType());
        info.setInfo(testRequest.getInfo());
        info.setCreateTime(new Date());
        infoService.save(info);
        return true;
    }

    /**
     * 读取寄存器内容并记录到库
     *
     * @return
     */
    @GetMapping("/readDemo")
    public boolean readPLCTellTable() {
        try {
            // 读数据
            Number value = PlcTcpCommonService.readTellTable();
            //写数据
            PlcTcpInfo info = new PlcTcpInfo();
            info.setInfo("" + value);
            info.setType(1);
            infoService.save(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    /**
     * 操作线圈Y1~9 10~14PLC写了程序 访问不通
     * @param plcTcpRequest
     * @return
     */
    @PostMapping("/writeCoilInfo")
    public  boolean writeCoil(@RequestBody PlcTcpRequest plcTcpRequest){
        //先操作PLC
       String result =  PlcTcpCommonService.writeCoils(plcTcpRequest.getCoilAddress(),plcTcpRequest.getFlag());
       if(ConfigFinal.SUCCESS_CODE.equals(result)){
           //后存操作记录
           PlcTcpInfo info = new PlcTcpInfo();
           String infoValue;
           if(plcTcpRequest.getFlag()){
               infoValue = plcTcpRequest.getCoilAddress()+"地址PLC操作亮灯成功";
           }else{
               infoValue = plcTcpRequest.getCoilAddress()+"地址PLC操作灭灯成功";
           }
           info.setInfo("" + infoValue);
           info.setType(2);
           infoService.save(info);
       }
        return  true;
    }


    /**
     * 操作寄存器Y0
     * @param plcTcpRequest
     * @return
     */
    //@ApiOperation(value = "操作寄存器Y0" ,notes = "操作寄存器-描述")
    @PostMapping("/writeTellTable")
    public  boolean writeTellTable(@RequestBody PlcTcpRequest  plcTcpRequest){
        //先操作PLC
        //boolean result =  PlcTcpCommonService.writeTellTable(plcTcpRequest.getValue(),plcTcpRequest.getAddress());
        boolean result =true;
        if(result){
            //后存操作记录
            PlcTcpInfo info = new PlcTcpInfo();
            String infoValue;
            //
            if(plcTcpRequest.getValue() != 0){
                infoValue = plcTcpRequest.getCoilAddress()+"地址PLC操作亮灯成功";
            }else{
                infoValue = plcTcpRequest.getCoilAddress()+"地址PLC操作灭灯成功";
            }
            info.setInfo("" + infoValue);
            info.setType(1);
            info.setCreateTime(new Date());
            infoService.save(info);
        }
        return  true;
    }


}
