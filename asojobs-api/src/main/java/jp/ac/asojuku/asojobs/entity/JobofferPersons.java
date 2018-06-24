package jp.ac.asojuku.asojobs.entity;

import java.io.Serializable;
/*
 * 求人職種人数テーブル
 * 
*/
public class JobofferPersons implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public static String JOBOFFERPERSONS_TABLE_NAME ="working_persons";
	
	
	//共用求人人数
	public static String JOBOFFER_UNISEX ="joboffer_unisex";
	//男性求人人数
	public static String JOBOFFER_MAN ="joboffer_man";
	//女性求人人数
	public static String JOBOFFER_WOMAN ="joboffer_woman";
	
	private Joboffer   joboffer;
	private Job job;
	private Integer   joboffer_unisex;
	private Integer   oboffer_man;
	private Integer   joboffer_woman;
	
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Integer getJoboffer_unisex() {
		return joboffer_unisex;
	}
	public void setJoboffer_unisex(Integer joboffer_unisex) {
		this.joboffer_unisex = joboffer_unisex;
	}
	public Integer getOboffer_man() {
		return oboffer_man;
	}
	public void setOboffer_man(Integer oboffer_man) {
		this.oboffer_man = oboffer_man;
	}
	public Integer getJoboffer_woman() {
		return joboffer_woman;
	}
	public void setJoboffer_woman(Integer joboffer_woman) {
		this.joboffer_woman = joboffer_woman;
	}
	public Joboffer getJoboffer() {
		return joboffer;
	}
	public void setJoboffer(Joboffer joboffer) {
		this.joboffer = joboffer;
	}
}
