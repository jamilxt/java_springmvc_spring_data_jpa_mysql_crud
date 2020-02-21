package com.spring5.practice.controllers;

import com.spring5.practice.enums.Role;
import com.spring5.practice.model.User;
import com.spring5.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/add")
    public String getAddUser(Model model) {
        model.addAttribute("pageTitle", "Add User");
        model.addAttribute("user", new User());
        model.addAttribute("message", "Add a new User");
        var roles = new HashMap<Role, String>();
        roles.put(Role.ROLE_ADMIN, "ADMIN");
        roles.put(Role.ROLE_USER, "USER");
        model.addAttribute("roles", roles);
        return "user/add";

    }

    @PostMapping("/user/add")
    public String addUser(Model model, @ModelAttribute(name = "user") User user) {
        userService.addUser(user);
        model.addAttribute("message", "User added successfully");
        return "redirect:/user/show-all";

    }

    @GetMapping("/user/show-all")
    public String showAllUser(Model model) {

        model.addAttribute("pageTitle", "Users List");
        model.addAttribute("users", userService.showAll());
        model.addAttribute("message", "Showing all users...");
        return "/user/show-all";
    }

    @GetMapping("/user/delete")
    public String deleteUser(Model model, @RequestParam("userId") long userId) {

        userService.deleteUser(userId);
        model.addAttribute("message", "User deleted successfully");
        return "redirect:/user/show-all";

    }

}
