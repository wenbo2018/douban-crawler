package com.github.wenbo2018.douban.crawler.core;

import com.github.wenbo2018.douban.crawler.entity.BookInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;


/**
 * Created by wenbo.shen on 2017/5/13.
 */
public class DouBanSpider implements PageProcessor {
    Logger logger= LoggerFactory.getLogger(DouBanSpider.class);
    private static int size = 0;// 共抓取到的文章数量
    // 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    @Override
    public Site getSite() {
        return site;
    }
    @Override
    public void process(Page page) {
        if (!page.getUrl().regex("https://book.douban.com/subject/\\d").match()) {
            page.addTargetRequests(page.getHtml().xpath("//div[@class='subject_list']").links()// 限定文章列表获取区域
                    .regex("https://book.douban.com/subject/\\d+")
                    .all());
            List<String> list = page.getHtml().xpath("//div[@class='paginator']").links()// 限定其他列表页获取区域
                    .regex(".*/tag/.*")
                    .all();
            page.addTargetRequests(list);
        } else {
            //抽取信息
            size++;
//            BookInfo bookInfo=new BookInfo();
            String title=page.getHtml().xpath("//div[@id='wrapper']/h1/span/text()").get();
            System.out.println(title);
        }
    }
    public static void main(String[] args) {
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        // 从用户博客首页开始抓，开启5个线程，启动爬虫
        Spider.create(new DouBanSpider())
                .addUrl("https://book.douban.com/tag/程序")
                .thread(5)
                .addPipeline(new JsonFilePipeline())
                .run();
        endTime = System.currentTimeMillis();
        System.out.println("【爬虫结束】共抓取" + size + "篇文章，耗时约" + ((endTime - startTime) / 1000) + "秒，已保存到数据库，请查收！");

    }

}