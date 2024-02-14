package com.dxtn.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxtn.erp.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
}