package jp.ac.asojuku.asojobs.entity;

import java.io.Serializable;
import java.sql.Time;

public class WorkingTime implements Serializable {
	
	public static String  WORKING_START    ="working_start";
	public static String  WORKING_END      ="working_end";
	public static String  HORIDAY_ETCETERA ="horiday_etcetera";
	
	private Joboffer joboffer;               //Jobofferのオブジェクト
	private Integer        working_time_no;       //就業時間ID
	private Time           working_time_start;  //就業開始時間
	private Time           working_time_end;   //就業終了時間
	private String         horiday_etcetera; //休日、その他
	
	public Joboffer getJoboffer() {
		return joboffer;
	}
	public void setJoboffer(Joboffer joboffer) {
		this.joboffer = joboffer;
	}
	public Integer getWorking_time_no() {
		return working_time_no;
	}
	public void setWorking_time_no(Integer working_time_no) {
		this.working_time_no = working_time_no;
	}
	public Time getWorking_time_start() {
		return working_time_start;
	}
	public void setWorking_time_start(Time working_time_start) {
		this.working_time_start = working_time_start;
	}
	public Time getWorking_time_end() {
		return working_time_end;
	}
	public void setWorking_time_end(Time working_time_end) {
		this.working_time_end = working_time_end;
	}
	public String getHoriday_etcetera() {
		return horiday_etcetera;
	}
	public void setHoriday_etcetera(String horiday_etcetera) {
		this.horiday_etcetera = horiday_etcetera;
	}
	
	
	
}
