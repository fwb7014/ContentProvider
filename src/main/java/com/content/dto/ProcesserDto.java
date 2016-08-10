package com.content.dto;

import java.util.Date;

/**
 * @author shipotian
 * @since 2016/8/10
 */
public class ProcesserDto {
    public int processor_id;
    public String processor_name;
    public String selector_list;
    public int state;
    public Date last_runtime;
    public Date createtime;

    public int getProcessor_id() {
        return processor_id;
    }

    public void setProcessor_id(int processor_id) {
        this.processor_id = processor_id;
    }

    public String getProcessor_name() {
        return processor_name;
    }

    public void setProcessor_name(String processor_name) {
        this.processor_name = processor_name;
    }

    public String getSelector_list() {
        return selector_list;
    }

    public void setSelector_list(String selector_list) {
        this.selector_list = selector_list;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getLast_runtime() {
        return last_runtime;
    }

    public void setLast_runtime(Date last_runtime) {
        this.last_runtime = last_runtime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "ProcesserDto{" +
                "processor_id=" + processor_id +
                ", processor_name='" + processor_name + '\'' +
                ", selector_list='" + selector_list + '\'' +
                ", state=" + state +
                ", last_runtime=" + last_runtime +
                ", createtime=" + createtime +
                '}';
    }
}
