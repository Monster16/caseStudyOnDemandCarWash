package com.ondemandcarwash.controller;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ondemandcarwash.models.Washer;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminWasherController {

	@Autowired
	private RestTemplate restTemplate;
	
	
	
	
	
	/*
	 * * Below code is for the Admin for to add Washer *
	 */
	
	@PostMapping("/addwasher") 
	public String addwasher (@RequestBody Washer washer) 
	{
	  return restTemplate.postForObject("http://WASHER-SERVICE/washer/addwasher", washer , String.class);
	  
	  }
	
	
	

	/*
	 * * Below code is for the Admin for to view Washer *
	 */
	
	// Reading All washer
	@GetMapping("/getallwasher")
	public String getallWasher() {
		return restTemplate.getForObject("http://WASHER-SERVICE/washer/allwashers", String.class);

	}

	// Reading Washer ById
	@GetMapping("/getwasher/{id}")
	public String getWasherById(@PathVariable String id) {
		return restTemplate.getForObject("http://WASHER-SERVICE/washer/allwashers/" + id, String.class);

	}
	
	
	/*
	 * * Below code is for the Admin for to update Washer *
	 */
	
	@PutMapping("/updatewasher/{id}")
	public String updatewasher(@PathVariable("id") String id, @RequestBody  Washer washer) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Washer> entity = new HttpEntity<Washer>(washer, headers);

		return restTemplate.exchange("http://WASHER-SERVICE/washer/update/" + id, HttpMethod.PUT, entity, String.class)
				.getBody();
	}
	
	
	/*
	 * * Below code is for the Admin for to delete Washer *
	 */
	
	

	@DeleteMapping("/deletewasher/{id}")
	public String deletewasher(@PathVariable("id") String id) 
	{
		restTemplate.delete("http://WASHER-SERVICE/washer/delete/" +id , String.class);
		return " Washer is deleted successfully for " + id;
	}


}
