package com.bcp.bootcamp.shopvintage.auctions.persistence.entitties;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auction {
    private String id;
    private String product;
    private String description;
    private Double amount;
    private String status;
    private Date expireDate;
}
