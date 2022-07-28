package com.alb.service;

import com.alb.exception.ConnectionException;
import com.alb.exception.SearchCriteriaInvalid;
import com.alb.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {
    @Autowired
    private SwapiService swapiService;

    public Planet findByName(String name) throws ConnectionException, SearchCriteriaInvalid {
        return swapiService.searchPlanetByExactName(name);

    }

    public Planet findById(String id) throws ConnectionException, SearchCriteriaInvalid {
        return swapiService.getPlanetById(id);

    }
}
