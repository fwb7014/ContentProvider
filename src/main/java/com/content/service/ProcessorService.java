package com.content.service;

import com.content.dao.ISelectorDao;
import com.content.dto.SelectorDto;
import com.content.form.BaseResult;
import com.content.service.page.AbstractPageProcessor;
import com.content.util.CommonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shipotian
 * @since 2016/8/10
 */
@Service
public class ProcessorService {
    private final Logger logger = Logger.getLogger(ProcessorService.class);

    @Autowired
    private ISelectorDao iSelectorDao;

    //查询所有的任务
    public List<SelectorDto> queryAllPageSelectors(){
        return iSelectorDao.selectAll();
    }

    //开始制定任务
    public BaseResult doSpiderWork(int selectorId){
        SelectorDto selectorDTO = iSelectorDao.selectByID(selectorId);
        if(selectorDTO == null)
            new BaseResult(BaseResult.CODE_FAIL,"无效的任务ID");

        String className = selectorDTO.getClass_name();

        try {
            Class<AbstractPageProcessor> targetClass = (Class<AbstractPageProcessor>)Class.forName(className);
            targetClass.newInstance().start();
            return new BaseResult(BaseResult.CODE_SUCCESS,"");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("启动任务失败",e);
            return new BaseResult(BaseResult.CODE_FAIL,"任务启动失败");
        }
    }
}
