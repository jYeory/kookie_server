package com.jyeory.kookie.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jyeory.kookie.auth.CustomUserDetails;
import com.jyeory.kookie.rest.entity.Usr;
import com.jyeory.kookie.rest.entity.UsrRole;
import com.jyeory.kookie.rest.usr.repository.UsrRepository;
import com.jyeory.kookie.rest.usr.repository.UsrRoleRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class KookieUserDetailService implements UserDetailsService {

	private final UsrRepository usrRepository;
	private final UsrRoleRepository usrRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usr> usr = usrRepository.findById(username);
		if (usr.isEmpty()) {
			throw new UsernameNotFoundException("User(" + username + ") is not found.");
		}
		UsrRole role = usrRoleRepository.findByUsrEmail(usr.get());

		ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().getId()));
		return new CustomUserDetails(usr.get(), grantedAuthorities);
	}
}
