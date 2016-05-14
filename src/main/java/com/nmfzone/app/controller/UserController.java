package com.nmfzone.app.controller;

// import com.google.gson.Gson;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nmfzone.app.model.User;
import com.nmfzone.app.service.UserService;

@Controller
@RequestMapping("/user")
@Secured("USER")

public class UserController
{

	// public static final Gson gson = new Gson();

	@Autowired
	private UserService service;

	@RequestMapping
	public String index(Model model, Principal principal)
	{
	    model.addAttribute("title", "List User");
		model.addAttribute("users", service.getAll());
		model.addAttribute("deleteUser", new User());

		// System.out.println(gson.toJson(principal));
		// System.out.println(gson.toJson(model));
		// logger.debug("Model Attribute User");

	    return "user/user";
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addUser(Model model)
	{
	    model.addAttribute("title", "Add User");
		model.addAttribute("user", new User());

	    return "user/add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result, final RedirectAttributes redirectAttr)
	{
		if(result.hasErrors()) {
			redirectAttr.addFlashAttribute("error", true);
	        redirectAttr.addFlashAttribute("message", result.getFieldError().getDefaultMessage());
	        return "redirect:/user/add";
	    }
		service.create(user);
		redirectAttr.addFlashAttribute("success", true);
		redirectAttr.addFlashAttribute("message", "Success add user!");

	    return "redirect:/user";
	}

	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public String editUser(@PathVariable("userId") Long userId, Model model, User user)
	{
		user = service.findById(userId);
		if(user == null) {
			model.addAttribute("title", "User not found");
			model.addAttribute("message", "User with id " + userId + " not found!");
			return "errors/404";
		}
		model.addAttribute("title", "Edit User");
		model.addAttribute("editUser", user);

		return "user/edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("editUser") User editUser, BindingResult result, final RedirectAttributes redirectAttr)
	{
		if(result.hasErrors()) {
			redirectAttr.addFlashAttribute("error", true);
			redirectAttr.addFlashAttribute("message", result.getFieldError().getDefaultMessage());
			return "redirect:/user/edit/" + Long.toString(editUser.getId());
		}
		service.update(editUser);
		redirectAttr.addFlashAttribute("success", true);
		redirectAttr.addFlashAttribute("message", "Success edit user!");

		return "redirect:/user";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
 	public String deleteUser(@ModelAttribute("deleteUser") User deleteUser, BindingResult result, final RedirectAttributes redirectAttr)
	{
 		if(!result.hasErrors()) {
 			service.deleteById(deleteUser.getId());
			redirectAttr.addFlashAttribute("success", true);
 			redirectAttr.addFlashAttribute("message", "Success delete user!");
 		} else {
 			redirectAttr.addFlashAttribute("error", true);
 			redirectAttr.addFlashAttribute("message", "Can't delete user. Something went wrong.");
 		}

 		return "redirect:/user";
 	}

}
