package com.superHero.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.superHero.common.mapstruct.SuperHeroMapper;
import com.superHero.model.entity.SuperHero;
import com.superHero.model.entity.SuperHeroAssociations;
import com.superHero.model.entity.SuperHeroPowers;
import com.superHero.model.entity.SuperHeroWeapons;
import com.superHero.model.param.SuperHeroParam;
import com.superHero.model.vo.SuperHeroVo;
import com.superHero.repository.SuperHeroAssociationsRepository;
import com.superHero.repository.SuperHeroPowersRepository;
import com.superHero.repository.SuperHeroRepository;
import com.superHero.repository.SuperHeroWeaponsRepository;
import com.superHero.service.SuperHeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SuperHeroServiceImpl implements SuperHeroService {

    private final SuperHeroRepository superHeroRepository;
    private final SuperHeroPowersRepository powersRepository;
    private final SuperHeroWeaponsRepository weaponsRepository;
    private final SuperHeroAssociationsRepository associationsRepository;
    private final SuperHeroMapper superHeroMapper;

    @Override
    public Page<SuperHeroVo> queryByAll(Pageable pageable) {
        Page<SuperHero> pageResult = superHeroRepository.findAll(pageable);
        List<SuperHeroVo> superHeroVoList = pageResult.getContent().stream().map(superHeroMapper::toSuperHeroVo).collect(Collectors.toList());
        return new PageImpl<>(superHeroVoList, pageable, pageResult.getTotalElements());
    }

    @Override
    @Transactional
    public void save(SuperHeroParam param) {
        // save SuperHero
        SuperHero superHero = new SuperHero(param.getAlias(), param.getName(), param.getOrigin());
        superHeroRepository.save(superHero);

        // save SuperHeroPowers
        if (CollectionUtil.isNotEmpty(param.getPowers())) {
            for (String power : param.getPowers()) {
                powersRepository.save(SuperHeroPowers.builder()
                        .power(power)
                        .superHero(superHero)
                        .build());
            }
        }

        // save SuperHeroWeapons
        if (CollectionUtil.isNotEmpty(param.getWeapons())) {
            for (String weapon : param.getWeapons()) {
                weaponsRepository.save(SuperHeroWeapons.builder()
                        .weapon(weapon)
                        .superHero(superHero)
                        .build());
            }
        }

        // save SuperHeroAssociations
        if (CollectionUtil.isNotEmpty(param.getAssociations())) {
            for (String association : param.getAssociations()) {
                associationsRepository.save(SuperHeroAssociations.builder()
                        .association(association)
                        .superHero(superHero)
                        .build());
            }
        }

    }
}
