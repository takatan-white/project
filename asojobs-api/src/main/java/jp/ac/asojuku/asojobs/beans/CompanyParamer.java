package jp.ac.asojuku.asojobs.beans;

import java.io.Serializable;

public class CompanyParamer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer companyId;
	private String  companyName;
	private String[] companyCo;
	
	public String[] getCompanyCo() {
		return companyCo;
	}
	public void setCompanyCo(String[] companyCo) {
		this.companyCo = companyCo;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
