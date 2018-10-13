package com.maxaramos.springwstestclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxaramos.springwstestclient.model.Address;
import com.maxaramos.springwstestclient.wsclient.AddressWsClient;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressWsClient addressWsClient;

	@PutMapping("/add")
	public Address add(Address address) {
		return addressWsClient.addAddress(address);
	}

	@GetMapping("/get")
	public Address get(Long id) {
		return addressWsClient.getAddress(id);
	}

	@PostMapping("/update")
	public Address update(Address address) {
		return addressWsClient.updateAddress(address);
	}

	@DeleteMapping("/delete")
	public boolean delete(Long id) {
		return addressWsClient.deleteAddress(id);
	}

}
