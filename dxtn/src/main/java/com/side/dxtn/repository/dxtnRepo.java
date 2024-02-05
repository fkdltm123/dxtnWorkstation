package com.side.dxtn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.side.dxtn.entity.dxtnJPATest;

@Repository
public interface dxtnRepo extends JpaRepository<dxtnJPATest, Long>{
	
}
