package com.bcp.bootcamp.shopvintage.auctions.web.controllers;

import com.bcp.bootcamp.shopvintage.auctions.persistence.entitties.Auction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("auctions")
public class AuctionsController {

    @GetMapping
    public List<Auction> findAll(){
        List<Auction> list = new ArrayList<>();

        var auction= new Auction();

        auction.setId("01");
        auction.setProduct("Espada medieval");
        auction.setAmount(500.50);
        auction.setStatus("active");
        auction.setDescription("Encontrado en tierra santa");


        list.add(auction);

        return list;

    }

}
