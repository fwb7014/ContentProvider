package com.content.dto;

import java.util.Date;

/**
 * @author shipotian
 * @since 2016/8/10
 */
public class SelectorDto {
    public int selector_id;
    public String selector_name;
    public String parser_list;
    public int state;
    public String remark;
    public Date createtime;

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

    public String getParser_list() {
        return parser_list;
    }

    public void setParser_list(String parser_list) {
        this.parser_list = parser_list;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "SelectorDto{" +
                "selector_id=" + selector_id +
                ", selector_name='" + selector_name + '\'' +
                ", parser_list='" + parser_list + '\'' +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
