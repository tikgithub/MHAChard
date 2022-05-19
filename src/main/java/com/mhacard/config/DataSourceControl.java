package com.mhacard.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceControl {
	
	@Bean(name="localDB")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource mHALocalDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="localJDBCTemplate")
	public JdbcTemplate localDBJDBCTemplate(@Qualifier("localDB") DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean(name="LVBSwitchDB")
	@ConfigurationProperties(prefix = "spring.second-datasource")
	public DataSource LVBSwitchDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="LVBSwitchJDBCTemplate")
	public JdbcTemplate localDataSource(@Qualifier("LVBSwitchDB") DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
