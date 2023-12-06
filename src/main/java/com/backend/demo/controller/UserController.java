package com.backend.demo.controller;

import com.backend.demo.model.User;
import com.backend.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository ;

    @PostMapping(path = "/add")
    public @ResponseBody User addNewUser(@RequestParam String name , @RequestParam int mark){
        User springUser = new User() ;
        springUser.setName(name);
        springUser.setMark(mark);
        userRepository.save(springUser) ;
        return springUser ;
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll() ;
    }

    @GetMapping(path = "/check")
    public String getStatus(){
        return "Server Up And Running" ;
    }
}
