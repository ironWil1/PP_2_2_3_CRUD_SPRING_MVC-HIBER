package ru.preproject.crud.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.preproject.crud.model.User;
import ru.preproject.crud.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;
    private long calcId = 0;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public ModelAndView home() {
        List<User> listUsers = userService.getAll();
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("listUsers", listUsers);
        return mav;
    }

    @RequestMapping("/new")
    public String newCustomerForm(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "add_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUserFromForm(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        calcId = id;
        ModelAndView mav = new ModelAndView("edit_form");
        User user = userService.getUser(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/save_edited")
    public String saveEditedUser(@ModelAttribute("user") User user) {
        userService.updateUser(user, calcId);
        return "redirect:/";
    }


}
