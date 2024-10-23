package com.superHero.controller;

import com.superHero.model.param.SuperHeroParam;
import com.superHero.model.vo.SuperHeroVo;
import com.superHero.service.SuperHeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/superHero")
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    @GetMapping
    public Page<SuperHeroVo> queryAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return superHeroService.queryByAll(pageable);
    }

    @PostMapping
    public void save(@RequestBody SuperHeroParam param) {
        superHeroService.save(param);
    }
}
