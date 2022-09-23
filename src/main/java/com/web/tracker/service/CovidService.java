package com.web.tracker.service;

import java.io.IOException;
import java.util.List;

import com.web.tracker.model.CovidStats;

public interface CovidService {
	
	void fetchCovidData() throws IOException, InterruptedException;
	
	List<CovidStats> getAllStats();
	
}
