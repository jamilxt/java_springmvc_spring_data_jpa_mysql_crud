package com.spring5.practice.service;

import com.spring5.practice.dtos.UserDto;
import com.spring5.practice.exceptions.ResourceAlreadyExistsException;
import com.spring5.practice.model.Authority;
import com.spring5.practice.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityService authorityService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var userFromDb = userRepository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with this email address."));

//        Set<GrantedAuthority> authorities = new java.util.ArrayList<>(Collections.emptyList()); // jamilxt
        var authorities = userFromDb.getAuthorities();
        // mainul35
        // after adding multiple roles - these are not working properly
        // I think this is important to grant roles
//        authorities.add((GrantedAuthority) () -> userFromDb.getRole().name()); // mainul35

        return new User(userFromDb.getUsername(), userFromDb.getPassword(), authorities); // This User class is from  Spring Security. Since we did not implement UserDetails interface from SpringSecurity, therefore we are creating an instance of Spring Security provided User class.
    }

    public List<com.spring5.practice.model.User> showAll() {
        return userRepository.findAllByActiveIsTrue();
    }

    public void addUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isEmpty()) {

            var userEntity = new com.spring5.practice.model.User();
            BeanUtils.copyProperties(userDto, userEntity);
            userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));

            Set<Authority> authorities = new HashSet<Authority>();
            for (var authorityName : userDto.getAuthorityNames()) {
                var authority = authorityService.findByRoleName(authorityName);
                authorities.add(authority);
            }
            userEntity.setAuthorities(authorities);

            userRepository.save(userEntity);

        } else {
            throw new ResourceAlreadyExistsException("Username is unavailable");
        }
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId); // will be converted to soft delete
    }

    public String searchUser(String username) {
        if (userRepository.findByUsername(username).isEmpty()) {
            return "Available";
        } else {
            return "Not available";
        }
    }
}