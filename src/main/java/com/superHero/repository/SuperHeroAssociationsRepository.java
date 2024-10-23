package com.superHero.repository;

import com.superHero.model.entity.SuperHeroAssociations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroAssociationsRepository extends JpaRepository<SuperHeroAssociations, Long> {

}
