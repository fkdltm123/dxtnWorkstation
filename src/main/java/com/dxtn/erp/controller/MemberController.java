package com.dxtn.erp.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@GetMapping("/join")
	public ModelAndView joinMember() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("memberUserViews/memberJoin");
		return mv;
	}
	
	@PostMapping("/join")
	public void joinMember(@ModelAttribute MemberDto memberDto, BindingResult bindingResult, HttpServletResponse response) throws IOException {
		//memberService.insertMember(memberDto);
		System.out.println(memberDto.toString());
		response.sendRedirect("/member/login");
	}
	
	@GetMapping("/login")
	public ModelAndView login(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("memberUserViews/memberLogIn");
		return mv;
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, BindingResult bindingResult) {
		Member member = new Member();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPassword(request.getParameter("memberPassword"));
		
		member = memberService.login(member);
		
		if(member == null) {
			bindingResult.reject("loginFail", "가입된 정보가 없습니다.");
		} else if(member.getMemberNo() == null) {
			bindingResult.reject("loginFail", "아이디 또는 패스워드를 확인해주세요.");
		}
		
		if(bindingResult.hasErrors()) {
			return "login";
		}
		request.getSession().invalidate();
		HttpSession session = request.getSession(true);
		
		session.setAttribute("memberId", member.getMemberId());
		session.setAttribute("lastName", member.getLastName());
		session.setAttribute("firstName", member.getFirstName());
		session.setMaxInactiveInterval(60 * 60);	// 1시간
		
		return "redirect:/index";
	}
	
	@GetMapping("/findMemberId")
	public Map<String, String> findMemberId(@RequestBody Map<String, String> map) {
		return memberService.findMemberId(map);
	}
	
	@GetMapping("/findMemberPassword")
	public Map<String, String> findMemberPassword(@RequestBody Map<String, String> map) {
		return memberService.findMemberPassword(map);
	}
	
}
