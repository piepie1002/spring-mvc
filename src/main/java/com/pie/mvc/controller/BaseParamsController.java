package com.pie.mvc.controller;

/**
 * @author LIN
 * @since JDK 1.8
 */

import com.pie.mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 如何接受参数
 * 1>接收基本类型的参数
 * 2>对象(简单对象  复制对象)
 * 3>map 数组 集合(list)
 * 4>日期
 */
@Controller
public class BaseParamsController {
    @GetMapping("/test1")
    @ResponseBody
    public String test(String username ,int id){
        System.out.println(username);
        System.out.println(id);
        User user = new User();
        user.setName(username);
        user.setUid(id);
        return username;
    }
}
