package jp.ac.asojuku.asojobs.entity;

import java.io.Serializable;
import java.util.Date;


/*
 * 求人テーブル(Entity)
 * 
 * */
public class Joboffer implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	//求人票コード
	public static String JOBOFFER_NO = "joboffer_no";
	//募集年度
	public static String JOBOFFER_YEAR="joboffer_year";
	
	//求人状況 0:募集済　1:募集中
	public static String JOBOFFER_STATE="joboffer_state";
	//併願 0併願負荷　１併願可
	public static String JOBOFFER_APPLYING="joboffer_applying";
	//会社訪問　０なし、１あり
	public static String JOBOFFER_VISIT="joboffer_visit";
	//寮　０なし、１あり
	public static String JOBOFFER_DOMITORY="joboffer_domitory";
	//車通勤 0不可能　１可能
	public static String JOBOFFER_CAR="joboffer_car";
	//自宅外 0不可能　１可能
	public static String JOBOFFER_HOME="joboffer_home";
	//留学生 0不可能　１可能
	public static String JOBOFFER_ABROAD="joboffer_abroad";
	//受付日
	public static String JOBOFFEr_ENT ="joboffer_ent";
	
	//AUTO INCREMENT
	private Integer joboffer_no;
	private Company company;
	private Integer joboffer_year;
	private Integer joboffer_state;
	private Integer joboffer_applying;
	private Integer joboffer_visit;
	private Integer joboffer_domitory;
	
	private Integer joboffer_car;
	private Integer joboffer_home;
	private Integer joboffer_abroad;
	private Date    joboffer_ent;
	public Integer getJoboffer_no() {
		return joboffer_no;
	}
	public void setJoboffer_no(Integer joboffer_no) {
		this.joboffer_no = joboffer_no;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Integer getJoboffer_year() {
		return joboffer_year;
	}
	public void setJoboffer_year(Integer joboffer_year) {
		this.joboffer_year = joboffer_year;
	}
	public Integer getJoboffer_state() {
		return joboffer_state;
	}
	public void setJoboffer_state(Integer joboffer_state) {
		this.joboffer_state = joboffer_state;
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
	public Integer getJoboffer_car() {
		return joboffer_car;
	}
	public void setJoboffer_car(Integer joboffer_car) {
		this.joboffer_car = joboffer_car;
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
	public Date getJoboffer_ent() {
		return joboffer_ent;
	}
	public void setJoboffer_ent(Date joboffer_ent) {
		this.joboffer_ent = joboffer_ent;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
