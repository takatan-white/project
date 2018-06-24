package jp.ac.asojuku.asojobs.dao;

import java.util.List;

import jp.ac.asojuku.asojobs.beans.job.Job;
import jp.ac.asojuku.asojobs.beans.job.Joboffer;
import jp.ac.asojuku.asojobs.beans.job.JobofferDuration;
import jp.ac.asojuku.asojobs.beans.job.JobofferPersons;
import jp.ac.asojuku.asojobs.beans.job.Salary;
import jp.ac.asojuku.asojobs.beans.job.WorkingTime;

public interface JobofferDAO {
	
	public int insertJoboffer(Joboffer joboffer);
	public int insertJoboffer_persons(List<Job> joblist, List<JobofferPersons> jobofferpersonslist,Integer jobofferno);
	public int insertJoboffer_duration(JobofferDuration jobofferduration,Integer jobofferno) throws Exception;
	public int[] insertWorking_time(Integer jobofferno,List<WorkingTime> workingtimelist);
	public int insertSalary(Integer jobofferno,Salary salary);
	public Integer selectJoboffer();
}
