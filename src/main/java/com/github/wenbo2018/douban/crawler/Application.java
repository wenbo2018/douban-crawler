package com.github.wenbo2018.douban.crawler;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by shenwenbo on 2017/4/14.
 */
@SpringBootApplication
@MapperScan("com.github.wenbo2018.dao")
@EnableScheduling
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Application.class);
//        app.addListeners(new ApplicationStartedEventListener());
//        app.addListeners(new MyApplicationEnvironmentPreparedEvent());
        app.run(args);
    }

}
