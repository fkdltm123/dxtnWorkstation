package com.side.dxtn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class dxtnJPATest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
}
