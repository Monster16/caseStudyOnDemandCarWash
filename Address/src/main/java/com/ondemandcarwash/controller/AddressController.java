package com.ondemandcarwash.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ondemandcarwash.exception.ApiRequestException;
import com.ondemandcarwash.model.Address;
import com.ondemandcarwash.repository.AddressRepository;
import com.ondemandcarwash.service.AddressService;



@RestController
@RequestMapping("/address")
public class AddressController {

	
	

	@Autowired
	private AddressService addressService;

	@Autowired
	private AddressRepository addressRepository;
	
	
	

	// Creating/Adding Address
	@PostMapping("/addaddress")
	public String saveAddress(@RequestBody Address address) {
		addressService.addAddress(address);
	
		return "Address added " + address;
	}

	
	// Reading all Address
	@GetMapping("/alladdress")
	public List<Address> getAllAddress() {
		return addressService.getAddresses();
	}
	
	
	// Reading Addreess by id
	@GetMapping("/address/{id}")
	public Optional<Address> getAddressById(@PathVariable long id) throws ApiRequestException {
		return Optional.of(addressRepository.findById(id)
				.orElseThrow(() -> new ApiRequestException("ADDRESS NOT FOUND WITH THIS ID ::")));
		
	}
	
	//Updating Address Data by Id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateAddress(@PathVariable long id, @RequestBody Address address)
	{
		boolean isAddressExist=addressRepository.existsById(id);
		if(isAddressExist) {
			addressRepository.save(address);
			return new ResponseEntity<Object>("Address updated successfully with id " +id, HttpStatus.OK);
		}
		else 
		{
			throw new ApiRequestException("CAN NOT UPDATE AS ADDRESS NOT FOUND WITH THIS ID ::");
		}
		
	}

	

}
