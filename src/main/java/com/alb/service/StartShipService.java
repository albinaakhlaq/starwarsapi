package com.alb.service;

import com.alb.exception.ConnectionException;
import com.alb.exception.DataNotFoundException;
import com.alb.exception.SearchCriteriaInvalid;
import com.alb.model.StarShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartShipService {

    @Autowired
    private SwapiService swapiService;

    public StarShip getShipById(String id) throws DataNotFoundException, ConnectionException {
        return swapiService.getShipById(id);

    }

    public StarShip findByName(String name) throws ConnectionException, SearchCriteriaInvalid {
        return swapiService.searchStarShipByExactName(name);

    }


}
