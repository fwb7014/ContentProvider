package com.content.service;

import com.content.dao.ITitleUrlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shipotian
 * @since 2016/8/11
 */
@Component
public class DbOperateFacade {
    @Autowired
    public ITitleUrlDao titleUrlDao;




    private static DbOperateFacade instance;
    public DbOperateFacade(){
        this.instance = this;
    }
    public static DbOperateFacade getInstance(){
        return instance;
    }
}
