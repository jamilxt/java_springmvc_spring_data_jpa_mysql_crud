package com.spring5.practice.controllers;

import com.spring5.practice.model.Authority;
import com.spring5.practice.model.User;
import com.spring5.practice.repositories.UserRepository;
import com.spring5.practice.service.AuthorityService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.Set;

// For showing index.jsp instead of showing the "not found page" error
@Controller
public class RootController {

    private final UserRepository userRepository;
    private final AuthorityService authorityService;
    private final PasswordEncoder passwordEncoder;

    public RootController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityService authorityService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(name = "error", required = false) String error) {
        generateRoles();
        generateUsers();
        model.addAttribute("pageTitle", "Login");
        model.addAttribute("error", error);
        return "auth/login";
    }

    @GetMapping("/403")
    public String _403() {
        return "403";
    }

    private void generateRoles() {
        authorityService.create(new Authority(System.nanoTime(), "ROLE_ADMIN"));
        authorityService.create(new Authority(System.nanoTime(), "ROLE_USER"));
        authorityService.create(new Authority(System.nanoTime(), "ROLE_PREMIUM_USER"));
    }

    private void generateUsers() {

        if (userRepository.findByUsername("admin").isEmpty()) {
            var user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("secret"));
            Set<Authority> authorities = new HashSet<>();
            authorities.add(authorityService.findByRoleName("ROLE_ADMIN"));
            user.setAuthorities(authorities);
            userRepository.save(user);
        }

        if (userRepository.findByUsername("user").isEmpty()) {
            var user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("secret"));
            Set<Authority> authorities = new HashSet<>();
            authorities.add(authorityService.findByRoleName("ROLE_USER"));
            user.setAuthorities(authorities);
            userRepository.save(user);
        }

        if (userRepository.findByUsername("premium_user").isEmpty()) {
            var user = new User();
            user.setUsername("premium_user");
            user.setPassword(passwordEncoder.encode("secret"));
            Set<Authority> authorities = new HashSet<>();
            authorities.add(authorityService.findByRoleName("ROLE_USER"));
            authorities.add(authorityService.findByRoleName("ROLE_PREMIUM_USER"));
            user.setAuthorities(authorities);
            userRepository.save(user);
        }
    }

    @GetMapping("/edit_profile")
    public String editProfile(Model model) {
        model.addAttribute("pageTitle", "Edit Profile");
        return "profile/edit";
    }

}
