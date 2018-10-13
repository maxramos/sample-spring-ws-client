package com.maxaramos.springwstestclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxaramos.springwstestclient.client.AddressClient;
import com.maxaramos.springwstestclient.model.Address;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressClient addressClient;

	@PutMapping("/add")
	public Address add(Address address) {
		return addressClient.addAddress(address);
	}

	@GetMapping("/get")
	public Address get(Long id) {
		return addressClient.getAddress(id);
	}

	@PostMapping("/update")
	public Address update(Address address) {
		return addressClient.updateAddress(address);
	}

	@DeleteMapping("/delete")
	public boolean delete(Long id) {
		return addressClient.deleteAddress(id);
	}

}
