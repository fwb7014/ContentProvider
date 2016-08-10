package com.content.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class CommonUtil {

    public static <T extends  Number> List<T> convertList(List<String> list,Class<T> t){
        if(list == null)
            return null;
        List result = new ArrayList();
        for(String obj :list){
            if("Integer".equals(t.getSimpleName())){
                result.add((Integer)(Integer.parseInt(obj)));
            }
        }
        return result;
    }
}
