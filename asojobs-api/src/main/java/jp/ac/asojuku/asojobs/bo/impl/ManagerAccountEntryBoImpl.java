package jp.ac.asojuku.asojobs.bo.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import jp.ac.asojuku.asojobs.beans.EntryManagerAccount;
import jp.ac.asojuku.asojobs.bo.ManagerAccountEntryBo;
import jp.ac.asojuku.asojobs.config.SettingProperties;
import jp.ac.asojuku.asojobs.dao.ManagerDAO;
import jp.ac.asojuku.asojobs.exception.HashMistakeException;
import jp.ac.asojuku.asojobs.param.DirectoryInfo;
import jp.ac.asojuku.asojobs.util.CSVScanner;
import jp.ac.asojuku.asojobs.util.HMAC;


public class ManagerAccountEntryBoImpl implements ManagerAccountEntryBo{
	@Autowired
	private ManagerDAO managerdao;
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Override
	public int entryAccountEntry(EntryManagerAccount entrymangeraccount) throws HashMistakeException {
		SettingProperties prop = SettingProperties.getInstance();
		Map<Object,Object> map = null;
		try {
			map = prop.getInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File file = new File(DirectoryInfo.SecurityInfoFile);
		CSVScanner scannaer = new CSVScanner(file);
		ArrayList<String[]> security = scannaer.read();
		String[]  securityinfo = security.get(0);
		
		if(!HMAC.hmacDigest(securityinfo[0], securityinfo[1], "HmacSHA1").equals(entrymangeraccount.getSecuritykey())){
				throw new HashMistakeException("値が正しくありません。");
			
		}
		String hashpass = HMAC.hmacDigest(entrymangeraccount.getManagerpass(), map.get("keyString").toString(),map.get("algo").toString());
		Integer obj = transactionTemplate.execute(new TransactionCallback<Integer>() {

			@Override
			public Integer doInTransaction(TransactionStatus status) {
				Integer count = managerdao.entryManagerAccount(entrymangeraccount.getManagername(), entrymangeraccount.getManagerkana(), entrymangeraccount.getManagermail(), hashpass);
				return count;
			}
		});
		return obj;
	}
}
