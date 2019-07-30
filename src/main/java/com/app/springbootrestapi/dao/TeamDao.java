package com.app.springbootrestapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.springbootrestapi.entity.Team;

@Repository
public interface TeamDao extends JpaRepository<Team, Integer> {

	@Query(value = "SELECT * FROM team WHERE teams LIKE %:name% order by teams", nativeQuery = true)
	List<Team> findByWildCard(String name);
	
	@Query(value = "SELECT TEAMS, CITY FROM team WHERE teams = :name", nativeQuery = true)
	List<Object[]> findByName(String name);
}
