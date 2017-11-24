package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>Title: BONC -  LogController</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright BONC(c) 2013 - 2025 </p>
 * <p>Company: 北京东方国信科技股份有限公司 </p>
 *
 * @author zhaojie
 * @version 1.0.0
 */
@RestController
public class LogController {
    private final Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/logtest")
    public String writeLog()
    {
        //日志级别从高到底：ERROR、WARN、INFO、DEBUG
        logger.debug("This is a DEBUG message");//DEBUG不会打印，因为root logger的日志级别为INFO
        logger.info("This is an INFO message");
        logger.warn("This is a WARN message");
        logger.error("This is an ERROR message");
        return "OK";
    }
}
