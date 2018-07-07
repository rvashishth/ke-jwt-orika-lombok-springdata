package com.wolftechnica.app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author rvashishth
 *
 */
@Configuration
@EntityScan("com.airtel.kyc.kenya.entity")
@EnableJpaRepositories(basePackages="com.airtel.kyc.kenya.repository")
@EnableTransactionManagement 
public class DatabaseConfig {

	/* By default, CRUD methods on repository instances are transactional */
	/* @EnableTransactionManagement to use any @Transactional on service classes */
	
}
