package com.maxaramos.springwstestclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maxaramos.springwstestclient.model.User;
import com.maxaramos.springwstestclient.wsclient.UserWsClient;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserWsClient userWsClient;

	@GetMapping("/add")
	public String showAdd(Model model) {
		model.addAttribute("user", new User());
		return "/user/add";
	}

	@PostMapping("/add")
	public String add(User user, Model model) {
		User addedUser = userWsClient.addUser(user);
		model.addAttribute("user", addedUser);
		return "/user/get";
	}

	@GetMapping("/get")
	public String get(Long id, Model model) {
		User user = userWsClient.getUser(id);
		model.addAttribute("user", user);
		return "/user/get";
	}

	@GetMapping("/update")
	public String showUpdate(Long id, Model model) {
		User user = userWsClient.getUser(id);
		model.addAttribute("user", user);
		return "/user/update";
	}

	@PostMapping("/update")
	public String update(User user, Model model) {
		User updatedUser = userWsClient.updateUser(user);
		model.addAttribute("user", updatedUser);
		return "/user/get";
	}

	@PostMapping("/delete")
	public String delete(Long id, Model model) {
		boolean deleted = userWsClient.deleteUser(id);
		model.addAttribute("deleted", deleted);
		return "/user/get";
	}

}
