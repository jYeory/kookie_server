package com.jyeory.kookie.config.security;

import static org.springframework.security.config.Customizer.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Objects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;
import com.jyeory.kookie.auth.service.KookieUserDetailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
@RequiredArgsConstructor
public class SecurityConfig {

	private final KookieUserDetailService userDetailService;
	private final Environment env;

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/ignore1", "/ignore2");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic(HttpBasicConfigurer::disable)
			.csrf(CsrfConfigurer::disable)
			.cors(Customizer.withDefaults())
			.authorizeHttpRequests((authz) ->
				authz
					.requestMatchers("/actuator/**", "/swagger-ui/**", "/sign/**",
						"/api-docs/swagger-config", "/sign-in", "/sign-up").permitAll()
					.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
					.anyRequest().authenticated())
			.sessionManagement(configure -> configure.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.httpBasic(withDefaults());
		return http.build();
	}

	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	public PasswordEncoder bCryptPasswordEncoder() throws NoSuchAlgorithmException {
		return new BCryptPasswordEncoder(10, SecureRandom.getInstance("SHA1PRNG"));
	}

	private String getSalt() {
		String saltKeyPath = env.getProperty("salt.key");
		StringBuilder sb = null;
		InputStream is = null;
		try {
			if (saltKeyPath == null) {
				throw new NullPointerException();
			}
			is = Files.newInputStream(new File(saltKeyPath).toPath());
			sb = new StringBuilder();
			byte[] bytes = new byte[4096];
			int idx = 0;
			while ((idx = is.read(bytes)) != -1) {
				sb.append(new String(bytes, 0, idx));
			}
		} catch (IOException | NullPointerException e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				Objects.requireNonNull(is).close();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
		String salt = sb == null ? "" : sb.toString();
		return salt.replaceAll("\\n", "");
	}

}
