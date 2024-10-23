package com.superHero.controller;

import com.alibaba.fastjson.JSON;
import com.superHero.model.vo.SuperHeroVo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class SuperHeroControllerTest {

    @LocalServerPort
    private int port;

    @BeforeAll
    public void beforeClass() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    @Test
    void testSaveAndQueryAll() {
        // test save()
        Map<String, Object> body = new HashMap<>();
        body.put("alias", "alias1");
        body.put("name", "name1");
        body.put("origin", "origin1");
        body.put("powers", Arrays.asList("power1", "power2"));
        body.put("weapons", Arrays.asList("weapon1", "weapon2"));
        body.put("associations", Arrays.asList("association1", "association2"));
        RestAssured.given()
                .basePath("/superHero")
                .body(body)
                .contentType(ContentType.JSON)
                .post()
                .then()
                .assertThat()
                .statusCode(200);

        // test queryAll()
        String res = RestAssured.given()
                .basePath("/superHero")
                .get("?pageNum=1&pageSize=10")
                .then()
                .assertThat()
                .extract()
                .asString();
        SuperHeroVo actualSuperHeroVo = JSON.parseObject(res).getJSONArray("content").getJSONObject(0).toJavaObject(SuperHeroVo.class);

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
