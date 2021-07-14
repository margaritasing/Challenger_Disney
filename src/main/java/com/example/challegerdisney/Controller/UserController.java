package com.example.challegerdisney.Controller;


import com.example.challegerdisney.Entity.Username;
import com.example.challegerdisney.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class UserController {
    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/register")
    public String register(@RequestBody Username username){
        return userService.save(username);
    }

    @PostMapping("/auth/login")
    public String login(@RequestParam String email, @RequestParam String token){
        return userService.login(email, token);
    }
}
