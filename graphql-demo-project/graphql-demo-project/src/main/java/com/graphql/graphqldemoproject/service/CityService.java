package com.graphql.graphqldemoproject.service;


import com.graphql.graphqldemoproject.entity.City;
import com.graphql.graphqldemoproject.entity.State;
import com.graphql.graphqldemoproject.repository.CityRepository;
import com.graphql.graphqldemoproject.repository.StateRepo;
import com.graphql.graphqldemoproject.response.CityResponse;
import com.graphql.graphqldemoproject.response.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private StateRepo stateRepo;

    public City getCityById(Integer id){
        return cityRepository.findById(id).get();
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public StateResponse getSateById(Integer id) {
        State state = new State();
        City city = new City();
        Optional<State> byId = stateRepo.findById(id);
        if (byId.isPresent()){
            state=byId.get();
        }
        Optional<City> cityOptional = cityRepository.findById(id);
        if (cityOptional.isPresent()){
            city = cityOptional.get();
        }
        StateResponse stateResponse = new StateResponse();
        stateResponse.setName(state.getName());
        stateResponse.setCountry(state.getCountry());
        CityResponse cityResponse = new CityResponse();
        cityResponse.setName(city.getName());
        cityResponse.setPopulation(city.getPopulation());
        stateResponse.setCityResponse(cityResponse);
        return stateResponse;
    }

    public List<City> getAllCity() {
        return cityRepository.findAll();
    }
}
