//package com.enki.cronjob;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalTime;
//
///**
// * @author Enki
// * @ClassName myJob
// * @Description: TODO
// * @Date 2023/10/4 11:04
// * @Version 1.0
// */
//@Component
//public class myJob {
//
//    @Scheduled(cron = "0/5 * * * * ?")//在哪个方法添加了@Scheduled注解，哪个方法就会定时去执行
//    //上面那行@Scheduled注解的cron属性就是具体的定时规则。从每一分钟的0秒开始，每隔5秒钟就会执行下面那行的xxJob()方法
//    public void xxJob(){
//        //要定时执行的代码
//        System.out.println("定时任务执行了，现在的时间是: "+ LocalTime.now());
//    }
//}
