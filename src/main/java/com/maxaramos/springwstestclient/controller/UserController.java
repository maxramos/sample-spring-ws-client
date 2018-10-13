package com.maxaramos.springwstestclient.controller;

import org.slf4j.Logger;
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
	private Logger log;

	@Autowired
	private UserClient userClient;

	@PutMapping("/add")
	public User add(User user) {
		log.info("add: " + user);
		return userClient.addUser(user);
	}

	@GetMapping("/get")
	public User get(Long id) {
		log.info("get: " + id);
		return userClient.getUser(id);
	}

	@PostMapping("/update")
	public User update(User user) {
		log.info("update: " + user);
		return userClient.updateUser(user);
	}

	@DeleteMapping("/delete")
	public boolean delete(Long id) {
		log.info("delete: " + id);
		return userClient.deleteUser(id);
	}

}
