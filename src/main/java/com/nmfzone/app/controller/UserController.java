package com.nmfzone.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.nmfzone.app.dao.UserDao;
import com.nmfzone.app.model.User;

@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	UserDao userDao;

	@RequestMapping
    public String save(Model model) {
        model.addAttribute("title", "Add User");
        return "user";
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@RequestParam(value="userName") String userName, @RequestParam(value="age") int age, Model model)
    {
        User user = new User(userName, age);
        userDao.saveUserDetail(user);

        model.addAttribute("message", "Success Add User!");
        return "redirect:/home";
   }
}
