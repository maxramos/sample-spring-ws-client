package com.maxaramos.springwstestclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maxaramos.springwstestclient.model.Address;
import com.maxaramos.springwstestclient.wsclient.AddressWsClient;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressWsClient addressWsClient;

	@GetMapping("/add")
	public String showAdd(Model model) {
		model.addAttribute("address", new Address());
		return "/address/add";
	}

	@PostMapping("/add")
	public String add(Address address, Model model) {
		Address addedAddress = addressWsClient.addAddress(address);
		model.addAttribute("address", addedAddress);
		return "/address/get";
	}

	@GetMapping("/get")
	public String get(Long id, Model model) {
		Address address = addressWsClient.getAddress(id);
		model.addAttribute("address", address);
		return "/address/get";
	}

	@GetMapping("/update")
	public String showUpdate(Long id, Model model) {
		Address address = addressWsClient.getAddress(id);
		model.addAttribute("address", address);
		return "/address/update";
	}

	@PostMapping("/update")
	public String update(Address address, Model model) {
		Address updatedAddress = addressWsClient.updateAddress(address);
		model.addAttribute("address", updatedAddress);
		return "/address/get";
	}

	@PostMapping("/delete")
	public String delete(Long id, Model model) {
		boolean deleted = addressWsClient.deleteAddress(id);
		model.addAttribute("deleted", deleted);
		return "/address/get";
	}

}
