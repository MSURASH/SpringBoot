package com.app.springbootrestapi.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "team")
public class Team implements Serializable{
	
	@Id
	private int id;
	
	private String teams;
	
	
	private String city;

	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Team(int id, String teams, String city) {
		super();
		this.id = id;
		this.teams = teams;
		this.city = city;
	}

	public Team(String teams, String city) {
		super();
		this.teams = teams;
		this.city = city;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTeams() {
		return teams;
	}


	public void setTeams(String teams) {
		this.teams = teams;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Team [id=" + id + ", teams=" + teams + ", city=" + city + "]";
	}

	
	
	
	//Use Lombok dependency for setters and getters
	
	

}
