package com.xzs.phone_store_springboot.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneUtil {
    public static List<Map<String,String>> createTag(String tag){
        String[] tags = tag.split("&");//数据库里多个标签的数据是以&分隔来表示
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map;
        for (String s : tags) {
            map = new HashMap<>();
            map.put("name",s);
            list.add(map);
        }
        return list;
    }
}
