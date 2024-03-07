package com.dxtn.erp.entity;


import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
public class Member extends BaseTimeEntity {
	
//	@GeneratedValue(generator="uuid2")
//	@GenericGenerator(name="uuid2", strategy="uuid2")
//	@Column(name="memberId", columnDefinition="BINARY(16)")
//	private UUID memberId;
	@Id
	@Column(length = 20, nullable = false, unique = true)
	private String memberId;
	
	@Column(length = 20, nullable = false)
	private String memberPassword;
	
	@Column(length = 5, nullable = false, unique = true)
	private String memberNo;
	
	@Column(length = 10, nullable = false)
	private String firstName;
	
	@Column(length = 10, nullable = false)
	private String lastName;
	
	@Column(length = 13, nullable = false, unique = true)
	private String residentId;
	
	@Column(length = 100, nullable = false)
	private String email;
	
	@Column(length = 11, nullable = false)
	private String phoneNo;
	
	@Column(length = 10, nullable = false)
	private String address1;
	
	@Column(length = 10, nullable = false)
	private String address2;
	
	@Column(length = 100, nullable = false)
	private String addressDetail;
	
	@Column(length = 2, nullable = false)
	private int departmentNo;
	
	@Column(length = 2, nullable = false)
	private int rankNo;
	
	@Column(length = 8, nullable = false)
	private String hireDate;

	@Column(length = 8)
	private String quitDate;
	
	@Column(length = 1, nullable = false)
	private char workingYn;
	
}
