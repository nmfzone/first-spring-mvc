package com.nmfzone.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;


import com.nmfzone.app.model.Developer;
import com.nmfzone.app.model.Skill;
import com.nmfzone.app.repository.DeveloperRepository;
import com.nmfzone.app.repository.SkillRepository;

@Controller
public class DeveloperController {

	@Autowired
	DeveloperRepository repository;

	@Autowired
	SkillRepository skillRepository;

	@RequestMapping("/developer/{id}")
	public String developer(@PathVariable Long id, Model model) {
        model.addAttribute("developer", repository.findOne(id));
        model.addAttribute("skills", skillRepository.findAll());
        return "developer";
	}

    @RequestMapping(value="/developers",method=RequestMethod.GET)
	public String developerList(Model model) {
        model.addAttribute("developers", repository.findAll());
        return "developers";
	}

    @RequestMapping(value="/developers",method=RequestMethod.POST)
	public String developerAdd(@RequestParam String email,
						@RequestParam String firstName, @RequestParam String lastName, Model model) {
        Developer newDeveloper = new Developer();
        newDeveloper.setEmail(email);
        newDeveloper.setFirstName(firstName);
        newDeveloper.setLastName(lastName);
        repository.save(newDeveloper);

        model.addAttribute("developer", newDeveloper);
        model.addAttribute("skills", skillRepository.findAll());
        return "redirect:/developer/" + newDeveloper.getId();
	}

    @RequestMapping(value="/developer/{id}/skills", method=RequestMethod.POST)
	public String developerAddSkill(@PathVariable Long id, @RequestParam Long skillId, Model model) {
    	Skill skill = skillRepository.findOne(skillId);
    	Developer developer = repository.findOne(id);

    	if (developer != null) {
    		if (!developer.hasSkill(skill)) {
    			developer.getSkills().add(skill);
    		}
    		repository.save(developer);
            model.addAttribute("developer", repository.findOne(id));
            model.addAttribute("skills", skillRepository.findAll());
            return "redirect:/developer/" + developer.getId();
    	}

        model.addAttribute("developers", repository.findAll());
        return "redirect:/developers";
    }

}
