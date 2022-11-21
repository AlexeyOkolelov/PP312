package com.pp312.springboot_312.controller;

import com.pp312.springboot_312.model.User;
import com.pp312.springboot_312.servise.UserServise;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    private UserServise userServise;

    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping()
    public String showAllUser(ModelMap model) {
        List<User> messages = userServise.getAllUser();
        model.addAttribute("messages", messages);
        return "users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(ModelMap model) {

        model.addAttribute("messages", new User());
        return "userInfo";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("messages") User user) {

        userServise.add(user);

        return "redirect:/user";
    }

    @DeleteMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServise.deleteUser(id);
        return "redirect:/user";

    }

    @GetMapping("/user-update/{id}")
    public String updateUser(@PathVariable("id") Long id, ModelMap model) {
        User messages = userServise.getUser(id);
        model.addAttribute("messages", messages);
        return "userInfo";
    }


}
