package com.dxtn.erp.service;

import java.util.Map;

import com.dxtn.erp.entity.Member;

public interface MemberService {
	
	public Map<String, String> insertMember(Member member);

	public Map<String, String> findMemberId(Map<String, String> map);

	public Map<String, String> findMemberPassword(Map<String, String> map);

	public Member login(Member member);
	
}
