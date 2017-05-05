package com.qing.pojo;

import java.util.List;

public class ResultsNext {
	private List<LocationNext> results;


	public List<LocationNext> getResult() {
		return results;
	}

	public void setResult(List<LocationNext> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Results [results=" + results + "]";
	}
	
	
}
