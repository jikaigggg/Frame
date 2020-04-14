package com.jikaigg.blog;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

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
    }

}
