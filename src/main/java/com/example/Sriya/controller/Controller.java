package com.example.Sriya.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sriya.model.RestUser;

@RestController
@RequestMapping("/users")
public class Controller {
	Map<String,RestUser> alluser=new HashMap<>();
 @GetMapping
 public Collection<RestUser> getMethod() {
	 
	 return alluser.values();
 }
 @PutMapping(path="/{userId}")
 public String putMethod(@PathVariable String userId,@RequestBody RestUser userdetails) {
	 if(alluser.containsKey(userId)) {RestUser addValue=new RestUser();
		addValue.setUserId(userdetails.getUserId());
		addValue.setName(userdetails.getName());
		addValue.setMail(userdetails.getMail());
		alluser.put(userId,addValue);
		return "put";}
	 else {
		 return "user not found";
	 }
	
 }
 @PostMapping
 public String postMethod(@RequestBody RestUser userdetails) {
	RestUser addValue=new RestUser();
	addValue.setUserId(userdetails.getUserId());
	addValue.setName(userdetails.getName());
	addValue.setMail(userdetails.getMail());
	alluser.put(userdetails.getUserId(),addValue);
	return "user added";
 }
 @DeleteMapping(path="/{userId}")
 public String deleteMethod(@PathVariable String userId) {
	 if(alluser.containsKey(userId)) {
		 alluser.remove(userId);
		 return "removed";
		 
	 }
	 else {
		 return "user not found!!!";
	 }

 }
}
