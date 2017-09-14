package com.libertymutual.goforcode.invoicify.controllers;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.invoicify.models.User;
import com.libertymutual.goforcode.invoicify.repositories.UserRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private UserRepository userRepo;
	private PasswordEncoder encoder;
	
	public HomeController(UserRepository userRepo, PasswordEncoder encoder) {
		this.userRepo = userRepo;
		this.encoder = encoder;
	}
	
	@GetMapping("")
	public String home() {
		return "home/default";
	}
	
	@GetMapping("logging_in")
	public String login() {
		return "logging_in";
	}
	
	@GetMapping("signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView("home/signup");
		return mv;
	}
	
	@PostMapping("signup")
	public ModelAndView handleSignup(User user) {
		//refactor
		String password = user.getPassword();
		String encryptedPassword = encoder.encode(password);
		user.setPassword(encryptedPassword);
		
		try {
			userRepo.save(user);
		} catch (DataIntegrityViolationException dive) {
			ModelAndView mv = new ModelAndView("home/signup");
			mv.addObject("errorMessage", "Cannot sign up with that username, please try again");
			return mv;
		}
		
		ModelAndView mv = new ModelAndView("redirect:/logging_in");
		return mv;
	}

}
