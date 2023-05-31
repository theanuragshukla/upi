package com.anurag.upi.Controller;

import com.anurag.upi.Entities.UsersEntity;
import com.anurag.upi.Utils.RandomStringGenerator;
import com.anurag.upi.repositories.UserRepository;
import com.anurag.upi.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/users")
@RestController
public class UserController {

    private static class NewUser {
        private final String name;
        public String getName() {
            return name;
        }
        public NewUser(@JsonProperty("name") String name) {
            this.name = name;
        }

    }
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UsersEntity> getUser(){
        return userRepository.findAll();
    }

@PostMapping("/add")
    public String addUser(@RequestBody NewUser user){
        UsersEntity newUser = new UsersEntity();
        newUser.setName(user.getName());
        newUser.setCreatedOn(String.valueOf(System.currentTimeMillis()));
        String username = new RandomStringGenerator().generate(16);
        newUser.setUserId("NJ8945JTRIK67CTU");
        System.out.println(username);
        if(newUser.getUserId()==null){
            System.out.println("userid is null");
            return "userid is null";
        }
        userRepository.save(newUser);
        return "Hello "+ user.getName();
    }
}
