package com.content.dto;

import java.util.Date;
import java.util.List;

/**
 * @author shipotian
 * @since 2016/8/10
 */
public class SelectorDto {
    public int selector_id;
    public String selector_name;
    public Date last_runtime;
    public Date create_time;
    public String class_name;

    public int getSelector_id() {
        return selector_id;
    }

    public void setSelector_id(int selector_id) {
        this.selector_id = selector_id;
    }

    public String getSelector_name() {
        return selector_name;
    }

    public void setSelector_name(String selector_name) {
        this.selector_name = selector_name;
    }

    public Date getLast_runtime() {
        return last_runtime;
    }

    public void setLast_runtime(Date last_runtime) {
        this.last_runtime = last_runtime;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "SelectorDto{" +
                "selector_id=" + selector_id +
                ", selector_name='" + selector_name + '\'' +
                ", last_runtime=" + last_runtime +
                ", create_time=" + create_time +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}
