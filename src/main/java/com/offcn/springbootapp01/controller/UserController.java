package com.offcn.springbootapp01.controller;

import com.offcn.springbootapp01.po.User;
import com.offcn.springbootapp01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String findAll(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id){
        userService.delete(id);
        return "redirect:/user/";
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable(name = "id") Long id,Model model){
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        return "userEdit";
    }

    @RequestMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/user/";
    }


    @RequestMapping("/toAdd")
    public String toAdd(){
        return "userAdd";
    }

    @PostMapping("/add")
    public String save(User user){
        userService.add(user);
        return "redirect:/user/";
    }


}
