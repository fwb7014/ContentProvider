package com.content.service.pipeline;

import com.alibaba.fastjson.JSON;
import com.content.dao.ITitleUrlDao;
import com.content.dto.TitleUrlDto;
import org.apache.log4j.Logger;
import org.apache.maven.plugin.logging.Log;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @author shipotian
 * @since 2016/8/11
 */
public class TitleUrlDbPipeline implements Pipeline{
    public static final Logger logger = Logger.getLogger(TitleUrlDbPipeline.class);
    private ITitleUrlDao dao;
    public TitleUrlDbPipeline(ITitleUrlDao dao){
        this.dao = dao;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<TitleUrlDto> result = resultItems.get("result");
        for(TitleUrlDto dto :result){
            try{
                this.dao.insert(dto);
            }catch(Exception e){
                logger.error("录入数据出现异常"+ JSON.toJSONString(dto),e);
            }
        }
    }
}
