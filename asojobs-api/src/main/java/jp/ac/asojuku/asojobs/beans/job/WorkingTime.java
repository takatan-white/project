package jp.ac.asojuku.asojobs.beans.job;

public class WorkingTime {
	public WorkingTime(){}
	private String working_start;
	private String working_end;
	private String horiday_etcetera;
	public String getWorking_start() {
		return working_start;
	}
	public void setWorking_start(String working_start) {
		this.working_start = working_start;
	}
	public String getWorking_end() {
		return working_end;
	}
	public void setWorking_end(String working_end) {
		this.working_end = working_end;
	}
	public String getHoriday_etcetera() {
		return horiday_etcetera;
	}
	public void setHoriday_etcetera(String horiday_etcetera) {
		this.horiday_etcetera = horiday_etcetera;
	}
}
