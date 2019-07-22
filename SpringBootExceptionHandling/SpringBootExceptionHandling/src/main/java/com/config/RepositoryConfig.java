package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages= {"com.repository"})
public class RepositoryConfig {

	@Autowired
	DatabaseConfig databaseConfig;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		
		dataSource.setUrl(databaseConfig.url);
		dataSource.setUsername(databaseConfig.username);
		dataSource.setPassword(databaseConfig.password);
		
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean= new LocalContainerEntityManagerFactoryBean();
		
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(databaseConfig.packagesToScan);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setJpaProperties(additionalProperties());
		
		//For enabling L2 Cache
		//entityManagerFactoryBean.setSharedCacheMode(SharedCacheMode.ALL);
		
		return entityManagerFactoryBean;
	}
	
	private Properties additionalProperties() {
		Properties properties= new Properties();
		
		properties.setProperty("hibernate.hbm2ddl.auto", databaseConfig.HIBERNATE_HBM2DDL_AUTO);
		properties.setProperty("hibernate.dialect", databaseConfig.HIBERNATE_DIALECT);
		
		return properties;
	}
}
