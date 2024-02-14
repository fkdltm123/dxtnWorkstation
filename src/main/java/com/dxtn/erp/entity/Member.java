package com.dxtn.erp.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
public class Member extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long memberId;
	
	@Column(length = 10, nullable = false)
	private String firstName;
	
	@Column(length = 10, nullable = false)
	private String lastName;
	
	@Column(length = 8)
	private String dateOfBirth;
	
	@Column(length = 100)
	private String email;
	
	@Column(length = 11)
	private String phoneNo;
	
	@Column(length = 10)
	private String address1;
	
	@Column(length = 10)
	private String address2;
	
	@Column(length = 10)
	private String address3;
	
	@Column(length = 100)
	private String addressDetail;
	
	@Column(length = 3)
	private int departmentNo;
	
	@Column(length = 3)
	private int rankNo;
	
	@Column
	private Date hireDate;
	
}
