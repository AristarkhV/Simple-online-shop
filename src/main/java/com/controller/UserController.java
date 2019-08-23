package com.controller;

import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.service.UserService;

import java.util.Optional;

import static java.util.Objects.nonNull;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    private UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user,
                          Model model) {
        try {
            userService.addUser(user);
            return "redirect:/admin/users";
        } catch (NumberFormatException ex) {
            model.addAttribute("validFields", "It isn't rightly. Enter the correct values.");
            return "add_user";
        }
    }

    @GetMapping("/add")
    public ModelAndView viewAddUserPage() {
        return new ModelAndView("add_user", "user", new User());
    }

    @ModelAttribute
    @PostMapping("/update")
    public ModelAndView updateUser(@AuthenticationPrincipal User user,
                                   Model model) {
        try {
            userService.updateUser(user);
            return new ModelAndView("redirect:/admin/users");
        } catch (NumberFormatException ex) {
            model.addAttribute("validValues", "Something is wrong. Try again. ");
            return new ModelAndView("edit_user");
        }
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("id") Long id,
                             Model model) {
        if (nonNull(id)) {
            Optional<User> optUser = userService.getById(id);
            model.addAttribute("id", id);
            if (optUser.isPresent()) {
                User user = optUser.get();
                model.addAttribute("user", user);
                return "edit_user";
            }
        }
        return "edit_user";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        if (nonNull(id)) {
            Optional<User> optUser = userService.getById(id);
            optUser.ifPresent(userService::deleteUser);
        }
        return "redirect:/admin/users";
    }

}
