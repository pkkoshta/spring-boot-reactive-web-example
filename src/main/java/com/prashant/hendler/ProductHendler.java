package com.prashant.hendler;

import com.prashant.entity.Product;
import com.prashant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@Component
public class ProductHendler {
    @Autowired
    private ProductService service;

    public Mono<ServerResponse> products(ServerRequest request){
        return ServerResponse.ok().body(service.getProducts(), Product.class);
    }

    public Mono<ServerResponse> addProduct(ServerRequest request){
        return request.bodyToMono(Product.class)
                .flatMap(product -> service.createProduct(product))
                .flatMap(p-> ServerResponse.created(URI.create("/product/"+ p.getId())).build());
    }

    public Mono<ServerResponse> getById(ServerRequest request){
        return service.findById(String.valueOf(request.pathVariable("id")))
                .flatMap(product -> ServerResponse.ok().body(Mono.just(product), Product.class))
                .switchIfEmpty(ServerResponse.notFound().build());

    }
}
