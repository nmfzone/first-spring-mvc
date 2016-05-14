package com.nmfzone.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController
{

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String index()
    {
        return "login";
    }

}
