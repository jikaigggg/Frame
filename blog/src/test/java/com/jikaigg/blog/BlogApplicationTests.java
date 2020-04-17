package com.jikaigg.blog;

import com.jikaigg.blog.utils.TimeBeforeUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.print.attribute.HashAttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class BlogApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    public void contextLoads() {
        Class<? extends JdbcTemplate> jdbcTemplateClass = jdbcTemplate.getClass();
        System.out.println(jdbcTemplateClass);
    }

    @Test
    public void okHttpGet() throws IOException {
        String url = "https://www.baidu.com/";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(request);
        System.out.println(response);
        System.out.println(response.code());
    }
    @Test
    public void test3(){
        System.out.println(Math.ceil(3.5f));
        List<String> list = new ArrayList<String>();
        list.add("ji");
        list.add("kai");
        list.add(0,"yao");
        System.out.println(list);
        HashMap<String,String> hashMap = new HashMap<>();
        System.out.println(9 & 8);
        System.out.println(5100/4145.10f);
    }

    @Test
    public void test4(){
        Long time = 1586916621000L;
        System.out.println(System.currentTimeMillis());

        System.out.println(TimeBeforeUtils.beforeTime(time));
    }


}
