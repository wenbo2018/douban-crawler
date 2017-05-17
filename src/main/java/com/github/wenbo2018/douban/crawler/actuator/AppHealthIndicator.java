package com.github.wenbo2018.douban.crawler.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by shenwenbo on 2017/4/14.
 */
@Component
public class AppHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().build();
    }
}
