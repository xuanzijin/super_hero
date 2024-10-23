package com.superHero.model.vo;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class SuperHeroVo {

    private String alias;

    private String name;

    private String origin;

    private String powers;

    private String weapons;

    private String associations;

}
