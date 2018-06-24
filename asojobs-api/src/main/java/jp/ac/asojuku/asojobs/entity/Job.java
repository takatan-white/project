package jp.ac.asojuku.asojobs.entity;

import java.io.Serializable;

/*
 * 職種テーブル(エンティティ)
 * 
*/
public class Job implements Serializable{
	
	public static String COMPANY_INDUSTRY_NAME     = "industry_name";//産業名 業種名
	private static final long serialVersionUID = 1L;
	public static String JOb_TABLE_NAME ="job";
	
	public static String JOB_NO   = "job_no";
	public static String JOB_NAME = "job_name";
	
	private Integer job_no;
	private String job_name;
	
	public Integer getJob_no() {
		return job_no;
	}
	public void setJob_no(Integer job_no) {
		this.job_no = job_no;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
}
