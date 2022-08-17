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

    @GetMapping(value = "/")
    public String printUsers (Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/new")
    public String newUser (Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser (@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "edit";
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteUser (@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }
    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.add(user);
        return "redirect:/";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") long id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        user.setId(id);
        userService.update(user);
        return "redirect:/";
    }
}
