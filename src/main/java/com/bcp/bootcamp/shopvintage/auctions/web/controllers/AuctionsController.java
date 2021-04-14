package com.bcp.bootcamp.shopvintage.auctions.web.controllers;

import com.bcp.bootcamp.shopvintage.auctions.persistence.entities.Auction;
import com.bcp.bootcamp.shopvintage.auctions.persistence.repositories.AuctionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("auctions")
public class AuctionsController {

    @Autowired
    private AuctionsRepository auctionsRepository;

    @GetMapping
    public Flux<Auction> findAll(){
        return this.auctionsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Auction> findById(@PathVariable String id){
        return this.auctionsRepository.findById(id);
    }

    @PostMapping
    public Mono<Auction> save(@RequestBody Auction auction){

//        this.auctionsRepository.saveAll
//        this.auctionsRepository.findAllById()

        return this.auctionsRepository.save(auction);
    }

}
