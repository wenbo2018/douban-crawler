package com.github.wenbo2018.douban.crawler.core.pipeline;

import com.github.wenbo2018.douban.crawler.entity.BookInfo;
import com.github.wenbo2018.douban.crawler.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by wenbo.shen on 2017/5/13.
 */
public class BookInfoServicePipeline  implements PageModelPipeline<BookInfo> {

    @Autowired
    private BookInfoService bookInfoService;

    @Override
    public void process(BookInfo bookInfo, Task task) {
        bookInfoService.addBookInfo(bookInfo);
    }

}
