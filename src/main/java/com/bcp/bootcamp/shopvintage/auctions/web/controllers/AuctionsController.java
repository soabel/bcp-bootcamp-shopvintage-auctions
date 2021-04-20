package com.bcp.bootcamp.shopvintage.auctions.web.controllers;

import com.bcp.bootcamp.shopvintage.auctions.persistence.entities.Auction;
import com.bcp.bootcamp.shopvintage.auctions.persistence.entities.AuctionBid;
import com.bcp.bootcamp.shopvintage.auctions.persistence.entities.BidderType;
import com.bcp.bootcamp.shopvintage.auctions.persistence.repositories.AuctionsCustomRepository;
import com.bcp.bootcamp.shopvintage.auctions.persistence.repositories.AuctionsRepository;
import com.bcp.bootcamp.shopvintage.auctions.persistence.repositories.BiddersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.management.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("auctions")
public class AuctionsController {

    @Autowired
    private AuctionsRepository auctionsRepository;

    @Autowired
    private AuctionsCustomRepository auctionsCustomRepository;

    @Autowired
    private BiddersRepository biddersRepository;

    @GetMapping
    public Flux<Auction> findAll() {
        return this.auctionsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Auction> findById(@PathVariable String id) {
        return this.auctionsRepository.findById(id);
    }

    @PostMapping
    public Mono<Auction> save(@RequestBody Auction auction) {
        return this.auctionsRepository.save(auction);
    }

    @PostMapping("/bulk")
    public Flux<Auction> saveAll(@RequestBody List<Auction> auctions) {
        return this.auctionsRepository.saveAll(auctions);
    }

    @GetMapping("/by-ids")
    public Flux<Auction> findAllById(@RequestBody List<String> ids) {
        return this.auctionsRepository.findAllById(ids);
    }

    @PatchMapping("{id}/bids")
    Mono<Auction> addBid (@PathVariable String id, @RequestBody AuctionBid bid) {

         return this.auctionsRepository
        .findById(id)
        .flatMap(au -> {
            if (au.getBids() == null) {
                au.setBids(new ArrayList<>());
            }
            bid.setDate(new Date());
            au.getBids().add(bid);
            return this.auctionsRepository.save(au);
        });

//        this.auctionsRepository
//                .findById(id)
//                .subscribe(au -> {
//                    if (au.getBids() == null) {
//                        au.setBids(new ArrayList<>());
//                    }
//                    bid.setDate(new Date());
//                    au.getBids().add(bid);
//                    this.auctionsRepository.save(au)
//                            .subscribe(aux -> System.out.println("aux = " + aux));
//                });


    }

    @GetMapping("/query")
    public Flux<Auction> findQuery(@RequestParam(value = "product", required = false) String product,
                                   @RequestParam(value = "amount", required = false) Double amount) {

        System.out.println("product = " + product);
        System.out.println("amount = " + amount);

        return this.auctionsCustomRepository.findBy(product, amount);
    }

    @PatchMapping("/update-date")
    public void updateDate(){
         this.auctionsCustomRepository.updateDate();
    }

    @GetMapping("/bidders/types")
    public Flux<BidderType> findAllTypes(){
        return this.biddersRepository.findAllTypes();
    }




}
