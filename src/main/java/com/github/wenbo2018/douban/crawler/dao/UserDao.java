package com.github.wenbo2018.douban.crawler.dao;



import com.github.wenbo2018.douban.crawler.entity.User;

import java.util.List;

/**
 * Created by shenwenbo on 2017/2/15.
 */
public interface UserDao {


    public void add(User user);

    public User load(int userId);

    public User loadByUserName(String username);

    public void delete(int userId);

    public void update(User user);

    List<User> list();

    User queryByUserNameAndPassWord(String username, String password);

}
