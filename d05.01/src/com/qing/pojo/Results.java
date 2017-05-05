package com.qing.pojo;

import java.util.List;

public class Results {
	private List<LocationNow> results;


	public List<LocationNow> getResult() {
		return results;
	}

	public void setResult(List<LocationNow> result) {
		this.results = result;
	}

	@Override
	public String toString() {
		return "Results [results=" + results + "]";
	}
	
	
}
