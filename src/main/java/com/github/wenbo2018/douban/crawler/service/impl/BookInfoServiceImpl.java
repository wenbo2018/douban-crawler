package com.github.wenbo2018.douban.crawler.service.impl;

import com.github.wenbo2018.douban.crawler.dao.BookInfoDao;
import com.github.wenbo2018.douban.crawler.entity.BookInfo;
import com.github.wenbo2018.douban.crawler.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wenbo.shen on 2017/5/13.
 */
@Component
public class BookInfoServiceImpl implements BookInfoService {
    @Autowired
    private BookInfoDao bookInfoDao;
    @Override
    public int addBookInfo(BookInfo bookInfo) {
        return bookInfoDao.addBookInfo(bookInfo);
    }
}
