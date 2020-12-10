package net.mofed.reportracking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.mofed.reportracking.app.model.MasterTransaction;
import net.mofed.reportracking.app.service.MasterTransactionService;

@Controller

public class DirectorateReportController {
	@Autowired
	MasterTransactionService masterTransactionservice;
	
	@GetMapping("/directoratereports")
	public String getAuditReport(Model model) {
		String keyword ="15";
		List<MasterTransaction> listTransaction = masterTransactionservice.getMasterTransaction(keyword);
		model.addAttribute("directoratereports",listTransaction);
		model.addAttribute("keyword",keyword);
		return "directoratereport";
	}

}

