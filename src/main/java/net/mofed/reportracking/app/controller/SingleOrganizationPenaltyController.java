package net.mofed.reportracking.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class SingleOrganizationPenaltyController {
	
	@GetMapping("/singleorganizationpenalties")
	public String getOrganizationPenalty() {
		return "singleorganizationpenalty";
	}

}

