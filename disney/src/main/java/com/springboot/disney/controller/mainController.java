
package com.springboot.disney.controller;

import com.springboot.disney.Service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Cortinez Juan José
 */
@RestController
@RequestMapping("/")
public class mainController {
    
     private ModelAndView modelAndView = new ModelAndView();
     
     @Autowired
     private SendMailService sendMailSevice;
     
    @GetMapping("/login")
    public ModelAndView  login(){
       modelAndView.setViewName("login");
        return modelAndView;
    }
     
    
    @GetMapping("/sendMail")
    public ModelAndView  sendMail(){
        modelAndView.setViewName("sendMail");
        return modelAndView;
    }
    
    @PostMapping("/sendMail")
    public ModelAndView sendMail(@RequestParam("name") String name,@RequestParam("mail") String mail,@RequestParam("subject") String subject,@RequestParam("body") String body){
        String message = body + name + mail;
        sendMailSevice.sendMail(body, body, subject, message);
        modelAndView.setViewName("sendMail");
        return modelAndView;
    }
    
    

}
