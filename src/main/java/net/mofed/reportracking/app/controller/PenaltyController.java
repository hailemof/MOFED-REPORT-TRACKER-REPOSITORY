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

import net.mofed.reportracking.app.model.Penalty;
import net.mofed.reportracking.app.service.PenaltyService;


@Controller
public class PenaltyController {
   
	@Autowired
	private PenaltyService penaltyService;

	@GetMapping("/penaltyrules")
	public String getAllPenalty(Model model) {		
		List<Penalty> penaltyList = penaltyService.getAllPenalty();
		model.addAttribute("penaltyrules", penaltyList);	
		return "emcp/penalty";
	}	
	
	
	@PostMapping("/penaltyrules/addNew")
	public String addNew(Penalty penalty) {
		penaltyService.save(penalty);
		return "redirect:/penaltyrules";
	}
	
	@RequestMapping("penaltyrules/findById")
	@ResponseBody
	public Optional<Penalty> findById(int id) {
	  return penaltyService.findById(id);	
	}	
	
	@RequestMapping(value="/penaltyrules/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Penalty penalty) {
		penaltyService.save(penalty);
		return "redirect:/penaltyrules";
	}
	
	@RequestMapping(value="/penaltyrules/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		penaltyService.delete(id);
		return "redirect:/penaltyrules";
	}
	
	
}
