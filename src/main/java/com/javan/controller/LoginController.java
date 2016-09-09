package com.javan.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javan.entity.UserBean;
import com.javan.service.ILoginService;
@Controller
@RequestMapping("login")
public class LoginController {
	private Logger log = Logger.getLogger(this.getClass());
    
    @Resource
    private ILoginService loginServiceImpl;
    
    @RequestMapping(params = "reqCode=login")
    public ModelAndView login(HttpServletRequest req,UserBean user){
        log.info(user);
        
        ModelAndView mv = new ModelAndView();
        UserBean u=loginServiceImpl.Login(user.getUsername(), user.getPassword());
    
        if(u != null){
                    
            req.getSession().setAttribute("user", u);
            mv.addObject("password", u.getPassword());
            System.out.println(u.getPassword());
        }
        mv.setViewName("index");
        return mv;
    }
}
