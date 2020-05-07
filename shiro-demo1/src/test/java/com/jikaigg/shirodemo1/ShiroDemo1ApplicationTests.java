package com.jikaigg.shirodemo1;

import com.jikaigg.shirodemo1.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class ShiroDemo1ApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        Jedis jedis = new Jedis("localhost");
        jedis.set("shi1","mengyu1");
    }

}
