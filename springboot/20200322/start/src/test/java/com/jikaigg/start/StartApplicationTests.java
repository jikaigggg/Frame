package com.jikaigg.start;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StartApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {

        System.out.println("\u4e00\u4e2a\u5927\u54e5\u5728\u770b\u4f60!");
        //日志的级别
        //由低到高：
        //可以调整输出的日志级别
        /*logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");*/
    }

}
