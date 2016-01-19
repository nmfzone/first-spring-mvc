package com.nmfzone.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.nmfzone.app.service.IUserService;
import com.nmfzone.app.model.User;

@Controller
@RequestMapping("/user")
public class UserController
{

	@Autowired
	private IUserService service;

	@RequestMapping
    public String index(Model model)
	{
        model.addAttribute("title", "List User");
		// service.deleteUserById("1");
		model.addAttribute("users", service.getAllUser());
        return "user/user";
    }

	@RequestMapping(value="/add")
    public String addUser(Model model)
	{
        model.addAttribute("title", "Add User");
        return "user/add";
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String addUser(@RequestParam(value="userName") String userName, @RequestParam(value="age") int age, Model model)
    {
        service.saveUser(new User(userName, age));

        model.addAttribute("message", "Success Add User!");
        return "redirect:/user";
   }
}
