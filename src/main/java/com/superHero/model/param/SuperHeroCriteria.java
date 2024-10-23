package com.superHero.model.param;

import lombok.Data;


@Data
public class SuperHeroCriteria {

    private Long id;

    private String alias;

    private String name;

    private String origin;

    private String powers;

    private String weapons;

    private String associations;

    private int pageNum = 1;

    private int pageSize = 10;

}
