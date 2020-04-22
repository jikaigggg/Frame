package com.jikaigg.general;

import java.util.HashMap;

public class KHashMap {
    public static void main(String[] args) {
        yaojikai1();
    }
    public static void yaojikai1(){
        HashMap<String,String> map = new HashMap<>();
        map.put("yao","jikai");
        map.put("shi","mengyu");
        map.put("zhou","runfa");
        /*if (map.get("yao") == "jikai"){
            System.out.println("yaojikai");
        }*/
        map.replace("yao","lala","JIKAI");
        System.out.println(map.get("yao"));
    }
}
