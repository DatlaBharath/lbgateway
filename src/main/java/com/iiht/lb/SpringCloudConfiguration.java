package com.iiht.lb;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfiguration {
	@Bean public RouteLocator gatewayRoute(RouteLocatorBuilder builder) {
		return 
				builder.routes()
				.route(
						"helloservice-route", 
						r->r.path("/test/**")
							.filters(f-> f.addRequestHeader("hello", "world"))
							.uri("lb://LBSERVICE")
				)
				.build();
	}
}