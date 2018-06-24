package jp.ac.asojuku.asojobs.beans;

import java.io.Serializable;

public class Name implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String response;
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	private String name;
	private Company[] company;

	public Company[] getCompany() {
		return company;
	}

	public void setCompany(Company[] company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}