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
public class UsrTknId implements Serializable {
	private static final long serialVersionUID = 3751861036668271213L;
	@Column(name = "tkn", nullable = false, length = 256)
	private String tkn;

	@Column(name = "usr_email", nullable = false, length = 50)
	private String usrEmail;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		UsrTknId entity = (UsrTknId)o;
		return Objects.equals(this.usrEmail, entity.usrEmail) &&
			Objects.equals(this.tkn, entity.tkn);
	}

	@Override
	public int hashCode() {
		return Objects.hash(usrEmail, tkn);
	}

}