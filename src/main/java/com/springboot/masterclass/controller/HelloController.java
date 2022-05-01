package com.springboot.masterclass.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

     private String msg;

    public HelloController(@Value("${welcome.msg}") String msg) {
        this.msg = msg;
    }

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String helloWorld() {
        return msg;

    }


}
