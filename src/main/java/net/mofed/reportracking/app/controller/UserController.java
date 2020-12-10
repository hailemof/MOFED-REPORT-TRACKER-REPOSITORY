package net.mofed.reportracking.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.mofed.reportracking.app.model.Organization;
import net.mofed.reportracking.app.model.User;
import net.mofed.reportracking.app.service.MyUserService;
import net.mofed.reportracking.app.service.OrganizationService;


@Controller

public class UserController {
	@Autowired
	private MyUserService myuserservice;
	@Autowired
	private OrganizationService orgservice;
	
	@GetMapping("/userlists")
	public String  userlists(Model model) {
		List<User> userlist = myuserservice.ListUser();
		List<Organization> orglist = orgservice.getOrganizations();
		model.addAttribute("organizations",orglist);
        model.addAttribute("userlists",userlist);
		return "emcp/user";
	}
	@PostMapping("/userlists/addNew")
	public String addNew( User user) {
		myuserservice.save(user);
		return "redirect:/userlists";
	}
	
	@RequestMapping("userlists/findById")
	@ResponseBody
	public Optional<User> findById(Long id) {
	  return myuserservice.findById(id);	
	}
	
	@RequestMapping(value="/userlists/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(User  user) {
		myuserservice.save(user);
		return "redirect:/userlists";
	
		
	}
	
	@RequestMapping(value="/userlists/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Long id) {
		myuserservice.delete(id);
		return "redirect:/userlists";
	}
}

