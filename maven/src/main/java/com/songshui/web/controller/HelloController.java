package com.songshui.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = HelloController.DIR)
public class HelloController {
	
	public static final String DIR = "/hello";

    @RequestMapping(value = "test.do")
    public ModelAndView test() {
    	System.out.println("11111111");
    
        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        return model;
    }
    
    @RequestMapping(value = "test2.do")
    public ModelAndView test2() {
    	System.out.println("222222222");
        ModelAndView model = new ModelAndView();
        model.setViewName("hello2");
        return model;
    }
}
