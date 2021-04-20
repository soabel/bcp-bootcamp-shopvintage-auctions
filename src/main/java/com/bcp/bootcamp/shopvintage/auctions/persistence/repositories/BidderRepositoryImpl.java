package com.bcp.bootcamp.shopvintage.auctions.persistence.repositories;

import com.bcp.bootcamp.shopvintage.auctions.persistence.entities.BidderType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public class BidderRepositoryImpl implements BiddersRepository{

    private final WebClient webClient;

    //    @Value("${shopvintage.services.bidders_url}")
//    private String biddersUrl;

    public BidderRepositoryImpl(WebClient.Builder webClientBuilder,
                                @Value("${shopvintage.services.bidders_url}") String biddersUrl) {

        System.out.println("biddersUrl = " + biddersUrl);
        this.webClient = webClientBuilder.baseUrl(biddersUrl).build();
    }

    @Override
    public Flux<BidderType> findAllTypes() {

        return this.webClient
                .get()
                .uri("/bidders/types")
                .retrieve()
                .bodyToFlux(BidderType.class);

    }
}
