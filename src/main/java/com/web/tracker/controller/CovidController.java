package com.web.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.web.tracker.model.CovidStats;
import com.web.tracker.service.CovidService;

@Controller
public class CovidController {
	
	@Autowired
	private CovidService covidService;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<CovidStats> allStats = covidService.getAllStats();
		
		int globalTotalCases = allStats.stream()
									.mapToInt(stats -> stats.getTotalCases())
									.sum();
		
		int globalNewCases = allStats.stream()
									.mapToInt(stats -> stats.getNewCases())
									.sum();
		
		int globalNewDeaths = allStats.stream()
									.mapToInt(stats -> stats.getNewDeaths())
									.sum();
		
		model.addAttribute("CovidStats", allStats);
		model.addAttribute("globalTotalCases", globalTotalCases);
		model.addAttribute("globalNewCases", globalNewCases);
		model.addAttribute("globalNewDeaths", globalNewDeaths);
		
		return "home";
	}

}
