package com.bcp.bootcamp.shopvintage.auctions.persistence.repositories;

import com.bcp.bootcamp.shopvintage.auctions.persistence.entities.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class AuctionsCustomRepositoryImpl implements AuctionsCustomRepository {

    @Autowired
    private  ReactiveMongoTemplate mongoTemplate;

//
//    public AuctionsCustomRepositoryImpl(ReactiveMongoTemplate mongoTemplate) {
//        this.mongoTemplate = mongoTemplate;
//    }

    @Override
    public Flux<Auction> findByName(String name) {

        Query query = new Query(Criteria.where("product").regex("^" + name));

        return mongoTemplate.find(query, Auction.class);

    }

}
