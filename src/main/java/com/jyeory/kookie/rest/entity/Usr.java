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
@Table(name = "usr")
public class Usr {
	@Id
	@Column(name = "email", nullable = false, length = 50)
	private String id;

	@Column(name = "passwd", length = 256)
	private String passwd;

	@Column(name = "usr_nm", length = 30)
	private String usrNm;

	@Column(name = "nick_nm", length = 30)
	private String nickNm;

	@Column(name = "reg_dtm", nullable = false, length = 14)
	private String regDtm;

}