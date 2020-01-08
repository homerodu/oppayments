package com.coe.cloud.openpay.payments.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.coe.cloud.openpay.payments.*")
@PropertySource("classpath:application.yaml")
public class Configure {
	//To resolve ${} in @Value
	//@Bean
	//public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
	//	return new PropertySourcesPlaceholderConfigurer();
	//}
}
