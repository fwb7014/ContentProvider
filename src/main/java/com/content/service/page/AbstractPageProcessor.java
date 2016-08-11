package com.content.service.page;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author shipotian
 * @since 2016/8/11
 */
public abstract  class AbstractPageProcessor implements PageProcessor{

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    public Site site ;

    public abstract void start();

    @Override
    public Site getSite() {
        return site;
    }
}
