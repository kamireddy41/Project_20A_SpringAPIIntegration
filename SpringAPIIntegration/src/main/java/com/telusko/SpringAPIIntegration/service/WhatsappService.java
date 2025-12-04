package com.telusko.SpringAPIIntegration.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WhatsappService 
{
	@Value("${wati.api.url}")
	private String url;
	
	@Value("${wati.api.token}")
	private String token;
	
//	private String url="https://app-server.wati.io/api/v1/sendTemplateMessage";
	
	private final RestTemplate restTemplate=new RestTemplate();
	
	public String sendTemplateMessage(String phoneNumber, String templateName, List<String> templateParameters)
	{
		HttpHeaders header=new HttpHeaders();
		header.set("Authorization", "Bearer "+token);
		header.set("Content-Type", "application/json");
		
		Map<String, Object> body=new HashMap<>();
		body.put("phone", phoneNumber);
		body.put("templateName", templateName);
		body.put("parameters", templateParameters);
		
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, header);
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		return response.getBody();
		
	}

}
