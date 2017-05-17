package com.github.wenbo2018.douban.crawler.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wenbo.shen on 2017/5/13.
 */
@Getter
@Setter
@ToString
public class BookInfo implements Serializable{

    private static final long serialVersionUID = 5491048434606921773L;
    private int id;
    private String bookName;
    private String author;
    private String press;
    private String pressTime;
    private double price;
    private String isbn;
    private double star;
    private int evaluateCount;
    private int BookType;
    private Date addTime;
    private Date updateTime;

}
