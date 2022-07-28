package com.alb.service;

import com.alb.exception.ConnectionException;
import com.alb.exception.SearchCriteriaInvalid;
import com.alb.model.People;
import com.alb.model.Planet;
import com.alb.model.StarShip;
import com.alb.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InformationQueryService {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private StartShipService startShipService;

    @Autowired
    private PlanetService planetService;

    public StarShip getStarShipsForPerson(String person_name) throws ConnectionException, SearchCriteriaInvalid {

        People people = peopleService.findByName(person_name);
        if (people != null && people.getStarshipUrl() != null) {
            String id = Utils.extractIdFromURL(people.getStarshipUrl().get(0));
            StarShip starShip = startShipService.getShipById(id);
            return starShip;

        } else {
            return new StarShip();
        }

    }


    public boolean checkPersonOnPlanet(String person_name, String planet_name) throws ConnectionException, SearchCriteriaInvalid {
        boolean response = Boolean.FALSE;
        People searchPerson = peopleService.findByName(person_name);
        if(searchPerson == null || searchPerson.getHomeworld() == null)
            return response;
        String planetId = Utils.extractIdFromURL(searchPerson.getHomeworld());
        Planet planet = planetService.findById(planetId);
        response = Optional.ofNullable(planet).isPresent() && planet.getName().equalsIgnoreCase(planet_name);
        return response;

    }

    public int getNumberOfCrewOnStarShip(String name) throws ConnectionException, SearchCriteriaInvalid {
        StarShip starShip = startShipService.findByName(name);
        int crew = starShip.getCrew() != null ? Integer.parseInt(starShip.getCrew().replace(",", "")) : 0;
        return crew;
    }


}
