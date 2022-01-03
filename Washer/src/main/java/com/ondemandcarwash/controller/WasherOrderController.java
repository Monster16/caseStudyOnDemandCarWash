package com.ondemandcarwash.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ondemandcarwash.model.Order;



@RestController
@RequestMapping("/washer")
@CrossOrigin(origins = "http://localhost:3000")
public class WasherOrderController {

	 @Autowired
	 RestTemplate restTemplate;
	
	@PutMapping("/updatestatus/{status}")
	public String updateorder(@PathVariable("status") String status, @RequestBody Order order) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Order> entity = new HttpEntity<Order>(order, headers);

		return restTemplate.exchange("http://order-service/order/updateStatusAcceptedByWasher/" + status, HttpMethod.PUT, entity, String.class)
				.getBody();
	}
	
	//Reading orders  By id
		@GetMapping("/getallorders/{wId}") 
		public Order getOrderById (@PathVariable("wId") String wId) 
		{
		  return restTemplate.getForObject("http://order-service/order/orders/" +wId , Order.class);
		  
		  }
	
}
