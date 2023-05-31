package com.kewei.plcsys.common;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 定时任务控制器
 */
@Component
@EnableScheduling
public class JobController {

    @Scheduled(cron = "0/2 * * * * ?")
    public void test(){
        System.out.println("--启动任务了-----");
    }


}
