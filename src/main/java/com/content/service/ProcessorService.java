package com.content.service;

import com.content.dao.IParserDao;
import com.content.dao.IProcessorDao;
import com.content.dao.ISelectorDao;
import com.content.dto.ProcesserDto;
import com.content.dto.SelectorDto;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private IProcessorDao iProcessorDao;
    @Autowired
    private ISelectorDao iSelectorDao;
    @Autowired
    private IParserDao iParserDao;

    public void test(){
        ProcesserDto processerDto =  iProcessorDao.selectByID(1);
        logger.info(processerDto);

        List<String> temp = Arrays.asList(processerDto.getSelector_list().split(","));
        List<Integer> ids = new ArrayList<Integer>();
        for(String str:temp)
            ids.add(Integer.parseInt(str));

        List<SelectorDto> selectorList = iSelectorDao.selectAllByIDs(ids);
        System.out.println(selectorList);
    }
}
