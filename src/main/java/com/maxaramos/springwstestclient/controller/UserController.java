package com.maxaramos.springwstestclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxaramos.springwstestclient.client.UserClient;
import com.maxaramos.springwstestclient.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserClient userWsClient;

	@PutMapping("/add")
	public User add(User user) {
		return userWsClient.addUser(user);
	}

	@GetMapping("/get")
	public User get(Long id) {
		return userWsClient.getUser(id);
	}

	@PostMapping("/update")
	public User update(User user) {
		return userWsClient.updateUser(user);
	}

	@DeleteMapping("/delete")
	public boolean delete(Long id) {
		return userWsClient.deleteUser(id);
	}

}
