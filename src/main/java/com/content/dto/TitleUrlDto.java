package com.content.dto;

import java.util.Date;

/**
 * @author shipotian
 * @since 2016/8/11
 */
public class TitleUrlDto {
    public int id;
    public String author;
    public String title;
    public String url;
    public int state;
    public Date create_time;
    public TitleUrlDto(String author, String title, String url) {
        this.author = author;
        this.title = title;
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
