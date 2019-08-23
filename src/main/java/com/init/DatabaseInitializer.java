package com.init;

import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

    private UserService userService;

    @Autowired
    public DatabaseInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        User admin = new User("admin@ru",
                "admin",
                "ROLE_ADMIN");
        User user = new User("user@ru",
                "user",
                "ROLE_USER");
        userService.addUser(user);
        userService.addUser(admin);
    }

}
