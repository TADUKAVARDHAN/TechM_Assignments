package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.EmpInfo;

public interface EmpRepository extends JpaRepository<EmpInfo,Integer>{
}
