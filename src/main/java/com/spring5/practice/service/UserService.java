package com.spring5.practice.service;

import com.spring5.practice.exceptions.ResourceAlreadyExistsException;
import com.spring5.practice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var userFromDb = userRepository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with this email address."));

        List<GrantedAuthority> authorities = new java.util.ArrayList<>(Collections.emptyList()); // jamilxt

        authorities.add((GrantedAuthority) () -> userFromDb.getRole().name());

        return new User(userFromDb.getUsername(), userFromDb.getPassword(), authorities); // This User class is from  Spring Security. Since we did not implement UserDetails interface from SpringSecurity, therefore we are creating an instance of Spring Security provided User class.
    }

    public List<com.spring5.practice.model.User> showAll() {
        return userRepository.findAllByActiveIsTrue();
    }

    public void addUser(com.spring5.practice.model.User user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            user.setPassword(passwordEncoder.encode("secret"));
            userRepository.save(user);
        } else {
            throw new ResourceAlreadyExistsException("Username is unavailable");
        }
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId); // will be converted to soft delete
    }

}