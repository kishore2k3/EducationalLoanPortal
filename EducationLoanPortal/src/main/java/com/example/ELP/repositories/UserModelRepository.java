package com.example.ELP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ELP.models.UserModel;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel,Integer>{
	public UserModel findByEmail(String email);
}
