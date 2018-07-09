package com.derhede.taoke.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: taoke
 * @description: 页面跳转控制器
 * @author: ziyichen
 * @create: 2018-07-09 10:58
 **/
@RestController
public class ViewController {

    /**
     * 首页
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/index");
        return modelAndView;
    }

}
