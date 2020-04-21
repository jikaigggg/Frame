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
        /*Class<? extends JdbcTemplate> jdbcTemplateClass = jdbcTemplate.getClass();
        System.out.println(jdbcTemplateClass);*/
        List<String> l = new ArrayList<>();
        l.add("yaojikai");
        l.add("shimengyu");
        l.add("lalala");
        System.out.println(l);
        System.out.println(l.get(0));
        System.out.println(l.get(3));
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
    public void test3() {
        System.out.println(Math.ceil(3.5f));
        List<String> list = new ArrayList<String>();
        list.add("ji");
        list.add("kai");
        list.add(0, "yao");
        System.out.println(list);
        HashMap<String, String> hashMap = new HashMap<>();
        System.out.println(9 & 8);
        System.out.println(5100 / 4145.10f);
    }

    @Test
    public void test4() {
        //逻辑运算符
        // & 与运算：转换为二进制后，低位对其，全为1为1，其他为0
        //System.out.println(4 & 5);   //0100 & 0101 → 0100   结果为4
        // | 或运算：转换为二进制后，低位对其，全为0为0，其他为1
        //System.out.println(4 | 5);   //0100 & 0101 → 0101   结果为5
        // ^ 异或运算：转换为二进制后，低位对其，一个1一个0为1，全为1或全为0为0
        //System.out.println(4 ^ 5);   //0100 & 0101 → 0001   结果为1
        // ~ 非运算：单目运算符，按位取反
        System.out.println(~4);  //0100 → 1111 1111 1111 1111 1111 1111 1111 1011 然后再进行补码转原码，结果为-5

        //位移运算符
        // <<左移运算符,符号位不变，整体向左移动X位，低位空缺用0补齐
        System.out.println(3 << 1); //0000 0011 → 0000 0110 结果为6
        System.out.println(3 << 2); //0000 0011 → 0000 1100 结果为12
        System.out.println(-3 << 1); //0000 0011 → 0000 0110 结果为-6
        System.out.println(-3 << 2); //0000 0011 → 0000 1100 结果为-12

        // >>右移运算符,符号位不变，整体向右移动X位，高位空缺用0补齐
        System.out.println(3 >> 1); //0000 0011 → 0000 0001 结果为6
        System.out.println(3 >> 2); //0000 0011 → 0000 0000 结果为12
        System.out.println(-3 >> 1); //0000 0011 → 0000 0001 结果为-2
        System.out.println(-3 >> 2); //0000 0011 → 0000 0000 结果为-1


    }


}
