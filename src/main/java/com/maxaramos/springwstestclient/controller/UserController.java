package com.maxaramos.springwstestclient.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/getAll")
	public List<User> getAll() {
		log.info("getAll");
		return userClient.getAllUser();
	}

	@PutMapping("/add")
	public User add(@RequestBody User user) {
		log.info("add: " + user);
		return userClient.addUser(user);
	}

	@GetMapping("/get")
	public User get(@RequestParam("id") Long id) {
		log.info("get: " + id);
		return userClient.getUser(id);
	}

	@PostMapping("/update")
	public User update(@RequestBody User user) {
		log.info("update: " + user);
		return userClient.updateUser(user);
	}

	@DeleteMapping("/delete")
	public boolean delete(@RequestParam("id") Long id) {
		log.info("delete: " + id);
		return userClient.deleteUser(id);
	}

}
