package com.spring5.practice.controllers;

import com.spring5.practice.dtos.UserDto;
import com.spring5.practice.request.User;
import com.spring5.practice.service.AuthorityService;
import com.spring5.practice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.HashMap;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AuthorityService authorityService;

    @GetMapping("/user/add")
    public String getAddUser(Model model) {
        model.addAttribute("pageTitle", "Add User");
        model.addAttribute("user", new User());
        model.addAttribute("message", "Add a new User");
        var genders = new HashMap<String, String>();
        genders.put("M", "Male");
        genders.put("F", "Female");
        model.addAttribute("genders", genders);
        System.out.println(authorityService.listAllAuthorities().size());
        model.addAttribute("authorities", authorityService.listAllAuthorities());
        return "user/add";

    }

    @PostMapping("/user/add")
    public String addUser(Model model, @ModelAttribute("user") User user, @RequestParam("dob_f") String dob_f) {

        var userDto = new UserDto();
        userDto.setDob(LocalDate.parse(dob_f));
        BeanUtils.copyProperties(user, userDto);
        userService.addUser(userDto);

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
