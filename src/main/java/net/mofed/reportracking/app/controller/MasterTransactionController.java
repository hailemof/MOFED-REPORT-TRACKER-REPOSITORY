package net.mofed.reportracking.app.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.mofed.reportracking.app.model.Document;
import net.mofed.reportracking.app.model.MasterTransaction;
import net.mofed.reportracking.app.model.Trainee;
import net.mofed.reportracking.app.service.DocumentService;
import net.mofed.reportracking.app.service.MasterTransactionService;

@Controller

public class MasterTransactionController {
	 
	@Autowired
	private MasterTransactionService masterTransactionService;
	@Autowired
	private DocumentService documentService;
	
	@GetMapping("/mastertransactionlists")
	
	public String  showTransaction(Model  model,String keyword) {
		keyword ="";
	List<MasterTransaction> transactionlist =  masterTransactionService.getMasterTransaction(keyword);
		model.addAttribute("mastertransactionlists", transactionlist);
		
		List<Document> doclist = documentService.getDocuments();
		model.addAttribute("documents",doclist);
		
		return  "emcp/mastertransactionlist";		
	}
	
	@RequestMapping("mastertransactionlists/findById")
	@ResponseBody
	public Optional<MasterTransaction> findBy(Integer id) {
	 return masterTransactionService.findById(id);
 }
 
 @RequestMapping(value="/mastertransactionlists/update", method= {RequestMethod.PUT, RequestMethod.GET})
 public String update(MasterTransaction  mastertransaction) {
	 masterTransactionService.save(mastertransaction);
	 return "redirect:/mastertransactionlists";
 }
		
	@PostMapping("/uploadFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile files,@RequestParam("transactiondocumentid") String transactiondocumentid,@RequestParam("reportstatus") String reportstatus,ModelMap modelMap,
			RedirectAttributes ra) throws IOException {
		
		MasterTransaction trans = new MasterTransaction();
		trans.setTransactiondocumentid(transactiondocumentid);
		trans.setReportstatus(reportstatus);
		trans.setDocName(files.getOriginalFilename());
		try {
			trans.setData(files.getBytes());
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		masterTransactionService.save(trans);
				
		return "redirect:/uploadstatus";
	
	}
	
	
	@RequestMapping("/download")
	public StreamingResponseBody download(@RequestParam("id") Integer id, HttpServletResponse response){
		MasterTransaction trans = masterTransactionService.findById(id).get();
		byte[] data = trans.getData();
		
response.setHeader(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+trans.getDocName()+"\"");
            return outputStream -> {
			outputStream.write(data);
		};
	
	
	}
	
}
