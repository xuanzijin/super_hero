package com.superHero.common.mapstruct;

import com.superHero.model.entity.SuperHero;
import com.superHero.model.entity.SuperHeroAssociations;
import com.superHero.model.entity.SuperHeroPowers;
import com.superHero.model.entity.SuperHeroWeapons;
import com.superHero.model.vo.SuperHeroVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface SuperHeroMapper {

    @Mapping(target = "alias", source = "alias")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "origin", source = "origin")
    @Mapping(target = "powers", source = "powers", qualifiedByName = "powersListToString")
    @Mapping(target = "weapons", source = "weapons", qualifiedByName = "weaponsListToString")
    @Mapping(target = "associations", source = "associations", qualifiedByName = "associationsListToString")
    SuperHeroVo toSuperHeroVo(SuperHero superHero);

    @Named("powersListToString")
    default String powersListToString(List<SuperHeroPowers> list) {
        return list.stream().map(SuperHeroPowers::getPower).collect(Collectors.joining(","));
    }

    @Named("weaponsListToString")
    default String weaponsListToString(List<SuperHeroWeapons> list) {
        return list.stream().map(SuperHeroWeapons::getWeapon).collect(Collectors.joining(","));
    }

    @Named("associationsListToString")
    default String associationsListToString(List<SuperHeroAssociations> list) {
        return list.stream().map(SuperHeroAssociations::getAssociation).collect(Collectors.joining(","));
    }

}
