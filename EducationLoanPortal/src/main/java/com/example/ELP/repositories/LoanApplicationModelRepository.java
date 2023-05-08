package com.example.ELP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ELP.models.LoanApplicationModel;

@Repository
public interface LoanApplicationModelRepository extends JpaRepository<LoanApplicationModel,Integer>{

}
