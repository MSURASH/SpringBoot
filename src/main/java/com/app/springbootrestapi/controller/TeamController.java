package com.app.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.springbootrestapi.dao.TeamDao;
import com.app.springbootrestapi.entity.Team;

@RequestMapping("team")
@RestController
public class TeamController {

	@Autowired
	private TeamDao teamDao;
	
	@PostMapping("/save")
	public Team save(@RequestBody Team team) {
		System.out.println(team);

		return teamDao.save(team);
		
	}
	
	@PutMapping("/update")
	public Team update(@RequestBody Team team) {
		return teamDao.saveAndFlush(team);
		
	}
	
	@GetMapping("/all")
	public List<Team> getAllTeam() {
		return teamDao.findAll();
		
	}
	
	@GetMapping("/one")
	public Optional<Team> getTeam(@RequestParam(name = "id")int id) {
		return teamDao.findById(id);
	}
	
//	@DeleteMapping("/delete/{id}")
//	public void deleteTeam(@PathVariable(name = "id")int id) {
//		teamService.deleteTeam(id);
//	}
	@GetMapping("/wc")
	public List<Team> getWildcardTeam(@RequestParam(name = "name")String name) {
		String uppercasename = name.toUpperCase();
		return teamDao.findByWildCard(uppercasename);
	}
	
	@GetMapping("/tn")
	public List<String> getTeamName(@RequestParam(name = "name")String name) {
		String uppercasename = name.toUpperCase();
		List<Team> team = new ArrayList<>();

		List<Object[]> list = teamDao.findByName(uppercasename);
		String teams, city;
		for(Object[] n:list) {
		teams = (String) n[0];
		city = (String) n[1];
		team.add(new Team(teams, city));
		
		}
		List<String> print = new ArrayList<>();
		String str;
		for(Team t:team) {
			str = "Team: "+t.getTeams()+", "+"City: "+t.getCity();
			
			print.add(str);
			
			}
		
		return print;
	}
	
	@DeleteMapping("/delete")
	@ResponseBody
	public void deleteTeam(@RequestParam("id")int id) {
		teamDao.deleteById(id);
	}
}
