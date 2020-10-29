package com.pie.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LIN
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/user1")
public class ResponseController {
    //api/v1/user1/detail/
    /*
    * 
    * */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id){
        return "...";
    }
    @GetMapping("/list/{page}/{size}")
    public String list(@PathVariable int page,@PathVariable int size){
        return "动态路径";
    }
}
