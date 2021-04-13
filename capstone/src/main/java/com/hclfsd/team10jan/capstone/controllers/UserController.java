package com.hclfsd.team10jan.capstone.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hclfsd.team10jan.capstone.entities.User;
import com.hclfsd.team10jan.capstone.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"/", "/login"})
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String registration(ModelMap model){
	  User user = new User();
	  model.addAttribute("user", user);
	  return "registration";
	 }
	  
	@PostMapping(value = "/registration")
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
	    ModelAndView modelAndView = new ModelAndView();
	    User userExists = userService.findUserByUserName(user.getUsername());
	    if (userExists != null) {
	        bindingResult
	                .rejectValue("userName", "error.user",
	                        "There is already a user registered with the user name provided");
	    }
	    if (bindingResult.hasErrors()) {
	        modelAndView.setViewName("registration");
	    } else {
	        userService.registerUser(user);
	        modelAndView.addObject("successMessage", "User has been registered successfully! Login now");
	        modelAndView.addObject("user", new User());
	        modelAndView.setViewName("registration");
	
	    }
	    return modelAndView;
	}
	
	@GetMapping("/home")
	public String getHomePage(ModelMap model, Principal principal, HttpServletRequest request) {
		String username = principal.getName();
		User user = userService.findUserByUserName(username);
		model.addAttribute("user", user);
		if (request.isUserInRole("ROLE_ADMIN")) {
            return "homeAdmin";
        }
        return "home";
	}
}
