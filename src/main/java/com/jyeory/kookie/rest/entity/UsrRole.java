package com.jyeory.kookie.rest.entity;

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
@Table(name = "usr_role")
public class UsrRole {
	@EmbeddedId
	private UsrRoleId id;

	@MapsId("usrEmail")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usr_email", nullable = false)
	private Usr usrEmail;

	@MapsId("roleId")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

}