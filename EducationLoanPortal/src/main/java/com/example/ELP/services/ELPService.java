package com.example.ELP.services;


import com.example.ELP.models.LoanApplicationModel;
import com.example.ELP.models.UserModel;
import com.example.ELP.repositories.LoanApplicationModelRepository;
import com.example.ELP.repositories.UserModelRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ELPService {
	@Autowired
	UserModelRepository Urep;
	
	@Autowired 
	LoanApplicationModelRepository Lrep;
	public List<UserModel> getUserData() {
		return Urep.findAll();
	}
	public UserModel postUserData(UserModel u) {
		return Urep.save(u);
	}
	public UserModel putUserData(UserModel u,int id) {
		Optional<UserModel> data=Urep.findById(id);
		if(data.isPresent())
		{
			return Urep.save(u);
		}
		return null;
	}
	public String deleteData(int id) {
		Urep.deleteById(id);
		return "Record is deleted";
	}
	public List<LoanApplicationModel> getLoanData() {
		return Lrep.findAll();
	}
	public LoanApplicationModel postLoanData(LoanApplicationModel u) {
		return Lrep.save(u);
	}
	public LoanApplicationModel putLoanData(LoanApplicationModel u, int id) {
		Optional<LoanApplicationModel> data=Lrep.findById(id);
		if(data.isPresent())
		{
			return Lrep.save(u);
		}
		return null;
	}
	public String deleteLoanData(int id) {
		Lrep.deleteById(id);
		return "Record is deleted";
	}
	public String Login(String email, String password) {
		try {
			UserModel userData = Urep.findByEmail(email);
			if(userData == null)
			{
				return "Account isn't found or email incorrect";
			}
			else 
			{
				if((userData.getPassword()).equals(password))
				{
					return "Login Successfull";
				}
				else
				{
					return "Login Unsuccessfull! Check email and password";
				}
			}
			}
			catch(Exception e)
			{
				return "Login Unsuccessfull! Check email and password";
			}
	}
}
