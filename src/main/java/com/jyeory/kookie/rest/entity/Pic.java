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
@Table(name = "pic")
public class Pic {
	@Id
	@Column(name = "idx", nullable = false)
	private Integer id;

	@Column(name = "file_nm", nullable = false, length = 128)
	private String fileNm;

	@Column(name = "dwld_nm", nullable = false, length = 128)
	private String dwldNm;

	@Column(name = "path", nullable = false, length = 200)
	private String path;

	@Column(name = "short_uri", nullable = false, length = 45)
	private String shortUri;

	@Column(name = "reg_dtm", nullable = false, length = 14)
	private String regDtm;

}