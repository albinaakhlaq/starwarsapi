package com.alb.service;

import com.alb.exception.ConnectionException;
import com.alb.exception.SearchCriteriaInvalid;
import com.alb.model.StarShip;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class InformationQueryServiceTest {

   @Autowired
   InformationQueryService informationQueryService;

    @Test
    void getStarShipsForPerson() throws SearchCriteriaInvalid, ConnectionException {

        StarShip starShip  = informationQueryService.getStarShipsForPerson("Darth Vader");
        assertThat(starShip).isNotNull();
        assertThat(starShip.getName()).isEqualTo("TIE Advanced x1");
    }

    @Test
    void getStarShipsForPerson_multiple() throws SearchCriteriaInvalid, ConnectionException {

        StarShip starShip  = informationQueryService.getStarShipsForPerson("Luke Skywalker");
        assertThat(starShip).isNotNull();
        assertThat(starShip.getName()).isEqualTo("X-wing");
    }

    @Test
    void checkPersonOnPlanet() throws SearchCriteriaInvalid, ConnectionException {

        assertThat(informationQueryService.checkPersonOnPlanet("Leia Organa","Alderaan")).isTrue();
        assertThat(informationQueryService.checkPersonOnPlanet("Leia Organa","Tatooine")).isFalse();
    }

    @Test
    void getNumberOfCrewOnStarShip() throws SearchCriteriaInvalid, ConnectionException {
        assertThat(informationQueryService.getNumberOfCrewOnStarShip("Death Star")).isEqualTo(342953);
    }
}