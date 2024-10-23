package com.superHero.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "super_hero")
public class SuperHero {

    @Id
    @Column(name = "super_hero_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long superHeroId;

    private String alias;

    private String name;

    private String origin;

    @OneToMany(mappedBy = "superHero")
    private List<SuperHeroPowers> powers;

    @OneToMany(mappedBy = "superHero")
    private List<SuperHeroWeapons> weapons;

    @OneToMany(mappedBy = "superHero")
    private List<SuperHeroAssociations> associations;

    public SuperHero(String alias, String name, String origin) {
        this.alias = alias;
        this.name = name;
        this.origin = origin;
    }
}
