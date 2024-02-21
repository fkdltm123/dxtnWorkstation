package com.dxtn.erp.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxtn.erp.entity.Member;
import com.dxtn.erp.repository.MemberRepository;
import com.dxtn.erp.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public Map<String, String> insertMember(Member member) {
		Map<String, String> resultMap = new HashMap<String, String>();
		if(!checkMemberRequired(member)) {
			resultMap.put("result", "fail");
			resultMap.put("message", "누락된 정보가 있습니다.");
			return resultMap;
		}
		
		Boolean isMember = memberRepository.existsByResidentId(member.getResidentId());
		if(isMember) {
			resultMap.put("result", "fail");
			resultMap.put("message", "이미 가입되어있습니다.");
			return resultMap;
		}
		
		Long nextNo = memberRepository.count() + 1;
		String memberNo  = nextNo.toString();
		if(memberNo.length() < 5) {
			for(int i = 0; i < 5 - memberNo.length(); i++) {
				memberNo = "0" + memberNo;
			}
		}
		member.setMemberNo(memberNo);
		memberRepository.save(member);
		resultMap.put("result", "success");
		resultMap.put("message", "가입되었습니다.");
		return resultMap;
	}

	@Override
	public Member login(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> findMemberId(Map<String, String> map) {
		
		if(!map.containsKey("residentId") || !map.containsKey("lastName") || !map.containsKey("firstName")) {
			return map;
		}
		
		Boolean isMember = memberRepository.existsByResidentId(map.get("residentId"));
		if(!isMember) {
			return map;
		}
		
		Member registeredMember = memberRepository.findByResidentId(map.get("residentId"));
		if(registeredMember.getFirstName().equals(map.get("firstName")) && registeredMember.getLastName().equals(map.get("lastName"))) {
			map.put("memberId", registeredMember.getMemberId());
			return map;
		}
		return map;
	}

	@Override
	public Map<String, String> findMemberPassword(Map<String, String> map) {

		if(!map.containsKey("residentId") || !map.containsKey("memberId")) {
			return map;
		}
		
		Boolean isMember = memberRepository.existsByMemberId(map.get("memberId"));
		if(!isMember) {
			return map;
		}
		
		Member registeredMember = memberRepository.findByMemberId(map.get("memberId"));
		if(registeredMember.getResidentId().equals(map.get("residentId"))) {
			map.put("memberPassword", registeredMember.getMemberPassword());
			return map;
		}
		return map;
	}
	
	public Boolean checkMemberRequired(Member member) {
		
		if(null == member.getMemberId() || member.getMemberId().trim().isEmpty()) {
			
			return false;
		} else if(member.getMemberId().length() > 20) {
			
			return false;
		}
		
		if(null == member.getMemberPassword() || member.getMemberPassword().trim().isEmpty()) {
			
			return false;
		} else if(member.getMemberPassword().length() > 20) {
			return false;
		}
		
		if(null == member.getMemberNo() || member.getMemberNo().trim().isEmpty()) {
			
			return false;
		} else if(null == member.getFirstName() || member.getFirstName().trim().isEmpty()) {
			
			return false;
		} else if(null == member.getLastName() || member.getLastName().trim().isEmpty()) {
			
			return false;
		} else if(null == member.getResidentId() || member.getResidentId().trim().isEmpty()) {
			
			return false;
		} else if(null == member.getEmail() || member.getEmail().trim().isEmpty()) {
			
			return false;
		} else if(null == member.getPhoneNo() || member.getPhoneNo().trim().isEmpty()) {
			
			return false;
		} else if(null == member.getAddress1() || member.getAddress1().trim().isEmpty()) {
			
			return false;
		} else if(null == member.getAddress2() || member.getAddress2().trim().isEmpty()) {
			
			return false;
		} else if(null == member.getAddressDetail() || member.getAddressDetail().trim().isEmpty()) {
			
			return false;
//		} else if(null == member.getDepartmentNo() || member.getDepartmentNo().trim().isEmpty()) {
//			
//			return false;
//		} else if(null == member.getRankNo() || member.getRankNo().trim().isEmpty()) {
//			
//			return false;
//		} else if(null == member.getHireDate() || member.getHireDate().trim().isEmpty()) {
//			
//			return false;
		}

		return true;
		
	}

}
