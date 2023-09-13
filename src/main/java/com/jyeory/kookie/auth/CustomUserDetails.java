package com.jyeory.kookie.auth;

import java.util.Collection;
import com.jyeory.kookie.rest.entity.Usr;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private final Usr loginUsr;
	private final Collection<? extends GrantedAuthority> authorities;

	public CustomUserDetails(Usr loginUsr) {
		this.loginUsr = loginUsr;
		this.authorities = null;
	}

	public CustomUserDetails(Usr loginUsr, Collection<? extends GrantedAuthority> authorities) {
		this.loginUsr = loginUsr;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.loginUsr.getPasswd();
	}

	@Override
	public String getUsername() {
		return this.loginUsr.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
