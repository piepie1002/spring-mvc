package com.pie.mvc.controller;

import com.pie.mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */

/**
 * REST 风格
 * get     select
 * post    insert
 * put     update
 * delete  delete
 */
@Controller
public class UserController {
    
    @RequestMapping(value = "/list",method = {RequestMethod.GET})
    @ResponseBody
    public List<User>users(){
        return new ArrayList<>();
    }
    @RequestMapping("/user")
    @ResponseBody
    public User user(){
        return new User();
    }
}
