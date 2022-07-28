package com.alb.service;

import com.alb.exception.ConnectionException;
import com.alb.exception.DataNotFoundException;
import com.alb.exception.SearchCriteriaInvalid;
import com.alb.model.People;
import com.alb.model.Planet;
import com.alb.model.StarShip;
import com.alb.model.SwapiSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SwapiService<T> {

    @Value("${BASE_URL:}")
    private String BASE_URL;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Method to return single record based on search criteria .Assumption that search by exact name returns single match no need to handle pagination . First record will be picked up and return
     *
     * @param name
     * @return
     * @throws DataNotFoundException
     * @throws ConnectionException
     */
    public People searchPeopleByExactName(String name) throws DataNotFoundException, ConnectionException, SearchCriteriaInvalid {
        if (!checkConnect())
            throw new ConnectionException("Connecition error to Swapi..");
        List<People> people = restTemplate.exchange(BASE_URL + "/people?search=" + name, HttpMethod.GET, null,
                new ParameterizedTypeReference<SwapiSearchResponse<People>>() {
                }).getBody().getResults();
        if (people == null || people.isEmpty()) {
            throw new DataNotFoundException("Couldn't find any Person by name:" + name);
        } else if (people.size() > 1) {
            throw new SearchCriteriaInvalid("Multiple matches found for search criteria:" + name);
        }
        return people.get(0);


    }

    /**
     * Method to return single record based on search criteria .Assumption that search by exact name returns single match no need to handle pagination . First record will be picked up and return
     *
     * @param name
     * @return
     * @throws DataNotFoundException
     * @throws ConnectionException
     */
    public Planet searchPlanetByExactName(String name) throws DataNotFoundException, ConnectionException, SearchCriteriaInvalid {
        if (!checkConnect())
            throw new ConnectionException("Connecition error to Swapi..");
        List<Planet> planets = restTemplate.exchange(BASE_URL + "/planets?search=" + name, HttpMethod.GET, null,
                new ParameterizedTypeReference<SwapiSearchResponse<Planet>>() {
                }).getBody().getResults();
        if (planets == null || planets.isEmpty()) {
            throw new DataNotFoundException("Couldn't find any Planet by name:" + name);
        } else if (planets.size() > 1) {
            throw new SearchCriteriaInvalid("Multiple matches found for search criteria:" + name);
        }
        return planets.get(0);


    }

    /**
     * Method to return single record based on search criteria .Assumption that search by exact name returns single match no need to handle pagination . First record will be picked up and return
     *
     * @param name
     * @return
     * @throws DataNotFoundException
     * @throws ConnectionException
     */
    public StarShip searchStarShipByExactName(String name) throws DataNotFoundException, ConnectionException, SearchCriteriaInvalid {
        if (!checkConnect())
            throw new ConnectionException("Connecition error to Swapi..");
        List<StarShip> starShips = restTemplate.exchange(BASE_URL + "/starships?search=" + name, HttpMethod.GET, null,
                new ParameterizedTypeReference<SwapiSearchResponse<StarShip>>() {
                }).getBody().getResults();
        if (starShips == null || starShips.isEmpty()) {
            throw new DataNotFoundException("Couldn't find any starShips by name:" + name);
        }
        starShips = starShips.stream().filter(s -> s.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (starShips.size() > 1) {

            throw new SearchCriteriaInvalid("Multiple matches found for search criteria:" + name);
        }
        return starShips.get(0);


    }


    public StarShip getShipById(String id) throws DataNotFoundException, ConnectionException {
        if (!checkConnect())
            throw new ConnectionException("Connecition error to Swapi..");
        StarShip starShip = restTemplate.getForObject(BASE_URL + "/starships/" + id, StarShip.class);

        if (starShip == null) {
            throw new DataNotFoundException("Couldn't find and starship by Id:" + id);

        }
        return starShip;

    }

    public Planet getPlanetById(String id) throws DataNotFoundException, ConnectionException {
        if (!checkConnect())
            throw new ConnectionException("Connecition error to Swapi..");
        Planet planet = restTemplate.getForObject(BASE_URL + "/planets/" + id, Planet.class);

        if (planet == null) {
            throw new DataNotFoundException("Couldn't find and Planet by Id:" + id);

        }
        return planet;

    }

    private boolean checkConnect() {
        try {
            URL url = new URL(BASE_URL);
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
