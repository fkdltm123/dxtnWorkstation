package com.dxtn.erp.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
	
	private String memberId;
	
	private String memberPassword;
	
	private String memberPasswordCheck;
	
	private String firstName;
	
	private String lastName;
	
	private String residentId;
	
	private String email;
	
	private String phoneNo;
	
	private String address1;
	
	private String address2;
	
	private String addressDetail;
	
	private int departmentNo;
	
	private int rankNo;
	
	private String hireDate;

	private String quitDate;

	private char workingYn;
	
}
