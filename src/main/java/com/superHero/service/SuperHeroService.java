package com.superHero.service;

import com.superHero.model.param.SuperHeroParam;
import com.superHero.model.vo.SuperHeroVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SuperHeroService {

    Page<SuperHeroVo> queryByAll(Pageable pageable);

    void save(SuperHeroParam param);
}
