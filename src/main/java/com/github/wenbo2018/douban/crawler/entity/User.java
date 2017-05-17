package com.github.wenbo2018.douban.crawler.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by shenwenbo on 2017/4/14.
 */
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = -7091478494529379221L;

    private int id;
    private String username;
    private String password;
    private int au;
    private String email;

    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAu() {
        return au;
    }

    public void setAu(int au) {
        this.au = au;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", au=" + au +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
