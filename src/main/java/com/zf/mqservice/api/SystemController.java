package com.zf.mqservice.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者  zhoufu
 * 日期  2017/5/25.
 */
@Controller
public class SystemController {

    @RequestMapping(value = "/")
    public String root(){
        return "index";
    }
}
