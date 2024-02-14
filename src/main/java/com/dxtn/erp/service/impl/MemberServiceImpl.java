package com.dxtn.erp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxtn.erp.entity.Member;
import com.dxtn.erp.repository.MemberRepository;
import com.dxtn.erp.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public void createMember(Member member) {
		memberRepository.save(member);
	}
}
