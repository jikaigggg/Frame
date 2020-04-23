package com.jikaigg.general;

import java.util.HashMap;

public class KHashMap {
    public static void main(String[] args) {
        yaojikai1();
    }
    public static void yaojikai1(){
        HashMap<String,String> map = new HashMap<>();
        // put()存操作
        map.put("yao","jikai");
        map.put("shi","mengyu");
        map.put("zhou","runfa");
        // get()取操作
        System.out.println(map.get("yao"));
        // key oldValue 都对得上，oldValue替换为newValue，否则返回false
        map.replace("yao","lala","JIKAI");
        //clear()清空map
        map.clear();
        // isEmpty()判断此map是否为空
        System.out.println(map.isEmpty());


    }
}
