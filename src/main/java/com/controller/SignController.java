package com.controller;

import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.service.UserService;

import static java.util.Objects.nonNull;

@Controller
public class SignController {

    private UserService userService;

    @Autowired
    public SignController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String redirectToSign() {
        return "redirect:/sign";
    }

    @GetMapping(value = "/sign")
    public String view() {
        return "index";
    }

    @PostMapping(value = "/sign")
    public String signIn(@AuthenticationPrincipal User user,
                         Model model) {
        if (nonNull(user)) {
            if (user.getRole().equals("ROLE_ADMIN")) {
                return "redirect:/admin/users";
            } else {
                return "redirect:/user/products";
            }
        } else {
            model.addAttribute("unknown", "The user is not found");
            return "index";
        }
    }

}
