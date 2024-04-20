package com.sam.springbootdemo.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/getUserDetails")
	public ResponseEntity<User> getUserDetails(){
		User user = new User();
		user.setUsername("Ranjit");
		user.setEmail("ranjitxyz@gmail.com");
		user.setAge(32);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/*Use of @PathVariable*/
	@GetMapping("/getUserDetailsByPathVariable/{id}")
	public ResponseEntity<User> getUserDetailsByPathVariable( 
			                                @PathVariable("id") String userId){
		User user = new User();
		user.setUsername("Ranjit");
		user.setEmail("ranjitxyz@gmail.com");
		user.setAge(32);
		user.setUserId(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
   /* Use of @RequestParam*/
	@GetMapping("/getuserDeatilsByRequestParam")
	public ResponseEntity<User> getuserDeatilsByRequestParam(HttpServletRequest request, 
			 @RequestParam("name")String userName ,
			 @RequestParam(name ="email",required=false, defaultValue="xyz@gmail.com") String emailId){
		
		User user = new User();
		user.setUsername(userName);
		user.setEmail(emailId);
		user.setAge(30);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
}
