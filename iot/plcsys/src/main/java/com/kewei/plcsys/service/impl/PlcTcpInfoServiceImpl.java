package com.kewei.plcsys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kewei.plcsys.entity.PlcTcpInfo;
import com.kewei.plcsys.mapper.PlcTcpInfoMapper;
import com.kewei.plcsys.service.PlcTcpInfoService;
import org.springframework.stereotype.Service;


@Service
public class PlcTcpInfoServiceImpl extends ServiceImpl<PlcTcpInfoMapper, PlcTcpInfo> implements PlcTcpInfoService {
}
