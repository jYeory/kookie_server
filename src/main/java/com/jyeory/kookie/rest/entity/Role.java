package com.jyeory.kookie.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
	@Id
	@Column(name = "role_id", nullable = false, length = 8)
	private String id;

	@Column(name = "role_eng_nm", nullable = false, length = 20)
	private String roleEngNm;

	@Column(name = "role_kor_nm", nullable = false, length = 40)
	private String roleKorNm;

	@Column(name = "role_desc", nullable = false, length = 45)
	private String roleDesc;

	@Column(name = "reg_dtm", nullable = false, length = 14)
	private String regDtm;

}