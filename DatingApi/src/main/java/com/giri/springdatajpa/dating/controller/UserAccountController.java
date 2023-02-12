package com.giri.springdatajpa.dating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giri.springdatajpa.dating.entities.Interest;
import com.giri.springdatajpa.dating.entities.UserAccount;
import com.giri.springdatajpa.dating.repos.InterestRepository;
import com.giri.springdatajpa.dating.repos.UserAccountRepository;

@RestController
@RequestMapping("/api")
public class UserAccountController {
	
	@Autowired
	private UserAccountRepository userRepo;
	
	@Autowired
	private InterestRepository interestRepo;
	
	@PostMapping("/users/register-user")
	public UserAccount registerUser(@RequestBody UserAccount user) {
		return userRepo.save(user);
		
	}
	
	@PostMapping("/interests/update")
	public Interest updateInterest(@RequestBody Interest interest) {
		UserAccount userAccount = userRepo.findById(interest.getUserAccountId()).get();
		interest.setUserAccount(userAccount);
		return interestRepo.save(interest);
	}
	
	@GetMapping("/users/all")
	public List<UserAccount> getAllUsers(){
		return userRepo.findAll();
	}
	
	@DeleteMapping("/users/delete/{interestId}")
	public void deleteInterest(@PathVariable("interestId")int id) {
		interestRepo.deleteById(id);
	}
	
	@GetMapping("/users/matches/{id}")
	public List<UserAccount> findUserAccountMatches(@PathVariable int id){
		UserAccount userAccount = userRepo.findById(id).get();
		return userRepo.findMatches(userAccount.getAge(), userAccount.getCity(), userAccount.getCountry(), id);
	}

}