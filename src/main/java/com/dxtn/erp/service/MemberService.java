package com.dxtn.erp.service;

import java.util.Map;

import com.dxtn.erp.dto.MemberDto;
import com.dxtn.erp.entity.Member;

public interface MemberService {
	
	public Map<String, Object> insertMember(MemberDto memberDto);

	public Map<String, Object> login(Member member);

	public Map<String, Object> findMember(MemberDto memberDto);
	
}
