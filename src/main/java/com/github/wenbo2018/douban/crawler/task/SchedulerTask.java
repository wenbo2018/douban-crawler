package com.github.wenbo2018.douban.crawler.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shenwenbo on 2017/4/14.
 */
@Component
public class SchedulerTask {
    private Logger logger= LoggerFactory.getLogger(SchedulerTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        logger.info("现在时间：" + dateFormat.format(new Date()));
    }
}
