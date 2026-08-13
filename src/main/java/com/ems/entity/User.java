package com.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long id;

	  String employeecode;
	  String username;
	  String password;
	  String confirmpassword;
	  String role;
	 
	 public User() {
		super();
	 }

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getEmployeecode() {
		 return employeecode;
	 }

	 public void setEmployeecode(String employeecode) {
		 this.employeecode = employeecode;
	 }

	 public String getUsername() {
		 return username;
	 }

	 public void setUsername(String username) {
		 this.username = username;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }

	 public String getConfirmpassword() {
		 return confirmpassword;
	 }

	 public void setConfirmpassword(String confirmpassword) {
		 this.confirmpassword = confirmpassword;
	 }

	 public String getRole() {
		 return role;
	 }

	 public void setRole(String role) {
		 this.role = role;
	 }
	 
	 
	 
}
