package com.superHero.model.param;

import lombok.Data;

import java.util.List;

@Data
public class SuperHeroParam {

    private String alias;

    private String name;

    private String origin;

    private List<String> powers;

    private List<String> weapons;

    private List<String> associations;

}
