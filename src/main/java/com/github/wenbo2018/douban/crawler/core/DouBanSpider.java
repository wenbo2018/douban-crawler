package com.github.wenbo2018.douban.crawler.core;

import com.github.wenbo2018.douban.crawler.entity.BookInfo;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wenbo.shen on 2017/5/13.
 */
@Component
public class DouBanSpider implements PageProcessor {
    private static Logger logger = LoggerFactory.getLogger(DouBanSpider.class);

    @Autowired
    private PageModelPipeline pageModelPipeline;

    private static int size = 0;// 共抓取到的文章数量
    // 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public Site getSite() {
        List<String[]> poolHosts = new ArrayList<String[]>();
        poolHosts.add(new String[]{"username", "password", "101.101.101.101", "8888"});
        poolHosts.add(new String[]{"username", "password", "102.102.102.102", "8888"});
        //httpProxyList输入是IP+PORT, isUseLastProxy是指重启时是否使用上一次的代理配置
        site.setHttpProxyPool(poolHosts, false);
        return site;
    }

    @Override
    public void process(Page page) {
        if (!page.getUrl().regex("https://book.douban.com/subject/\\d+").match()) {
            page.addTargetRequests(page.getHtml().xpath("//div[@id='subject_list']").links()// 限定文章列表获取区域
                    .regex("https://book.douban.com/subject/\\d+")
                    .all());
            List<String> list = page.getHtml().xpath("//div[@class='paginator']").links()// 限定其他列表页获取区域
                    .regex(".*/tag/.*")
                    .all();
            page.addTargetRequests(list);
        } else {
            //抽取信息
            size++;
            BookInfo bookInfo = new BookInfo();
            String bookName = page.getHtml().xpath("//div[@id='wrapper']/h1/span/text()").get();
            logger.info("bookName:{}", bookName);
            String author = page.getHtml().xpath("//div[@id='info']/a/text()").get();
            logger.info("author:{}", author);
            String starStr = page.getHtml().xpath("//div[@class='rating_self clearfix']/strong/text()").get();
            bookInfo.setStar(NumberUtils.toDouble(starStr));
            logger.info("评分:{}", starStr);
            String evaluateCountStr = page.getHtml().xpath("//div[@class='rating_sum']/span/a/span/text()").get();
            logger.info("评价数:{}", evaluateCountStr);
            bookInfo.setEvaluateCount(NumberUtils.toInt(evaluateCountStr));
        }
    }

    public void star() {
        long startTime, endTime;
        startTime = System.currentTimeMillis();

        OOSpider.create(Site.me().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")
                , pageModelPipeline, BookInfo.class)
                .addUrl("https://book.douban.com/tag/程序")
                .thread(5)
                .run();
        endTime = System.currentTimeMillis();
        logger.info("【爬虫结束】共抓取" + size + "篇文章，耗时约" + ((endTime - startTime) / 1000) + "秒，已保存到数据库，请查收！");
    }

}