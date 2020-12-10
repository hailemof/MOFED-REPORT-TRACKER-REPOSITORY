package net.mofed.reportracking.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.mofed.reportracking.app.service.MyUserService;



@Controller
public class UserProfileController {

	@Autowired
    private MyUserService myuserservice;
	
	@GetMapping("/profile")
	
	public String userprofile(Model model ,Principal principal) {
		String un = principal.getName();
		model.addAttribute("user",myuserservice.findByUsername(un) );
		System.out.println(un);
		
		return "emcp/profile";
		
	}
	  
	  
	
}
