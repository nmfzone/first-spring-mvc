package com.nmfzone.app.controller;

import java.util.List;

import com.google.gson.Gson;

// import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.nmfzone.app.service.IUserService;
import com.nmfzone.app.model.User;

@Controller
@RequestMapping("/user")
public class UserController
{

	private static final Gson gson = new Gson();

	// private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private IUserService service;

	@RequestMapping
    public String index(Model model)
	{
        model.addAttribute("title", "List User");
		model.addAttribute("users", service.getAllUser());

		// System.out.println(gson.toJson(model));
		// logger.debug("Model Attribute User");

        return "user/user";
    }

	@RequestMapping(value="/add")
    public String addUser(Model model)
	{
        model.addAttribute("title", "Add User");

        return "user/add";
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult result, final RedirectAttributes redirectAttr)
    {
		if (result.hasErrors()) {
            redirectAttr.addFlashAttribute("message", result.getFieldError().getDefaultMessage());
            return "redirect:/user/add";
        }
		service.saveUser(user);
		redirectAttr.addFlashAttribute("message", "Success Add User!");

        return "redirect:/user";
   }

}
