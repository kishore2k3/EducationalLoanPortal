package com.example.ELP.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ELP.models.UserModel;
import com.example.ELP.services.ELPService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	ELPService ser;
	
	@Operation(summary = "Get all the Users Data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User data fetched successfully"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/getData")
	public List<UserModel> getUserData()
	{
		return ser.getUserData();
	}
	
	@PostMapping("/postData")
	public UserModel postUserData(@RequestBody UserModel u) {
		return ser.postUserData(u);
	}
	
	@PutMapping("/putData/{id}")
	public UserModel putUserData(@RequestBody UserModel u,@PathVariable int id) {
		return ser.putUserData(u,id);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteData(@PathVariable int id) {
		return ser.deleteData(id);
	}
	@PostMapping("/login")
	public String Login(@RequestParam String email,@RequestParam String password)
	{
		return ser.Login(email,password);
	}
}
