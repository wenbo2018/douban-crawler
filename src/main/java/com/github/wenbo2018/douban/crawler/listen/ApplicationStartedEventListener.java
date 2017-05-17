package com.github.wenbo2018.douban.crawler.listen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by shenwenbo on 2017/4/14.
 */
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    private static Logger logger= LoggerFactory.getLogger(ApplicationStartedEventListener.class);
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        SpringApplication app = event.getSpringApplication();
        logger.info("==ApplicationStartedEventListener==");
    }


}
