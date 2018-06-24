package jp.ac.asojuku.asojobs.beans;

import jp.ac.asojuku.asojobs.beans.job.Job;
import jp.ac.asojuku.asojobs.beans.job.Joboffer;
import jp.ac.asojuku.asojobs.beans.job.JobofferDuration;
import jp.ac.asojuku.asojobs.beans.job.JobofferPersons;
import jp.ac.asojuku.asojobs.beans.job.Salary;
import jp.ac.asojuku.asojobs.beans.job.WorkingTime;

public class JobofferRegistrationInfo {
	
	private Joboffer joboffer;
	private Job[] job;
	
	private JobofferPersons[] jobofferpersons; 
	private JobofferDuration jobofferduration;
	private WorkingTime[] workingtime;
	private Salary salary;
	
	public JobofferRegistrationInfo(){}
	
	
	
	public Joboffer getJoboffer() {
		return joboffer;
	}
	public void setJoboffer(Joboffer joboffer) {
		this.joboffer = joboffer;
	}
	public Job[] getJob() {
		return job;
	}
	public void setJob(Job[] job) {
		this.job = job;
	}
	public JobofferPersons[] getJobofferpersons() {
		return jobofferpersons;
	}
	public void setJobofferpersons(JobofferPersons[] jobofferpersons) {
		this.jobofferpersons = jobofferpersons;
	}
	public JobofferDuration getJobofferduration() {
		return jobofferduration;
	}
	public void setJobofferduration(JobofferDuration jobofferduration) {
		this.jobofferduration = jobofferduration;
	}
	public WorkingTime[] getWorkingtime() {
		return workingtime;
	}
	public void setWorkingtime(WorkingTime[] workingtime) {
		this.workingtime = workingtime;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	
}
