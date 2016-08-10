package com.content.controller;

import com.content.service.ProcessorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shipotian
 * @since 2016/8/10
 */

@Controller
@RequestMapping("/")
public class ContentProviderController {
    private final Logger logger = Logger.getLogger(ContentProviderController.class);

    @Autowired
    private ProcessorService processorService;

    @RequestMapping("index.do")
    public void indexMsg() {
        logger.info("你好吗");
        try {
            processorService.doSpiderWork(1);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
        }
    }
}
