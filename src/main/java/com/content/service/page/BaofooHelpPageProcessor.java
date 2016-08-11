package com.content.service.page;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;
import us.codecraft.webmagic.selector.XpathSelector;

import java.util.ArrayList;
import java.util.List;

/**
 * 宝付帮助页面解析
 * Created by Administrator on 2016/8/9.
 */
public class BaofooHelpPageProcessor extends AbstractPageProcessor {

    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {

        // 部分二：定义如何抽取页面信息，并保存下来
        List<String> faq_title = new JsonPathSelector("$.[*].faq_title").selectList(page.getRawText());
        List<String> faq_contentTemp = new JsonPathSelector("$.[*].faq_content").selectList(page.getRawText());
        List<String> faq_content = new ArrayList<String>();
        for(int i = 0;i<faq_contentTemp.size();i++){
            faq_content.add(new XpathSelector("//p/span/text(0)").select(faq_contentTemp.get(i))==null?new XpathSelector("//p/text(0)").select(faq_contentTemp.get(i)):new XpathSelector("//p/span/text(0)").select(faq_contentTemp.get(i)));
        }
        page.putField("faq_title",faq_title);
        page.putField("faq_content",faq_content);

        //System.out.println("XXX"+page.getHtml().getDocument().getElementsByTag("body").html() );
        //page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        //page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
       /* if (page.getResultItems().get("name") == null) {
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));

        // 部分三：从页面发现后续的url地址来抓取
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());*/
        //System.out.println("111"+page.toString());
    }

    @Override
    public void start() {
        this.site= Site.me().setRetryTimes(3).setSleepTime(1000);
        Spider.create(this)
                .addUrl("http://help.baofoo.com/help/listn/10007")
                .addPipeline(new ConsolePipeline())
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}

