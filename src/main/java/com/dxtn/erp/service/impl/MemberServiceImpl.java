package com.dxtn.erp.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxtn.erp.dto.MemberDto;
import com.dxtn.erp.entity.Member;
import com.dxtn.erp.repository.MemberRepository;
import com.dxtn.erp.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public Map<String, Object> insertMember(MemberDto memberDto) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Member member = convertMemberDtoToMember(memberDto);
		if(!checkMemberRequired(member)) {
			resultMap.put("result", "fail");
			resultMap.put("msg", "누락된 정보가 있습니다.");
			return resultMap;
		}
		
		Boolean isMember = memberRepository.existsByResidentId(member.getResidentId());
		if(isMember) {
			resultMap.put("result", "fail");
			resultMap.put("msg", "이미 가입되어있습니다.");
			return resultMap;
		}
		
		member.setWorkingYn('Y');
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
		resultMap.put("msg", "가입되었습니다.");
		return resultMap;
	}

	private Member convertMemberDtoToMember(MemberDto memberDto) {
		Member member = new Member();
		member.setMemberId(memberDto.getMemberId());
		member.setMemberPassword(memberDto.getMemberPassword());
		member.setLastName(memberDto.getLastName());
		member.setFirstName(memberDto.getFirstName());
		member.setResidentId(memberDto.getResidentId());
		member.setPhoneNo(memberDto.getPhoneNo());
		member.setEmail(memberDto.getEmail());
		member.setAddress1(memberDto.getAddress1());
		member.setAddress2(memberDto.getAddress2());
		member.setAddressDetail(memberDto.getAddressDetail());
		member.setDepartmentNo(memberDto.getDepartmentNo());
		member.setHireDate(memberDto.getHireDate().replace("-", ""));
		member.setRankNo(memberDto.getRankNo());
		return member;
	}

	@Override
	public Map<String, Object> login(Member member) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Boolean isMember = memberRepository.existsByMemberId(member.getMemberId());
		if(!isMember) {
			System.out.println("아이디와 일치하는 사용자가 없습니다.");
			resultMap.put("result", "fail");
			resultMap.put("msg", "아이디를 확인해주세요.");
			return null;
		}
		Member tempMember = memberRepository.findByMemberId(member.getMemberId());
		if(!tempMember.getMemberPassword().equals(member.getMemberPassword())) {
			System.out.println("패스워드가 틀립니다.");
			resultMap.put("result", "fail");
			resultMap.put("msg", "패스워드를 확인해주세요.");
			return null;
		}
		resultMap.put("result", "success");
		resultMap.put("loginMember", tempMember);
		return resultMap;
	}

	public Boolean checkMemberRequired(Member member) {
		
		if(null == member.getMemberId() || member.getMemberId().trim().isEmpty()) {
			
			return false;
		} else if(null == member.getMemberPassword() || member.getMemberPassword().trim().isEmpty()) {
			
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

	@Override
	public Map<String, Object> findMember(MemberDto memberDto) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		char findType = memberDto.getFindType();
		// 찾기유형이 있는 경우
		if(findType != 0) {
			// ID 찾기 유형인 경우
			if(findType == '0') {
				System.out.println("ID 찾기");
				// 필수 항목 null 체크
				if(memberDto.getLastName() == null || memberDto.getFirstName() == null || memberDto.getResidentId() == null) {
					System.out.println("ID 찾기 에러 : 정보 부족");
					resultMap.put("msg", "필수 입력 항목을 전부 입력해주세요.");
					resultMap.put("result", "fail");
					return resultMap;
				}
				// 아이디 조회
				Boolean isMember = memberRepository.existsByResidentId(memberDto.getResidentId());
				// 조회된 아이디가 없는 경우
				if(!isMember) {
					System.out.println("조회된 아이디 없음");
					resultMap.put("msg", "조회된 아이디가 없습니다.");
					resultMap.put("result", "fail");
					return resultMap;
				}
				// 조회된 아이디가 있는 경우
				Member registeredMember = memberRepository.findByResidentId(memberDto.getResidentId());
				// 조회된 아이디와 정보가 일치하지 않는 경우
				if(!registeredMember.getFirstName().equals(memberDto.getFirstName()) || !registeredMember.getLastName().equals(memberDto.getLastName())) {
					System.out.println("조회된 아이디의 정보가 일치하지 않음");
					resultMap.put("msg", "조회된 아이디가 없습니다.");
					resultMap.put("result", "fail");
					return resultMap;
				}
				// 아이디 조회 성공
				System.out.println("아이디 [" + registeredMember.getMemberId() + "] 조회 성공");
				resultMap.put("msg", "조회된 아이디는 [" + registeredMember.getMemberId() + "] 입니다.");
				resultMap.put("result", "success");
			} else {
				// Password 찾기 유형인 경우
				System.out.println("Password 찾기");
				if(memberDto.getMemberId() == null || memberDto.getResidentId() == null) {
					System.out.println("Password 찾기 에러 : 정보 부족");
					resultMap.put("msg", "필수 입력 항목을 전부 입력해주세요.");
					resultMap.put("result", "fail");
					return resultMap;
				}
				// 아이디 조회
				Boolean isMember = memberRepository.existsByMemberId(memberDto.getMemberId());
				// 조회된 아이디가 없는 경우
				if(!isMember) {
					System.out.println("조회된 아이디 없음");
					resultMap.put("msg", "조회된 아이디가 없습니다.");
					resultMap.put("result", "fail");
					return resultMap;
				}
				// 조회된 아이디가 있는 경우
				Member registeredMember = memberRepository.findByMemberId(memberDto.getMemberId());
				// 조회된 아이디와 정보가 일치하지 않는 경우
				if(!registeredMember.getResidentId().equals(memberDto.getResidentId())) {
					System.out.println("조회된 아이디의 정보가 일치하지 않음");
					resultMap.put("msg", "조회된 아이디가 없습니다.");
					resultMap.put("result", "fail");
					return resultMap;
				}
				// 비밀번호 조회 성공
				System.out.println("비밀번호 [" + registeredMember.getMemberPassword() + "] 조회 성공");
				resultMap.put("msg", "비밀번호는 [" + registeredMember.getMemberPassword() + "] 입니다.");
				resultMap.put("result", "success");
			}
		} else {
			// 찾기유형이 없는 경우 오류
			System.out.println("findMember 에러");
			resultMap.put("msg", "찾기 유형을 확인해주세요.");
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

}
