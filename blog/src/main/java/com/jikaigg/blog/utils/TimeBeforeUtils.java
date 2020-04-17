package com.jikaigg.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeBeforeUtils {
    public static String beforeTime(Long time){
        String str = null;
        //计算当前时间与历史事件的毫秒差值
        Long num = (System.currentTimeMillis() - time) / 1000 / 60;
        System.out.println(num);
        if (num > 0  && num < 60){
            str = num + "分钟前";
        }
        if (num>=60 && num<(60 *24)){
            str = num/60 + "小时前";
        }
        if (num>=(60*24)){
            str = num/60/24 +"天前";
        }
        return str;
    }
}
