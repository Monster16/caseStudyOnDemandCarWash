package com.ondemandcarwash.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ondemandcarwash.model.Address;


@RestController
@RequestMapping("/order")
public class OrderAddressController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*
	 * * Below code is for the Order for the Address * Customer can Add Address and
	 * Update Address
	 */

	// For Adding address

	@PostMapping("/addaddress")
	public String addAddress(@RequestBody Address address) {
		return restTemplate.postForObject("http://ADDRESS-SERVICE/address/addaddress", address, String.class);

	}

	// for updating address for order

	@PutMapping("/updateaddress/{id}")
	public String updateaddress(@PathVariable("id") int id, @RequestBody Address address) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Address> entity = new HttpEntity<Address>(address, headers);

		return restTemplate.exchange("http://ADDRESS-SERVICE/address/update/" + id, HttpMethod.PUT, entity, String.class)
				.getBody();
	}


}
