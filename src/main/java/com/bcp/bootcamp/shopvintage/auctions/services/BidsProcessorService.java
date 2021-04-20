package com.bcp.bootcamp.shopvintage.auctions.services;


import com.bcp.bootcamp.shopvintage.auctions.persistence.entities.AuctionBid;

import com.bcp.bootcamp.shopvintage.auctions.persistence.repositories.AuctionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;

@Service
public class BidsProcessorService {

    @Autowired
    private AuctionsRepository auctionsRepository;

    @Bean
    public Consumer<AuctionBid> bidConsumer() {

        return (bid) -> {
            System.out.println("Message procesed");
            System.out.println("bid = " + bid);

            this.auctionsRepository
                    .findById(bid.getAuctionId())
                    .flatMap(au -> {
                        if (au.getBids() == null) {
                            au.setBids(new ArrayList<>());
                        }
                        bid.setDate(new Date());
                        au.getBids().add(bid);
                        return this.auctionsRepository.save(au);
                    }).subscribe(a-> {
                System.out.println("added bid");
                System.out.println("a = " + a);
            });

        };
    }

}
