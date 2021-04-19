package com.bcp.bootcamp.shopvintage.auctions.persistence.repositories;

import com.bcp.bootcamp.shopvintage.auctions.persistence.entities.Auction;
import reactor.core.publisher.Flux;

public interface AuctionsCustomRepository {
     Flux<Auction> findByName(String name);
}
