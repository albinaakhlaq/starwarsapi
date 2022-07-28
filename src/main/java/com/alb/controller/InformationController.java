package com.alb.controller;

import com.alb.exception.ConnectionException;
import com.alb.exception.SearchCriteriaInvalid;
import com.alb.model.Information;
import com.alb.model.StarShip;
import com.alb.service.InformationQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController

public class InformationController {

    @Autowired
    private InformationQueryService informationQueryService;


    @GetMapping(value = "/information", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getInformation() throws RestClientException, ConnectionException, SearchCriteriaInvalid {
        int numberOfCrew = informationQueryService.getNumberOfCrewOnStarShip("Death Star");
        StarShip starShip = informationQueryService.getStarShipsForPerson("Darth Vader");
        boolean check = informationQueryService.checkPersonOnPlanet("Leia Organa", "Alderaan");
        return getObjectResponseEntity(numberOfCrew, check, starShip);


    }

    private ResponseEntity<Object> getObjectResponseEntity(int numberOfCrew, boolean isLeiaOnPlanet, StarShip starShip) {

        Information info = new Information();
        info.setStarShip(starShip);
        info.setCrew(numberOfCrew);
        info.setLeiaOnPlanet(isLeiaOnPlanet);
        return ResponseEntity.status(HttpStatus.OK).body(info);
    }


}
