package com.sam.springbootdemo.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sam.springbootdemo.model.User;

@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {

	@GetMapping("/hello")
	public String helloWorld(){
		return "Hello to Spring Boot!";
	}
	
	/* Better to use @GetMapping instead of @RequestMapping
	 * By deafult method is GET
	@RequestMapping(value="/getUserDetails", method= RequestMethod.GET)
	public User getUserDetails(){
		User user = new User();
		user.setUsername("Sanjit");
		user.setEmail("sanjitxyz@gmail.com");
		user.setAge(35);
		return user;
	}*/
	
	@GetMapping("/getUserDetail")
	public ResponseEntity<User> getUserDetail(){
		User user = new User();
		user.setUsername("Ranjit");
		user.setEmail("ranjitxyz@gmail.com");
		user.setAge(32);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/getUserDetailsById/{id}")
	public ResponseEntity<User> getUserDetailsById( 
			                                @PathVariable("id") String userId){
		User user = new User();
		user.setUsername("Ranjit");
		user.setEmail("ranjitxyz@gmail.com");
		user.setAge(32);
		user.setUserId(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
