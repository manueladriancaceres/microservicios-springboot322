package com.example.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties(UriConfiguration.class)
@RestController
public class GatewayApplication {

	private final Logger logger = LoggerFactory.getLogger(GatewayApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(GatewayApplication.class, args);
	}

	/*
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/get")
						.filters(f -> f.stripPrefix(2))
						.uri("http://localhost:8003/"))
				.route(p -> p
						.path("/clientes")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://clientes"))
				.route(p -> p
						.path("/client-eureka")
						.filters(f -> f.stripPrefix(2))
						.uri("lb://client-eureka"))
				.build();
	}

	 */
}

@ConfigurationProperties
class UriConfiguration {

	private String httpbin = "http://httpbin.org:80";

	public String getHttpbin() {
		return httpbin;
	}

	public void setHttpbin(String httpbin) {
		this.httpbin = httpbin;
	}
}

