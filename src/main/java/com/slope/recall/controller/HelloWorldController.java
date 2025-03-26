package com.slope.recall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.slope.recall.data.Hello;
import com.slope.recall.service.IHelloService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("hello")
public class HelloWorldController {

    // @Autowired // required if no ctor
    private IHelloService helloService; 

    public HelloWorldController(IHelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/")
    public String getHello() {
        return "hello";
    }

    @GetMapping("/dear/{who}")
    public Hello getHelloWho(@PathVariable String who) {
       return helloService.sayHello(who);
    }

    @GetMapping("/whos")
    public List<Hello> getMethodName(@RequestParam String like) {
        return helloService.findWhos(like);
    }
    

}
