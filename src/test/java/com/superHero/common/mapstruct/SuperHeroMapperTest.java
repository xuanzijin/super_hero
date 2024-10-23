package com.superHero.common.mapstruct;

import com.superHero.model.entity.SuperHero;
import com.superHero.model.entity.SuperHeroAssociations;
import com.superHero.model.entity.SuperHeroPowers;
import com.superHero.model.entity.SuperHeroWeapons;
import com.superHero.model.vo.SuperHeroVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SuperHeroMapperTest {
    private final SuperHeroMapper superHeroMapper = new SuperHeroMapperImpl();

    @Test
    void testToSuperHeroVo() {
        SuperHero superHero = new SuperHero();
        superHero.setSuperHeroId(1L);
        superHero.setAlias("alias1");
        superHero.setName("name1");
        superHero.setOrigin("origin1");
        superHero.setPowers(Arrays.asList(SuperHeroPowers.builder().power("power1").build(), SuperHeroPowers.builder().power("power2").build()));
        superHero.setWeapons(Arrays.asList(SuperHeroWeapons.builder().weapon("weapon1").build(), SuperHeroWeapons.builder().weapon("weapon2").build()));
        superHero.setAssociations(Arrays.asList(SuperHeroAssociations.builder().association("association1").build(), SuperHeroAssociations.builder().association("association2").build()));
        SuperHeroVo actualSuperHeroVo = superHeroMapper.toSuperHeroVo(superHero);

        SuperHeroVo expectedSuperHeroVo = SuperHeroVo.builder()
                .alias("alias1")
                .name("name1")
                .origin("origin1")
                .powers("power1,power2")
                .weapons("weapon1,weapon2")
                .associations("association1,association2")
                .build();

        Assertions.assertEquals(expectedSuperHeroVo, actualSuperHeroVo);
    }



}
