package com.telusko.SpringAPIIntegration.rest;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.SpringAPIIntegration.service.WhatsappService;

@RestController
public class WhatsappController 
{
	//@Autowired
	private WhatsappService service;
	
	public WhatsappController(WhatsappService service)
	{
		this.service=service;
	}
	
	@GetMapping("/send-message")
	public String sendMessage(@RequestParam String phoneNumber, 
			@RequestParam String templateName ,@RequestParam String[] templateParameters)
	{
		return service.sendTemplateMessage(phoneNumber, templateName, Arrays.asList(templateParameters));
	}
	

}
