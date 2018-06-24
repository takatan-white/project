package jp.ac.asojuku.asojobs.beans;

public class Company {
	
	public Integer companycode;
	public String  companyname;
	//支店名
	private String company_branch;
	
	public Integer getCompanycode() {
		return companycode;
	}
	public void setCompanycode(Integer companycode) {
		this.companycode = companycode;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompany_branch() {
		return company_branch;
	}
	public void setCompany_branch(String company_branch) {
		this.company_branch = company_branch;
	}
}
