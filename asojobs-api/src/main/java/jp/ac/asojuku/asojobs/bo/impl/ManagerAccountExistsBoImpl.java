package jp.ac.asojuku.asojobs.bo.impl;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

import jp.ac.asojuku.asojobs.beans.ManagerAccountExistsRespncse;
import jp.ac.asojuku.asojobs.bo.ManagerAccountExistsBo;
import jp.ac.asojuku.asojobs.dao.ManagerDAO;
import jp.ac.asojuku.asojobs.exception.HashMistakeException;
import jp.ac.asojuku.asojobs.param.DirectoryInfo;
import jp.ac.asojuku.asojobs.util.CSVScanner;
import jp.ac.asojuku.asojobs.util.HMAC;

public class ManagerAccountExistsBoImpl implements ManagerAccountExistsBo {
	@Autowired
	private ManagerDAO managerdao;
	@Autowired
	private TransactionTemplate transactionTemplate;
	@Override
	public ManagerAccountExistsRespncse accountExists(String email, String hash) throws HashMistakeException {
		File file = new File(DirectoryInfo.SecurityInfoFile);
		CSVScanner scannaer = new CSVScanner(file);
		ArrayList<String[]> security = scannaer.read();
		String[]  securityinfo = security.get(0);
		
		if(!HMAC.hmacDigest(securityinfo[0], securityinfo[1], "HmacSHA1").equals(hash)){
				throw new HashMistakeException("値が正しくありません。");
			
		}
		ManagerAccountExistsRespncse manageraccountexistsrespncse = null;
		manageraccountexistsrespncse = managerdao.getMangerMailExists(email);
		return manageraccountexistsrespncse;
	}

}
