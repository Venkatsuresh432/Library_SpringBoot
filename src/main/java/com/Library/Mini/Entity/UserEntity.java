package com.Library.Mini.Entity;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserEntity {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long userId;
private String userName;


public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}

public void setUserName( String userName) {
	this.userName = userName;
}
@Override
public String toString() {
	return "UserEntity [userId=" + userId + ", userName=" + userName + "]";
}
@Override
public int hashCode() {
	return Objects.hash(userId, userName);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	UserEntity other = (UserEntity) obj;
	return Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName);
}

}
