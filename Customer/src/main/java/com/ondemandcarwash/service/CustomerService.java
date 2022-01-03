package com.ondemandcarwash.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ondemandcarwash.model.Customer;
import com.ondemandcarwash.repository.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService{

	@Autowired
	private CustomerRepository customerRepository;
	
	
	//For CREATING/ADDING  Customer 
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}
     //For getting All Customers
	public List<Customer> getCustomers() {
		List<Customer> customers =customerRepository.findAll();
		System.out.println("Getting Customers from DB" + customers);
		return customers;
	}
	
	
	 //For getting  Customers by
	
	public Optional<Customer> findById(String id) {
		return customerRepository.findById(id);
		
		
	}
	
	//For updating By Id
	public void save(Customer customer) {
		customerRepository.save(customer);
		
	}

	//For deleting By Id
	public void deleteById(String id) {
		customerRepository.deleteById(id);
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer foundedCustomer = customerRepository.findBycEmail(username);
		
		if  (foundedCustomer ==null) return null;
		String cEmail = foundedCustomer.getcEmail();
		String cPassword = foundedCustomer.getcPassword();
		return new User(cEmail, cPassword, new ArrayList<>());
	}
	
	
	
	
	
}
