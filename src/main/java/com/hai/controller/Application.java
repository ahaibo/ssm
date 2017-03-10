package com.hai.controller;

import com.hai.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by as on 2017/3/9.
 */
@Controller("/")
public class Application extends BaseController {

    @RequestMapping("/idx")
    public String index() {
        logger.info(this.getClass().getName() + ".index...");
        return "idx";
    }
}
