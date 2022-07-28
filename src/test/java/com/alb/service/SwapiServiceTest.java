package com.alb.service;

import com.alb.exception.ConnectionException;
import com.alb.exception.DataNotFoundException;
import com.alb.exception.SearchCriteriaInvalid;
import com.alb.model.People;
import com.alb.model.Planet;
import com.alb.model.StarShip;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SwapiServiceTest {

    @Autowired
    private SwapiService swapiService;


    @Test
    void test_searchPeopleByExactName() throws Exception {
        People people = swapiService.searchPeopleByExactName("Darth Vader");
        assertThat(people).isNotNull();
        assertThat(people.getName()).isEqualTo("Darth Vader");

    }

    @Test
    void test_wide_search_throws_exception() throws Exception {
        assertThatThrownBy(()->swapiService.searchPeopleByExactName("Darth")).isInstanceOf(SearchCriteriaInvalid.class);
    }

    @Test
    void test_invalid_search_throws_exception() throws Exception {
        assertThatThrownBy(()->swapiService.searchPeopleByExactName("aaandndnd")).isInstanceOf(DataNotFoundException.class);
    }

    @Test
    void test_searchPlanetByExactName() throws SearchCriteriaInvalid, ConnectionException {
        Planet planet = swapiService.searchPlanetByExactName("Tatooine");
        assertThat(planet).isNotNull();
        assertThat(planet.getName()).isEqualTo("Tatooine");
    }

    @Test
    void test_searchStarShipByExactName() throws SearchCriteriaInvalid, ConnectionException {
        StarShip ship = swapiService.searchStarShipByExactName("Star Destroyer");
        assertThat(ship).isNotNull();
        assertThat(ship.getName()).isEqualTo("Star Destroyer");
    }


}