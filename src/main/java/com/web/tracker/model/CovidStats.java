package com.web.tracker.model;

public class CovidStats {
	
	private int id;
	
	private String country;
	private int totalCases;
	private int newCases7days;
	private int newCases;
	private int totalDeaths;
	private int newDeaths7Days;
	private int newDeaths;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getTotalCases() {
		return totalCases;
	}
	public void setTotalCases(int totalCases) {
		this.totalCases = totalCases;
	}
	public int getNewCases7days() {
		return newCases7days;
	}
	public void setNewCases7days(int newCases7days) {
		this.newCases7days = newCases7days;
	}
	public int getNewCases() {
		return newCases;
	}
	public void setNewCases(int newCases) {
		this.newCases = newCases;
	}
	public int getTotalDeaths() {
		return totalDeaths;
	}
	public void setTotalDeaths(int totalDeaths) {
		this.totalDeaths = totalDeaths;
	}
	public int getNewDeaths7Days() {
		return newDeaths7Days;
	}
	public void setNewDeaths7Days(int newDeaths7Days) {
		this.newDeaths7Days = newDeaths7Days;
	}
	public int getNewDeaths() {
		return newDeaths;
	}
	public void setNewDeaths(int newDeaths) {
		this.newDeaths = newDeaths;
	}
	
	@Override
	public String toString() {
		return "CovidStats [country=" + country + ", totalCases=" + totalCases + ", newCases7days=" + newCases7days
				+ ", newCases=" + newCases + ", totalDeaths=" + totalDeaths + ", newDeaths7Days=" + newDeaths7Days
				+ ", newDeaths=" + newDeaths + "]";
	}
}
