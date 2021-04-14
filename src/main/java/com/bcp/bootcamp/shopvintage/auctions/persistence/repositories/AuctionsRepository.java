package com.bcp.bootcamp.shopvintage.auctions.persistence.repositories;

import com.bcp.bootcamp.shopvintage.auctions.persistence.entities.Auction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AuctionsRepository extends ReactiveMongoRepository<Auction, String > {
}
