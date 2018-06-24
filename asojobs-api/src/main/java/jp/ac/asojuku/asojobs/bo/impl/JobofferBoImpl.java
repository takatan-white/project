package jp.ac.asojuku.asojobs.bo.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import jp.ac.asojuku.asojobs.beans.JobofferRegistrationInfo;
import jp.ac.asojuku.asojobs.beans.job.Job;
import jp.ac.asojuku.asojobs.beans.job.Joboffer;
import jp.ac.asojuku.asojobs.beans.job.JobofferDuration;
import jp.ac.asojuku.asojobs.beans.job.JobofferPersons;
import jp.ac.asojuku.asojobs.beans.job.Salary;
import jp.ac.asojuku.asojobs.beans.job.WorkingTime;
import jp.ac.asojuku.asojobs.bo.JobofferBo;
import jp.ac.asojuku.asojobs.dao.CompanyDAO;
import jp.ac.asojuku.asojobs.dao.JobofferDAO;

public class JobofferBoImpl implements JobofferBo{
	@Autowired
	private JobofferDAO jobofferdao;
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Override
	public Object entryJoboffer(JobofferRegistrationInfo beans) {
		// TODO Auto-generated method stub
		
		
		List<Job> joblist = Arrays.asList(beans.getJob());
		List<JobofferPersons> jobofferpersons = Arrays.asList( beans.getJobofferpersons());
		List<WorkingTime> workingtimelist = Arrays.asList(beans.getWorkingtime());
		Joboffer joboffer = beans.getJoboffer();
		JobofferDuration jobofferduration =beans.getJobofferduration();
		Salary salary = beans.getSalary();
		
		Object obj = entryJoboffer_joboffer(joboffer);
		Integer jobofferNo = getJoboffer();
		Object obj2 =entryJobofferJobofferPersons(joblist,jobofferpersons,jobofferNo);
		//insertJoboffer_persons
		//insertWorking_time
		Object obj3 = entryJobofferWorkingTime(jobofferNo,workingtimelist);
		Object obj4 = entryJobofferSalary(jobofferNo,salary);
		//insertSalary
		return null;
	}
	private Object entryJobofferSalary(Integer jobofferNo,Salary salary){
		return transactionTemplate.execute(new TransactionCallback<Object>() {

			@Override
			public Object doInTransaction(TransactionStatus status) {
				int result = jobofferdao.insertSalary(jobofferNo,salary);
				return  status;
			}
		});
	}
	private Object entryJobofferWorkingTime(Integer jobofferNo,List<WorkingTime> workingtimelist){
		return transactionTemplate.execute(new TransactionCallback<Object>() {

			@Override
			public Object doInTransaction(TransactionStatus status) {
				int[] result = jobofferdao.insertWorking_time(jobofferNo,workingtimelist);
				return  status;
			}
		});
	}
	private Object entryJobofferJobofferPersons(List<Job> joblist,List<JobofferPersons> jobofferpersons,Integer jobofferNo){
		return transactionTemplate.execute(new TransactionCallback<Object>() {

			@Override
			public Object doInTransaction(TransactionStatus status) {
				jobofferdao.insertJoboffer_persons(joblist,jobofferpersons,jobofferNo);
				return  status;
			}
		});
	}
	private Object entryJoboffer_joboffer(Joboffer joboffer){
		
		return transactionTemplate.execute(new TransactionCallback<Object>() {

			@Override
			public Object doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
				int result = jobofferdao.insertJoboffer(joboffer);
				
				return status;
			}
			
		});
	}
	public Integer getJoboffer(){ 
		Integer co = jobofferdao.selectJoboffer();
		return co;
	}
}
