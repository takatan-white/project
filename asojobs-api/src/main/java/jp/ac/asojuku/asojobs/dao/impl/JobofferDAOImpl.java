package jp.ac.asojuku.asojobs.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import jp.ac.asojuku.asojobs.beans.job.Job;
import jp.ac.asojuku.asojobs.beans.job.Joboffer;
import jp.ac.asojuku.asojobs.beans.job.JobofferDuration;
import jp.ac.asojuku.asojobs.beans.job.JobofferPersons;
import jp.ac.asojuku.asojobs.beans.job.Salary;
import jp.ac.asojuku.asojobs.beans.job.WorkingTime;
import jp.ac.asojuku.asojobs.dao.JobofferDAO;
import jp.ac.asojuku.asojobs.util.TypeFormatter;

public class JobofferDAOImpl implements JobofferDAO{
	

	//jdbcTemplate 変数
	private JdbcTemplate jdbcTemplate;
	//JdcTempalte のインスタンスを作成
	public JobofferDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//INSERT 変数
	private final String SQL_INSERT = "INSERT INTO ";
	private final String SQL_VALUES = "VALUES(";
	private final String SQL_TOGI_TAG = ")";
	
	@Override
	public int insertJoboffer(Joboffer joboffer){
		String sql = SQL_INSERT + "joboffer(" + 
					"company_no,joboffer_year,joboffer_state,joboffer_applying," +
					"joboffer_visit,joboffer_domitory,joboffer_home,joboffer_abroad," +
					"joboffer_ent,joboffer_prefectures) " +
					SQL_VALUES +"?,?,?,?,?,?,?,?,?,?" +
					SQL_TOGI_TAG;
		int result = 0;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String day =sdf.format(cal.getTime());
		java.sql.Date joboffer_ent = null;
		try {
			joboffer_ent = TypeFormatter.convertStringToDate(day);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = jdbcTemplate.update(sql,joboffer.getCompany_no(),joboffer.getJoboffer_year(),1,joboffer.getJoboffer_applying(),
								joboffer.getJoboffer_visit(),joboffer.getJoboffer_domitory(),joboffer.getJoboffer_home(),
								joboffer.getJoboffer_abroad(),joboffer_ent,joboffer.getJoboffer_prefectures());
		return result;
	}
	@Override
	public int insertJoboffer_persons(List<Job> joblist, List<JobofferPersons> jobofferpersonslist,Integer jobofferno){
		String sql = SQL_INSERT + "joboffer_persons(joboffer_no,job_no,joboffer_unisex,joboffer_man,joboffer_woman) " + 
					 SQL_VALUES + "?,?,?,?,?" + SQL_TOGI_TAG;
		
					
		int result = 0;
		int i = 0;
		for(JobofferPersons jobofferpersons: jobofferpersonslist){
			Job job = joblist.get(i);
			Integer job_no = Integer.parseInt(job.getJob_name());
			System.out.println(job_no);
			result += jdbcTemplate.update(sql,jobofferno,job_no,jobofferpersons.getJoboffer_unisex(),
					jobofferpersons.getJoboffer_man(),jobofferpersons.getJoboffer_woman());
			i++;
		}
		
		return result;
	}
	@Override
	public int insertJoboffer_duration(JobofferDuration jobofferduration,Integer jobofferno) throws Exception{
		String sql = SQL_INSERT + "joboffer_duration" +"(joboffer_no, joboffer_start,joboffer_end, joboffer_visit ," +
					 "joboffer_des_school, joboffer_des_day, joboffer_des_day_oh, joboffer_des_loc, com_explan_day,com_explan_place" +
					 "com_explan_day_oh, submit_document, submit_document_etc, selection_method, selection_method_etc," +
					 "baggage, baggage_etc, joboffer_decide_day, joboffer_decide_during, receptionist_method,"+
					 "receptionistm_ethod_navig, start_work_day, select_day,select_place)"
					 + SQL_VALUES + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" + SQL_TOGI_TAG;
		int result = 0;
		
		java.sql.Date joboffer_end = null;
		java.sql.Date joboffer_des_day = null;
		java.sql.Date joboffer_start = null;
		joboffer_des_day= TypeFormatter.convertStringToDate(jobofferduration.getJoboffer_des_day());
		joboffer_start = TypeFormatter.convertStringToDate(jobofferduration.getJoboffer_start());
		joboffer_end   = TypeFormatter.convertStringToDate(jobofferduration.getJoboffer_end());
		java.sql.Date com_explan_day = TypeFormatter.convertStringToDate(jobofferduration.getCom_explan_day());
		java.sql.Date joboffer_decide_day = null;
		joboffer_decide_day =TypeFormatter.convertStringToDate(jobofferduration.getJoboffer_decide_day());
		java.sql.Date start_work_day = null;
		java.sql.Date select_day = null;
		start_work_day = TypeFormatter.convertStringToDate(jobofferduration.getStart_work_day());
		select_day = TypeFormatter.convertStringToDate(jobofferduration.getSelect_day());
		
		result = jdbcTemplate.update(sql,jobofferno,joboffer_start,joboffer_end
				,jobofferduration.getJoboffer_visit(),jobofferduration.getJoboffer_des_school(),
				joboffer_des_day,jobofferduration.getJoboffer_des_day_oh(),
				jobofferduration.getJoboffer_des_loc(),com_explan_day,jobofferduration.getCom_explan_place(),
				jobofferduration.getCom_explan_place(),jobofferduration.getCom_explan_day_oh(),
				jobofferduration.getSubmit_document(),jobofferduration.getSubmit_document_etc(),
				jobofferduration.getSelection_method(),jobofferduration.getSelection_method_etc(),
				jobofferduration.getBaggage(),jobofferduration.getBaggage_etc(),joboffer_decide_day,jobofferduration.getJoboffer_decide_during(),
				jobofferduration.getReceptionist_method(),jobofferduration.getReceptionist_method(),
				jobofferduration.getReceptionistm_ethod_navigation(),start_work_day,select_day,
				jobofferduration.getSelect_place());
		
		return result;
	}
	@Override
	public int[] insertWorking_time(Integer jobofferno,List<WorkingTime> workingtimelist){
		String sql = SQL_INSERT + "working_time" + "(joboffer_no,working_start,working_end,horiday_etcetera )"
					+SQL_VALUES +"?,?,?,?" + SQL_TOGI_TAG;
		int[] result;
		
		result = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			 @Override
			 public void setValues(PreparedStatement ps, int i) throws SQLException{
				 WorkingTime workingtime = workingtimelist.get(i);
				 java.sql.Time starttime = null;
				 java.sql.Time endtime = null;
				try {
					starttime = TypeFormatter.convertStringToTime(workingtime.getWorking_start());
					endtime   = TypeFormatter.convertStringToTime(workingtime.getWorking_end());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 
				 ps.setInt(1, jobofferno);
				 ps.setTime(2, starttime);
				 ps.setTime(3, endtime);
				 ps.setString(4, workingtime.getHoriday_etcetera());
				 
			 }
			 @Override
			 public int getBatchSize() {
				 return workingtimelist.size();
			}
		 });
		return result;
	}
	@Override
	public int insertSalary(Integer jobofferno,Salary salary){
		String sql = SQL_INSERT + "salary" + "(joboffer_no,one_salary,two_salary,three_salary,four_salary," +
								"bonus_freq,bonus_month,pay_raise,minimum,maximum,pay_raise_index,"
								+ "trans_exp_salary) " + SQL_VALUES +
								"?,?,?,?,?,?,?,?,?,?,?,?" +  SQL_TOGI_TAG;
		int result = 0;
		
		result = jdbcTemplate.update(sql,jobofferno,salary.getOne_salary(),salary.getTwo_salary(),
									salary.getThree_salary(),salary.getFour_salary(),salary.getBonus_freq(),
									salary.getBonus_month(),salary.getPay_raise(),salary.getMinimum(),salary.getMaximum(),
									salary.getPay_raise_index(),salary.getTrans_exp_salary());
		return result;
	}
	@Override
	public Integer selectJoboffer(){
		Integer count = jdbcTemplate.queryForObject("select joboffer_no from joboffer ORDER BY joboffer_no desc limit 1", Integer.class);
		return count;
	}

	
}
