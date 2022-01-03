package com.ondemandcarwash.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ondemandcarwash.exception.ApiRequestException;
import com.ondemandcarwash.model.Order;
import com.ondemandcarwash.repository.OrderRepository;
import com.ondemandcarwash.service.OrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

	Logger logger = LoggerFactory.getLogger(OrderController.class);

	private static final String OrderService = "Order-Service";

	

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderRepository orderRepository;

	@CircuitBreaker(name = OrderService, fallbackMethod = "orderFallback")

	public ResponseEntity<String> orderFallback(Exception e) {
		return new ResponseEntity<String>("Order Service is down", HttpStatus.OK);

	}

	/*
	 *  Creating/Adding Order
	 *  
	 */
	
	@PostMapping("/addorder")
	public String saveOrder(@Valid @RequestBody Order order) {
		orderService.addOrder(order);
		logger.trace("Save Order Method accessed");
		return "Order is Placed with Washer and will be Proceesed soon " + order;
	}

	/*
	 *   Reading all Order
	 * 
	 */
	
	@GetMapping("/allorders")
	public List<Order> getOrders() {
		logger.trace("get all Order Method accessed");
		return orderService.getOrders();
	}

	/*
	 * for Reading Order by id
	 *  
	 */
	
	@GetMapping("/orders/{id}")
	public Optional<Order> getOrderById(@PathVariable String id) throws ApiRequestException {
		return Optional.of(orderService.findById(id)
				.orElseThrow(() -> new ApiRequestException("Order NOT FOUND WITH THIS ID ::")));
	}

	/*
	 * 
	 *  Deleting order by Id
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteOrder(@PathVariable String id) {
		boolean isOrderExist = orderRepository.existsById(id);
		if (isOrderExist) {
			orderService.deleteById(id);
			return new ResponseEntity<Object>("Order deleted with id" + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT DELETE ORDER ,AS ORDER NOT FOUND WITH THIS ID ::");
		}

	}
	/*
	 * 
	 *  Updating order by Id
	 */
	

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateOrderById(@PathVariable String id, @RequestBody Order order)
	{
		boolean isOrderExist=orderRepository.existsById(id);
		if(isOrderExist) {
			orderService.save(order);
			return new ResponseEntity<Object>("Order updated successfully with id " +id, HttpStatus.OK);
		}
		else 
		{
			throw new ApiRequestException("CAN NOT UPDATE AS ORDER NOT FOUND WITH THIS ID ::");
		}
		
	}
	/*
	 * 
	 *  Find order by CustomerId
	 */
	@GetMapping("/findOrderByCustomer/{cId}")
	public ResponseEntity<List<Order>> findOrderByCustomerId(@PathVariable long cId) {
		try {
			List<Order> orderList = orderService.findByCustomerId(cId);
			return new ResponseEntity<List<Order>>(orderList,HttpStatus.FOUND);
		}
		catch(Exception e) {
			return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * 
	 *  Find order by WasherId
	 */
	@GetMapping("/findOrderByWasher/{wId}")
	public ResponseEntity<List<Order>> findOrderByWasherId(@PathVariable long wId) {
		try {
			List<Order> orderList = orderService.findByWasherId(wId);
			return new ResponseEntity<List<Order>>(orderList,HttpStatus.FOUND);
		}
		catch(Exception e) {
			return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
		}
	}
	

	/*
	 * 
	 *  Find order by Status
	 */
	@GetMapping("/findOrderByStatus/{status}")
	public ResponseEntity<List<Order>> findOrderByStatus(@PathVariable ("status") String status) {
		try {
			List<Order> orderList = orderService.findOrderByStatus(status);
			return new ResponseEntity<List<Order>>(orderList,HttpStatus.FOUND);
		}
		catch(Exception e) {
			return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	

	
}
