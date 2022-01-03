package com.ondemandcarwash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ondemandcarwash.model.Order;
import com.ondemandcarwash.repository.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
    
	/*
	 * 
	 *  For Creating/Adding Order
	 *  
	 */
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}
     
	

	/*
	 *  For Reading all Order
	 * 
	 */
	
	  public List<Order> getOrders() {
	  List<Order> order= orderRepository.findAll();
	  System.out.println("Getting order from DB" + order);
	  return order; 
	  }
	 
	  /*
	   *  For Deleting all Order
	   * 
	   */

	public void deleteById(String id) {
		orderRepository.deleteById(id);
		
	}

	/*
	 *  For deleting  Order by id
	 * 
	 */

	public Optional<Order> findById(String id) {
		return orderRepository.findById(id);
	}

	/*
	 * 
	 *  Find order by WasherId
	 */

	public List<Order> findByWasherId(long wId) {
		return orderRepository.findByWasherId(wId);
	}

	/*
	 * 
	 *  Find order by CustomerId
	 */

	public List<Order> findByCustomerId(long cId) {
		return orderRepository.findByCustomerId(cId);
	}

	/*
	 * 
	 *  Order Status update requested by admin to washer
	 *  
	 */

	public String updateOrderStatusRequestingToWasher(String orderId, String status) {
		orderRepository.findById(orderId).map((order) -> {
			order.setStatus(status);
			return orderRepository.save(order);
		}).orElseThrow();
		return "For Order "+orderId+ " status " +status;
	}


	/*
	 * 
	 *  Finding order by status
	 *  
	 */
	
	public List<Order> findOrderByStatus(String status) {
		List<Order> order= orderRepository.findOrderByStatus(status);
		  return order; 
		
	}

	/*
	 * 
	 *  Order Status update Accepted by washer
	 *  
	 */

	public String updateOrderStatusAcceptedByWasher(String orderId, String status) {
		orderRepository.findById(orderId).map((order) -> {
			order.setStatus(status);
			return orderRepository.save(order);
		}).orElseThrow();
		return "For Order "+orderId+"  "+status;
	}



	public void save(Order order) {
		orderRepository.save(order);
		
	}



	

}
