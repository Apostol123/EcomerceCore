package com.example.EcomerceCore.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{id}")
	public Optional<User> getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	/**
	 * Gets the post request body and 
	 * creates an instance of the body
	 * @param topic
	 */
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/{id}")
	public void addUser(@RequestBody User user,@PathVariable String id) {
		userService.updateUser(user,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void addUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
	

}