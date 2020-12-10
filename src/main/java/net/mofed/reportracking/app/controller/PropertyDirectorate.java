package net.mofed.reportracking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.mofed.reportracking.app.model.Document;
import net.mofed.reportracking.app.service.DocumentService;


@Controller

public class PropertyDirectorate {
	
	@Autowired
	private DocumentService docservice;
	@GetMapping("/propertydirectorates")
	
	public String GetInspectionDirectorate(Model model) {
		
		List<Document> doclist = docservice.getDocuments();
		 model.addAttribute("documents", doclist);
		  return "emcp/propertydirectorate";
	}
	
	
}

