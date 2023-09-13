package com.jyeory.kookie.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usr_tkn")
public class UsrTkn {
	@EmbeddedId
	private UsrTknId id;

	@MapsId("usrEmail")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usr_email", nullable = false)
	private Usr usrEmail;

	@Column(name = "rfsh_tkn", nullable = false, length = 256)
	private String rfshTkn;

	@Column(name = "autn_uri", nullable = false, length = 256)
	private String autnUri;

	@Column(name = "autn_yn", nullable = false, length = 1)
	private String autnYn;

	@Column(name = "autn_end_dtm", nullable = false, length = 14)
	private String autnEndDtm;

	@Column(name = "reg_dtm", nullable = false, length = 14)
	private String regDtm;

}