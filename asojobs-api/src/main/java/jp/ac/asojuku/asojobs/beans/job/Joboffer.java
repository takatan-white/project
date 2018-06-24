package jp.ac.asojuku.asojobs.beans.job;

public class Joboffer {
	private Integer company_no;
	private Integer joboffer_year;
	
	private Integer joboffer_applying;
	private Integer joboffer_visit;
	private Integer joboffer_domitory;

	private Integer joboffer_home;
	private Integer joboffer_abroad;
	private String  joboffer_prefectures;
	public Joboffer(){}
	public Integer getCompany_no() {
		return company_no;
	}
	public void setCompany_no(Integer company_no) {
		this.company_no = company_no;
	}
	public Integer getJoboffer_year() {
		return joboffer_year;
	}
	public void setJoboffer_year(Integer joboffer_year) {
		this.joboffer_year = joboffer_year;
	}
	public Integer getJoboffer_applying() {
		return joboffer_applying;
	}
	public void setJoboffer_applying(Integer joboffer_applying) {
		this.joboffer_applying = joboffer_applying;
	}
	public Integer getJoboffer_visit() {
		return joboffer_visit;
	}
	public void setJoboffer_visit(Integer joboffer_visit) {
		this.joboffer_visit = joboffer_visit;
	}
	public Integer getJoboffer_domitory() {
		return joboffer_domitory;
	}
	public void setJoboffer_domitory(Integer joboffer_domitory) {
		this.joboffer_domitory = joboffer_domitory;
	}
	public Integer getJoboffer_home() {
		return joboffer_home;
	}
	public void setJoboffer_home(Integer joboffer_home) {
		this.joboffer_home = joboffer_home;
	}
	public Integer getJoboffer_abroad() {
		return joboffer_abroad;
	}
	public void setJoboffer_abroad(Integer joboffer_abroad) {
		this.joboffer_abroad = joboffer_abroad;
	}
	public String getJoboffer_prefectures() {
		return joboffer_prefectures;
	}
	public void setJoboffer_prefectures(String joboffer_prefectures) {
		this.joboffer_prefectures = joboffer_prefectures;
	}
}
