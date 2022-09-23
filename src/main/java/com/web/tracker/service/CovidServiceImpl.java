package com.web.tracker.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.web.tracker.model.CovidStats;

@Service
public class CovidServiceImpl implements CovidService{
	
	private String covidDataUrl = "https://covid19.who.int/WHO-COVID-19-global-table-data.csv";
	
	private List<CovidStats> allStats;	//Each country statistics
	
	private int countId = 0;
	
	@PostConstruct
	@Scheduled(cron = "0 0 18 * * *") // Update Schedule 6:00 PM every day
	public void fetchCovidData() throws IOException, InterruptedException {
		
		List<CovidStats> newStats = new ArrayList<>(); //Each country new statistics
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
										.uri(URI.create(covidDataUrl))
										.build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		StringReader csvBodyReader = new StringReader(response.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		for (CSVRecord record : records) {
			CovidStats covidStats = new CovidStats(); //Each country statistics
			
			// Skips Second Row
			if (countId > 0) {

			    covidStats.setCountry(record.get("﻿Name"));
			    covidStats.setTotalCases(Integer.parseInt(record.get("Cases - cumulative total")));
			    covidStats.setNewCases7days(Integer.parseInt(record.get("Cases - newly reported in last 7 days")));
			    covidStats.setNewCases(Integer.parseInt(record.get("Cases - newly reported in last 24 hours")));
			    covidStats.setTotalDeaths(Integer.parseInt(record.get("Deaths - cumulative total")));
			    covidStats.setNewDeaths7Days(Integer.parseInt(record.get("Deaths - newly reported in last 7 days")));
			    covidStats.setNewDeaths(Integer.parseInt(record.get("Deaths - newly reported in last 24 hours")));
			    
			    covidStats.setId(countId);
			    
			    countId++;
			    
			    newStats.add(covidStats);
				
			} else {
				countId++;
			}
		}
		
		this.allStats = newStats;
	}
	
	public List<CovidStats> getAllStats() {
		return allStats;
	}

}
