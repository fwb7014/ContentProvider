package test;

import com.alibaba.fastjson.JSON;
import com.content.form.BaseResult;
import com.content.service.ProcessorService;
import com.content.util.CommonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.codecraft.webmagic.selector.Json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class MyTest2 extends AbstractJUnit4SpringContextTests {
    @Autowired
    private ProcessorService processorService;
    @Test
    public void test(){
        System.out.println("11111111111111111111111111111111"+ new Date());
        processorService.queryAllPageSelectors();
        System.out.println(JSON.toJSONString(processorService.queryAllPageSelectors()));

        System.out.println(JSON.toJSONString(processorService.doSpiderWork(2)));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
