package com.jyeory.kookie.config.mysql;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Slf4j
@Configuration
public class DataSource {

	@Value("${spring.datasource.hikari.jdbc-url}")
	private String jdbcUrl;
	@Value("${spring.datasource.hikari.username}")
	String username;
	@Value("${spring.datasource.hikari.password}")
	String password;
	@Value("${spring.datasource.hikari.driver-class-name}")
	String driverClassName;
	@Value("${spring.datasource.hikari.leakDetectionThreshold}")
	Integer leakDetectionThreshold;
	@Value("${spring.datasource.hikari.maximum-pool-size}")
	Integer maximumPoolSize;
	@Value("${spring.datasource.hikari.connection-timeout}")
	Integer connectionTimeout;
	@Value("${spring.datasource.hikari.max-lifetime}")
	Integer maxLifeTime;
	@Value("${spring.datasource.hikari.idle-timeout}")
	Integer idleTimeout;
	@Value("${spring.datasource.hikari.minimum-idle}")
	Integer minimumIdel;


	@Bean(name = "dataSource")
	public javax.sql.DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(this.jdbcUrl);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setPoolName("DataSource");

		dataSource.setLeakDetectionThreshold(leakDetectionThreshold);
		dataSource.setMaximumPoolSize(maximumPoolSize);
		dataSource.setConnectionTimeout(connectionTimeout);
		dataSource.setMaxLifetime(maxLifeTime);
		dataSource.setIdleTimeout(idleTimeout);
		dataSource.setMinimumIdle(minimumIdel);

		return dataSource;
	}
}
