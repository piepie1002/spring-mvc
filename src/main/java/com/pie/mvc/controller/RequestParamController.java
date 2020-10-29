package com.pie.mvc.controller;

import com.pie.mvc.dto.UserRequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author LIN
 * @since JDK 1.8
 */
@Controller
public class RequestParamController {
    @GetMapping("/t1")
    @ResponseBody
    public String test1(@RequestParam( value = "user_name") String username){
        System.out.println(username);
        return "requestParam注解的使用"; 
    }
    @PostMapping(value = "t2")
    @ResponseBody
    /*
    * value 当客户端的参数跟方法的参数不一致的时候可以使用
    * required 默认为true,表示必传参数
    * defaultValue 给参数是设置默认值=
    * */
    public String test2(
            @RequestParam(value = "username",required = false)String username,
            @RequestParam(defaultValue = "1",required = false)int page,
            @RequestParam(defaultValue = "10",required = false)int size
    ){
        System.out.println(username+page+size);
        return "requestParam注解的属性使用";
    }
    @PostMapping("/t3")
    @ResponseBody
    public String test3(@RequestBody UserRequestParam param){
        System.out.println(param.toString());
        return "requestBody注解使用";
    }
}
