package com.content.service;

import com.content.dao.IParserDao;
import com.content.dao.IProcessorDao;
import com.content.dao.ISelectorDao;
import com.content.dto.ParserDto;
import com.content.dto.ProcesserDto;
import com.content.dto.SelectorDto;
import com.content.form.BaseResult;
import com.content.util.CommonUtil;
import org.apache.commons.lang.StringUtils;
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

    //查询所有的任务
    public List<ProcesserDto> queryAllSpiderWorks(){
        return iProcessorDao.selectAll();
    }

    //开始制定任务
    public BaseResult doSpiderWork(int processorId){
        int j = 0;
        int i = 10/j;

        ProcesserDto processerDto =  iProcessorDao.selectByID(processorId);
        if(processerDto == null){
            return new BaseResult(BaseResult.CODE_FAIL,"无效的任务ID");
        }

        List<Integer> ids = CommonUtil.convertList(Arrays.asList(processerDto.getSelector_list().split(",")),Integer.class);

        List<SelectorDto> selectorList = iSelectorDao.selectAllByIDs(ids);
        for(SelectorDto selector:selectorList){
            if(StringUtils.isEmpty(selector.getParser_list())){
                continue;
            }
            selector.parserDtoList= new ArrayList<ParserDto>();
            String[] paraserIds =selector.getParser_list().split(",");
            for(String temp :paraserIds){
                if(StringUtils.isEmpty(temp))
                    continue;
                if(temp.indexOf("[")==-1){
                    ParserDto tempDto = iParserDao.selectByID(Integer.parseInt(temp));
                    if(tempDto != null)
                        selector.parserDtoList.add(tempDto);
                }else{
                    ParserDto tempDtoParent = iParserDao.selectByID(Integer.parseInt(temp.substring(0,temp.indexOf("["))));
                    if(tempDtoParent == null)
                        continue;
                    tempDtoParent.optionParserDtoList = new ArrayList<ParserDto>();
                    selector.parserDtoList.add(tempDtoParent);
                    //替代的
                    String[] optionParserIds = temp.substring(temp.indexOf("[")+1,temp.length()-1).split(",");
                    for(String subIDs :optionParserIds){
                        ParserDto tempDto = iParserDao.selectByID(Integer.parseInt(subIDs));
                        if(tempDto != null)
                            tempDtoParent.optionParserDtoList.add(tempDto);
                    }
                }
            }
        }
        processerDto.selectorDtoList = selectorList;

        System.out.println("测试结果"+processerDto);

        return new BaseResult(BaseResult.CODE_SUCCESS,"操作成功");
    }

}
