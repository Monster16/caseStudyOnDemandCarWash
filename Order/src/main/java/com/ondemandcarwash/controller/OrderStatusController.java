package com.ondemandcarwash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ondemandcarwash.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderStatusController {
	
	@Autowired
	private OrderService orderService;
	
	/*
	 * 
	 *  UpdateStatus when order is assigned to washer
	 */
	
	@PutMapping("/updateStatusRequestingToWasher/{status}")
	public ResponseEntity<String> updateStatusRequestingToWasher(@RequestParam("id") String orderId,@RequestParam("status") String status) {
		try {
			String message = orderService.updateOrderStatusRequestingToWasher(orderId, status);
			return new ResponseEntity<String>(message,HttpStatus.PROCESSING);
		}
		catch(Exception e){
			return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * 
	 *  UpdateStatus when order is Accepted by washer
	 */
	@PutMapping("/updateStatusAcceptedByWasher/status}")
	public ResponseEntity<String> updateStatusAcceptedByWasher(@RequestParam("id") String orderId,@RequestParam("status") String status) {
		try {
			String message = orderService.updateOrderStatusAcceptedByWasher(orderId, status);
			return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
		}
		catch(Exception e){
			return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
		}
	}
	
	

}
