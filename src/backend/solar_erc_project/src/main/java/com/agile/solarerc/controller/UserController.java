package com.agile.solarerc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agile.solarerc.entities.Status;
import com.agile.solarerc.entities.User;
import com.agile.solarerc.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/user/signup")
	public Status registerUser(@RequestBody User newUser) {
		
		List<User> users = userRepository.findAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userRepository.save(newUser);
        return Status.SUCCESS;
	}
	
	 @PostMapping("/users/login")
	    public Status loginUser(@RequestBody User user) {
	        List<User> users = userRepository.findAll();
	        for (User other : users) {
	            if (other.equals(user)) {
	                user.setLoggedin("true");
	                userRepository.save(user);
	                return Status.SUCCESS;
	            }
	        }
	        return Status.FAILURE;
	    }
	 
	    @PostMapping("/users/logout")
	    public Status logUserOut(@RequestBody User user) {
	        List<User> users = userRepository.findAll();
	        for (User other : users) {
	            if (other.equals(user)) {
	                user.setLoggedin("false");
	                userRepository.save(user);
	                return Status.SUCCESS;
	            }
	        }
	        return Status.FAILURE;
	    }
}
