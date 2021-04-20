package com.bcp.bootcamp.shopvintage.auctions.persistence.repositories;

import com.bcp.bootcamp.shopvintage.auctions.persistence.entities.BidderType;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import java.util.List;

//@FeignClient(name="BCP-SHOPVINTAGE-BIDDERS")
public interface BiddersRepository {

//    @GetMapping("/bidders/types")
    Flux<BidderType> findAllTypes();

}
