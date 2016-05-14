package com.nmfzone.app.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SettingsController implements ErrorController
{

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error(Model model)
    {
        model.addAttribute("title", "Page not found");
        return "errors/404";
    }

    @Override
    public String getErrorPath()
    {
        return PATH;
    }

}
