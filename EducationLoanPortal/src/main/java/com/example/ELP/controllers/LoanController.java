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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ELP.models.LoanApplicationModel;
import com.example.ELP.services.ELPService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/loan")
public class LoanController {
	@Autowired
	ELPService ser;
	
	@Operation(summary = "Get all the students")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Student data fetched successfully"),
			@ApiResponse(responseCode = "401", description = "Invalid credentials"),
			@ApiResponse(responseCode = "404", description = "Path not found") })
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/getData")
	public List<LoanApplicationModel> getLoanData()
	{
		return ser.getLoanData();
	}
	
	@PostMapping("/postData")
	public LoanApplicationModel postLoanData(@RequestBody LoanApplicationModel u) {
		return ser.postLoanData(u);
	}
	
	@PutMapping("/postData/{id}")
	public LoanApplicationModel putUserData(@RequestBody LoanApplicationModel u,@PathVariable int id) {
		return ser.putLoanData(u,id);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteLoanData(@PathVariable int id) {
		return ser.deleteLoanData(id);
		}
}
