package com.github.wenbo2018.douban.crawler;


import com.github.wenbo2018.douban.crawler.core.DouBanSpider;
import com.github.wenbo2018.douban.crawler.listen.ApplicationStartedEventListener;
import com.github.wenbo2018.douban.crawler.utils.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by shenwenbo on 2017/4/14.
 */
@SpringBootApplication
@MapperScan("com.github.wenbo2018.douban.crawler.dao")
@EnableScheduling
public class Application implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Application.class);
         app.addListeners(new ApplicationStartedEventListener());
//        app.addListeners(new MyApplicationEnvironmentPreparedEvent());
        app.run(args);
        DouBanSpider douBanSpider= SpringUtil.getBean(DouBanSpider.class);
        douBanSpider.star();
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(8000);
    }
}
