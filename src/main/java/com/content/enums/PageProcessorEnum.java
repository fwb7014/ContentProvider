package com.content.enums;

/**
 * @author shipotian
 * @since 2016/8/11
 */
public enum  PageProcessorEnum{
    NORMAL_PAGE_PROCESSOR(1,"普通页面处理");

    private int type;
    private String msg;
    private PageProcessorEnum(int type,String msg){
        this.setType(type);
        this.setMsg(msg);
    }
    public int getType() {
        return type;
    }

    private void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }
}

