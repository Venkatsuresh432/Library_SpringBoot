package com.Library.Mini.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Library.Mini.Entity.UserEntity;

@Repository
public interface UserRepositrory extends JpaRepository<UserEntity, Long>{

	
	public UserEntity findByUserName(String userName);
}
