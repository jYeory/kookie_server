package com.jyeory.kookie.rest.entity;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class UsrRoleId implements Serializable {
	private static final long serialVersionUID = 3663079965594300522L;
	@Column(name = "usr_email", nullable = false, length = 50)
	private String usrEmail;

	@Column(name = "role_role_id", nullable = false, length = 8)
	private String roleRoleId;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		UsrRoleId entity = (UsrRoleId)o;
		return Objects.equals(this.usrEmail, entity.usrEmail) &&
			Objects.equals(this.roleRoleId, entity.roleRoleId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(usrEmail, roleRoleId);
	}

}