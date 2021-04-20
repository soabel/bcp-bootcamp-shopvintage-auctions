package com.bcp.bootcamp.shopvintage.auctions.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BidderType {
    private Integer id;
    private String name;
}
