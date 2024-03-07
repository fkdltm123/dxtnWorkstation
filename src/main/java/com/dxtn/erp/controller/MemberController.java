package com.dxtn.erp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.dxtn.erp.dto.MemberDto;
import com.dxtn.erp.entity.Member;
import com.dxtn.erp.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/joinMember")
	public ModelAndView joinMember() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("memberUserViews/memberJoin");
		return mv;
	}
	
	@PostMapping("/joinMember")
	public ResponseEntity<Map<String, Object>> joinMember(@RequestBody MemberDto memberDto) {
		System.out.println(memberDto.toString());
		return ResponseEntity.ok(memberService.insertMember(memberDto));
	}
	
	@GetMapping("/login")
	public ModelAndView login(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("memberUserViews/memberLogIn");
		return mv;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(HttpServletRequest request, @RequestBody MemberDto memberDto) {
		System.out.println("memberId : " + memberDto.getMemberId());
		System.out.println("memberPassword : " + memberDto.getMemberPassword());
		Member member = new Member();
		member.setMemberId(memberDto.getMemberId());
		member.setMemberPassword(memberDto.getMemberPassword());
		
		Map<String, Object> returnMap = memberService.login(member);
		
		System.out.println("getMemberId : " + ((Member) returnMap.get("loginMember")).getMemberId());
		System.out.println("getMemberPassword : " + ((Member) returnMap.get("loginMember")).getMemberPassword());
		System.out.println("getMemberNo : " + ((Member) returnMap.get("loginMember")).getMemberNo());
		
		request.getSession().invalidate();
		HttpSession session = request.getSession(true);
		
		session.setAttribute("memberId", ((Member) returnMap.get("loginMember")).getMemberId());
		session.setAttribute("lastName", ((Member) returnMap.get("loginMember")).getLastName());
		session.setAttribute("firstName", ((Member) returnMap.get("loginMember")).getFirstName());
		session.setAttribute("loginMember", returnMap.get("loginMember"));
		session.setMaxInactiveInterval(60 * 60);	// 1시간
		return ResponseEntity.ok(returnMap);
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, Model model) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(true);
		session.invalidate();
		mv.setViewName("commonViews/index");
		return mv;
	}

	@GetMapping("/findMember")
	public ModelAndView findMember(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("memberUserViews/memberFindInfo");
		return mv;
	}
	
	@PostMapping("/findMember")
	public ResponseEntity<Map<String, Object>> findMember(@RequestBody MemberDto memberDto) {
		System.out.println("findMemberPost");
		System.out.println(memberDto.toString());
		return ResponseEntity.ok(memberService.findMember(memberDto));
	}
	
}
