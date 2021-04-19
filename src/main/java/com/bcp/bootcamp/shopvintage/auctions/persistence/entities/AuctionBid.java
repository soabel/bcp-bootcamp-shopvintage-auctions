package com.bcp.bootcamp.shopvintage.auctions.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AuctionBid {
    private Double amount;
    private Date date;
    private Integer bidderId;
}
