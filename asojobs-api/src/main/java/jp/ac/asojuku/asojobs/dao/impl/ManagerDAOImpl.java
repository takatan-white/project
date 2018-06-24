package jp.ac.asojuku.asojobs.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import jp.ac.asojuku.asojobs.beans.ManagerAccountExistsRespncse;
import jp.ac.asojuku.asojobs.beans.ManagerLoginInfo;
import jp.ac.asojuku.asojobs.dao.ManagerDAO;

public class ManagerDAOImpl implements ManagerDAO {

	
	//jdbcTemplate 変数
	private JdbcTemplate jdbcTemplate;
	//JdcTempalte のインスタンスを作成
	public ManagerDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public ManagerLoginInfo getManagerInfoByUser(String user, String pass) {
		// TODO Auto-generated method stub
		String sql = "SELECT manager_name FROM manager WHERE manager_mail = ? AND manager_pass = ? AND" +
					 " managger_flag = 1";
		
		String[] object = new String[] {user,pass};
		List<ManagerLoginInfo> managerlist = new ArrayList<ManagerLoginInfo>();
		List<Map<String,Object>> resultlist = jdbcTemplate.queryForList(sql,user,pass);
		resultlist.stream().forEach(e -> {
			ManagerLoginInfo managerlogininfo = new ManagerLoginInfo();
			managerlogininfo.setManagerName((String)e.get("manager_name"));
			managerlist.add(managerlogininfo);
		});
		if(resultlist.size() == 0){
			return new ManagerLoginInfo();
		}
		return managerlist.get(0);
	}

	@Override
	public ManagerAccountExistsRespncse getMangerMailExists(String email) {
		// TODO Auto-generated method stub
		String sql = "select count(*) FROM manager WHERE manager_mail =?";
		ManagerAccountExistsRespncse manager = new ManagerAccountExistsRespncse();
		int count = jdbcTemplate.queryForObject(sql,new Object[] { email },Integer.class);
		manager.setCode(count);
		return manager;
	}

	@Override
	public Integer entryManagerAccount(String name, String hurigana, String mail, String hashpass) {
		
		String  sql = "insert into manager(manager_pass,manager_name,manager_kana,manager_mail,managger_flag)"+
		" VALUES(?,?,?,?,?);";
		 Integer count = jdbcTemplate.update(sql,hashpass,name,hurigana,mail,2);
		return count;
	}

	@Override
	public ManagerLoginInfo getMangeerGeneralInfoByUserPassword(String user, String pass) {
		
		String sql = "SELECT manager_name FROM manager WHERE manager_mail = ? AND manager_pass = ? AND" +
					 " managger_flag = 2";
		
		String[] object = new String[] {user,pass};
		List<ManagerLoginInfo> managerlist = new ArrayList<ManagerLoginInfo>();
		List<Map<String,Object>> resultlist = jdbcTemplate.queryForList(sql,user,pass);
		resultlist.stream().forEach(e -> {
			ManagerLoginInfo managerlogininfo = new ManagerLoginInfo();
			managerlogininfo.setManagerName((String)e.get("manager_name"));
			managerlist.add(managerlogininfo);
		});
		if(resultlist.size() == 0){
			return new ManagerLoginInfo();
		}
		return managerlist.get(0);
	}

}
