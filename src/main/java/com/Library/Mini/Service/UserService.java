package com.Library.Mini.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.Mini.Entity.UserEntity;
import com.Library.Mini.Repository.UserRepositrory;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepositrory userRepo;
	
	public List<UserEntity> findAll()
	{
		return userRepo.findAll();
	}
	@Transactional
	public UserEntity addUser(UserEntity user) {
		return userRepo.save(user);
	}
	
	public UserEntity findUserById(Long userId) {
		return userRepo.findById(userId).orElse(null);
	}
	@Transactional
	public UserEntity updateUser(Long userId ,UserEntity user) {
		return userRepo.save(user);
	}
}
