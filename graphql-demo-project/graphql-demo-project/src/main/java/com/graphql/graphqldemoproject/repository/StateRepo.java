package com.graphql.graphqldemoproject.repository;

import com.graphql.graphqldemoproject.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends JpaRepository<State,Integer> {
}
