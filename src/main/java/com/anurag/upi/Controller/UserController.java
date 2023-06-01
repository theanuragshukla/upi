package com.anurag.upi.Controller;

import com.anurag.upi.Entities.UsersEntity;
import com.anurag.upi.Utils.RandomStringGenerator;
import com.anurag.upi.modals.NewUser;
import com.anurag.upi.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService){
        this.usersService = usersService;
    }
    @GetMapping
    public List<UsersEntity> getUser(){
        return usersService.getAllUsers();
    }

@PostMapping("/add")
    public UsersEntity addUser(@RequestBody NewUser user){
        UsersEntity newUser = new UsersEntity();
        newUser.setName(user.getName());
        newUser.setCreatedOn(String.valueOf(System.currentTimeMillis()));
        String username = new RandomStringGenerator().generate(16);
        newUser.setUserId(username);
        usersService.addNewUser(newUser);
        return newUser;
    }
@PostMapping("/updateAccount")
    public boolean updateUser(@RequestBody Map<String, String> user){
        usersService.updateUserAccount(true, user.get("userId"));
        return true;
}
@PostMapping("/delete")
    public boolean deleteUser(@RequestBody Map<String, String> user){
        usersService.deleteUser(user.get("userId"));
        return true;
}
}
