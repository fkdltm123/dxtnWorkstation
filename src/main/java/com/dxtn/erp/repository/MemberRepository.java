package com.dxtn.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxtn.erp.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
	List<Member> findByFirstName(String firstName);

	Boolean existsByResidentId(String residentId);	

	Boolean existsByMemberId(String memberId);	
	
	List<Member> findAllByWorkingYn(String workingYn);
	
	Member findByResidentId(String residentId);
	
	Member findByMemberId(String memberId);
	
	Member findByMemberNo(String memberNo);
	
}