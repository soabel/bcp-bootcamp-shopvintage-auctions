package com.bcp.bootcamp.shopvintage.auctions.persistence.repositories;

import com.bcp.bootcamp.shopvintage.auctions.persistence.entities.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Date;

@Repository
public class AuctionsCustomRepositoryImpl implements AuctionsCustomRepository {

    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

//
//    public AuctionsCustomRepositoryImpl(ReactiveMongoTemplate mongoTemplate) {
//        this.mongoTemplate = mongoTemplate;
//    }

    @Override
    public Flux<Auction> findBy(String name, Double amount) {

        Query query = new Query();

        if (name != null) {
            query.addCriteria(Criteria.where("product").regex("^" + name));
        }
        if (amount != null) {
            query.addCriteria(Criteria.where("amount").gte(amount));
        }

        return mongoTemplate.find(query, Auction.class);

    }


    public void updateDate() {
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is("active"));
        Update update = new Update().set("date", new Date());
        mongoTemplate.findAndModify(query, update, Auction.class)
                .subscribe(res -> System.out.println("res = " + res));
    }

}
