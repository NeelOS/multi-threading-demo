package com.multi.threading.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;



/**
 * This webclient is a basic web client to get weather details with out major authorization
 */
@Configuration
public class WebClientConfig {

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}
}
