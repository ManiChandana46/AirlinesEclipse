package com.lti.dto;

import java.util.List;

public class TotalResult {

	private List<SearchResult> searchResults;
	private List<ReturnResult> returnResults;
	private String statusMessage;

	public List<SearchResult> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<SearchResult> searchResults) {
		this.searchResults = searchResults;
	}

	public List<ReturnResult> getReturnResults() {
		return returnResults;
	}

	public void setReturnResults(List<ReturnResult> returnResults) {
		this.returnResults = returnResults;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
