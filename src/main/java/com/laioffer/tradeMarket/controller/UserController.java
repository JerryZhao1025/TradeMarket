package com.laioffer.tradeMarket.controller;

import com.laioffer.tradeMarket.entity.User;
import com.laioffer.tradeMarket.service.PostService;
import com.laioffer.tradeMarket.service.TagService;
import com.laioffer.tradeMarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(PostService postService, TagService tagService, UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/user/{username}"}, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public User searchUserByUsername(@PathVariable("username") String username, HttpServletResponse response){
        return userService.getUser(username);
    }

    @RequestMapping(value = {"/visit/{username}"}, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public User searchUserFromVisitorByUsername(@PathVariable("username") String username, HttpServletResponse response){
        return userService.getPartUserInfo(username);
    }

}