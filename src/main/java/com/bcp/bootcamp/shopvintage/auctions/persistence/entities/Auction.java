package com.bcp.bootcamp.shopvintage.auctions.persistence.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(value = "auctions")
public class Auction {
    @Id
    private String id;
    private String product;
    private String description;
    private Double amount;
    private String status;
    private Date expireDate;
    private List<AuctionBid> bids;
}
