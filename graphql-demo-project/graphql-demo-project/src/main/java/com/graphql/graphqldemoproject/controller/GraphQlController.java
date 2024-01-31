package com.graphql.graphqldemoproject.controller;

import com.graphql.graphqldemoproject.entity.City;
import com.graphql.graphqldemoproject.response.StateResponse;
import com.graphql.graphqldemoproject.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQlController {
    @Autowired
    private CityService cityService;

    @QueryMapping("getCity")
    public City getCityById(@Argument Integer id){
        return cityService.getCityById(id);
    }

    @MutationMapping("createCity")
    public City saveCity(@Argument("city") CityInput cityInput){
        City newCity = new City();
        newCity.setName(cityInput.getName());
        newCity.setPopulation(cityInput.getPopulation());
        return cityService.saveCity(newCity);
    }

    @MutationMapping("updateCity")
    public City updateCity(@Argument("id") Integer id, @Argument("cityInput") CityInput cityInput) {
        City existingCity = cityService.getCityById(id);
        // Update city properties with new data
        existingCity.setName(cityInput.getName());
        existingCity.setPopulation(cityInput.getPopulation());

        // Save the updated city
        return cityService.saveCity(existingCity);
    }
    @QueryMapping("getStateById")
    public StateResponse getStateById(@Argument Integer id) {
        return cityService.getSateById(id);
    }

    @QueryMapping("allCity")
    public List<City> getAllCity(){
        return cityService.getAllCity();
    }

    private static class CityInput {
        private String name;
        private Long population;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getPopulation() {
            return population;
        }

        public void setPopulation(Long population) {
            this.population = population;
        }
    }
}
