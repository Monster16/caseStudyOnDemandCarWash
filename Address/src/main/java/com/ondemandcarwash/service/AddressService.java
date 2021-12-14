package com.ondemandcarwash.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ondemandcarwash.model.Address;
import com.ondemandcarwash.repository.AddressRepository;


@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
    
	//for creating/adding Address
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}
	
	public List<Address> getAddresses() {
		// TODO Auto-generated method stub
		List<Address> address= addressRepository.findAll();
		System.out.println("Getting Address from DB" + address);
		return address;
	}
     
	
	 
	
	 
		
	

}
