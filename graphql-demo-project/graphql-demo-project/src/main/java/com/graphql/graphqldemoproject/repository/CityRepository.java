package com.graphql.graphqldemoproject.repository;

import com.graphql.graphqldemoproject.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    City findByName(String name);

}
