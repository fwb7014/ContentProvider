package com.content.service.page;

import com.content.dto.TitleUrlDto;
import com.content.service.DbOperateFacade;
import com.content.service.pipeline.TitleUrlDbPipeline;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.JsonPathSelector;
import us.codecraft.webmagic.selector.XpathSelector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 知乎MrColin
 * Created by Administrator on 2016/8/9.
 */
public class ZhihuMrColinPageProcessor extends AbstractPageProcessor {

    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {

        // 部分二：定义如何抽取页面信息，并保存下来
        List<String> list = page.getHtml().xpath("//a[@class=post-link]").all();
        List<TitleUrlDto> resultList = new ArrayList<TitleUrlDto>();
        for(int i = 0;i<list.size();i++){
            String ahtml = list.get(i);
            Elements element = Html.create(ahtml).getDocument().getElementsByTag("a");
            resultList.add(new TitleUrlDto("MrColin",element.html(),element.attr("href")));
        }
        page.putField("result",resultList);
    }

    @Override
    public void start() {
        this.site= Site.me().setRetryTimes(3).setSleepTime(1000);
        Spider.create(this)
                .addUrl("http://www.zhihu.com/people/MrColin/posts")
                .addPipeline(new TitleUrlDbPipeline(DbOperateFacade.getInstance().titleUrlDao))
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
    public static void main(String[] args){
        new ZhihuMrColinPageProcessor().start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

