package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers (Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "getAllUsers";
    }

    @GetMapping(value = "/new")
    public String newUser (Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser (@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "editUser";
    }

    @DeleteMapping(value = "/{id}/delete")
    public String deleteUser (@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newUser";
        }
        userService.createUser(user);
        return "redirect:/";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editUser";
        }
        userService.updateUser(user);
        return "redirect:/";
    }
}
