package com.content.dto;

import java.util.Date;

/**
 * @author shipotian
 * @since 2016/8/10
 */
public class ParserDto {
    public int parser_id;
    public String parser_filter;
    public int parser_filter_type;
    public Date createtime;

    public int getParser_id() {
        return parser_id;
    }

    public void setParser_id(int parser_id) {
        this.parser_id = parser_id;
    }

    public String getParser_filter() {
        return parser_filter;
    }

    public void setParser_filter(String parser_filter) {
        this.parser_filter = parser_filter;
    }

    public int getParser_filter_type() {
        return parser_filter_type;
    }

    public void setParser_filter_type(int parser_filter_type) {
        this.parser_filter_type = parser_filter_type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "ParserDto{" +
                "parser_id=" + parser_id +
                ", parser_filter='" + parser_filter + '\'' +
                ", parser_filter_type=" + parser_filter_type +
                ", createtime=" + createtime +
                '}';
    }
}
