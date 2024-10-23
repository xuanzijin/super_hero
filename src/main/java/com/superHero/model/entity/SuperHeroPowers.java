package com.superHero.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "super_hero_powers")
public class SuperHeroPowers {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "super_hero_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"weapons", "powers", "associations"})
    private SuperHero superHero;

    private String power;


}
