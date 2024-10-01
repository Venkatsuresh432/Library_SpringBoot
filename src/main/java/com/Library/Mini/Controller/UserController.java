package com.Library.Mini.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Library.Mini.Entity.UserEntity;
import com.Library.Mini.Service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins ="http://127.0.0.1:5500")
@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService serv;
//	@CrossOrigin(origins ="http://127.0.0.1:5500/MemberList.html")
	@GetMapping("/findall")
	public List<UserEntity> findAllUser() {
			return serv.findAll(); 
	}
	
	@PostMapping("/adduser")
	public UserEntity addUser(@RequestBody UserEntity user) {
		return serv.addUser(user);
	}
	@GetMapping("/find/{userId}")
	public UserEntity findUserById(@PathVariable Long userId) {
		return serv.findUserById(userId);
	}
	
	@PutMapping("/update/{userId}")
	public UserEntity updateUser(@PathVariable Long userId, @RequestBody UserEntity user) {
		return serv.updateUser(userId, user);
	}
	
}
