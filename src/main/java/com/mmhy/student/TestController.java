package com.mmhy.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping(value="/postTest",method = RequestMethod.POST)
    public String postTest(){
        return "Post Test!";
    }

    @RequestMapping(value="/postTest2",method = RequestMethod.POST)
    public String postTest2(@RequestBody String name,@RequestBody String password){
        //@RequestBody注解用于将请求体中的json数据转换成对象，并将数据绑定到方法的参数中
        System.out.println(name);
        System.out.println(password);
        return STR."Post Test2! name:\{name} password:\{password}";

    }


    @GetMapping("/test")
    public List<String> test(){
        return List.of("Hello", "welcome", "you");
    }
}