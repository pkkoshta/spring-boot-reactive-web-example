package com.prashant;

import com.prashant.hendler.ProductHendler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
@SpringBootApplication
public class ProductServiceReactiveReactiveWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceReactiveReactiveWithMongoDbApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> routerFunction(ProductHendler productHendler){
		return route(GET("/products"), productHendler::products)
				.andRoute(POST("/product"), productHendler::addProduct)
				.andRoute(GET("/product/{id}"), productHendler::getById)
		;
	}

}
