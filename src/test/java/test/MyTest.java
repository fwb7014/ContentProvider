package test;

import com.content.util.CommonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class MyTest {

    @Test
    public void sayHi(){
        System.out.println("11111111111111111111111111111111"+ new Date());
        List<String> list = new ArrayList<String>();
        list.add("1");
        List<Integer> listInt = CommonUtil.convertList(list,Integer.class);
        System.out.println((listInt.get(0)+1));
    }
}
