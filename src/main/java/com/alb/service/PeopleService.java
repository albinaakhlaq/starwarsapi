package com.alb.service;

import com.alb.exception.ConnectionException;
import com.alb.exception.SearchCriteriaInvalid;
import com.alb.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

    @Autowired
    private SwapiService swapiService;

    public People findByName(String name) throws ConnectionException, SearchCriteriaInvalid {
        return swapiService.searchPeopleByExactName(name);

    }

//    public List<People>findAll() {
//        return swapiService.getPeople();
//    }
}
