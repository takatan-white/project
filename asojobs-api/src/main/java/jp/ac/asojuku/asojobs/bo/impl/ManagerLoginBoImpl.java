package jp.ac.asojuku.asojobs.bo.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

import jp.ac.asojuku.asojobs.beans.ManagerLoginInfo;
import jp.ac.asojuku.asojobs.bo.ManagerLoginBo;
import jp.ac.asojuku.asojobs.config.SettingProperties;
import jp.ac.asojuku.asojobs.dao.ManagerDAO;
import jp.ac.asojuku.asojobs.exception.HashMistakeException;
import jp.ac.asojuku.asojobs.param.DirectoryInfo;
import jp.ac.asojuku.asojobs.util.HMAC;

import jp.ac.asojuku.asojobs.util.CSVScanner;

public class ManagerLoginBoImpl implements ManagerLoginBo{
	@Autowired
	private ManagerDAO managerdao;
	@Autowired
	private TransactionTemplate transactionTemplate;
	@Override
	public ManagerLoginInfo loginAdmin(String loginmail, String password,String hash) throws HashMistakeException {
		File file = new File(DirectoryInfo.SecurityInfoFile);
		CSVScanner scannaer = new CSVScanner(file);
		ArrayList<String[]> security = scannaer.read();
		String[]  securityinfo = security.get(0);
		
		if(!HMAC.hmacDigest(securityinfo[0], securityinfo[1], "HmacSHA1").equals(hash)){
			throw new HashMistakeException("値が正しくありません。");
		}
		ManagerLoginInfo managerlogininfo = null;
		managerlogininfo = managerdao.getManagerInfoByUser(loginmail, password);
		
		return managerlogininfo;
	}
	@Override
	public ManagerLoginInfo login(String loginmail, String password, String hash) throws HashMistakeException {
		// TODO Auto-generated method stub
		File file = new File(DirectoryInfo.SecurityInfoFile);
		CSVScanner scannaer = new CSVScanner(file);
		ArrayList<String[]> security = scannaer.read();
		String[]  securityinfo = security.get(0);
		
		if(!HMAC.hmacDigest(securityinfo[0], securityinfo[1], "HmacSHA1").equals(hash)){
			throw new HashMistakeException("値が正しくありません。");
		}
		SettingProperties prop = SettingProperties.getInstance();
		Map<Object,Object> map = null;
		try {
			map = prop.getInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hashpass = HMAC.hmacDigest(password, map.get("keyString").toString(),map.get("algo").toString());
		ManagerLoginInfo managerlogininfo = null;
		managerlogininfo = managerdao.getMangeerGeneralInfoByUserPassword(loginmail, hashpass);
		return managerlogininfo;
	}

}
