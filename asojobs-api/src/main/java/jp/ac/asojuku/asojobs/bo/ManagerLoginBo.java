package jp.ac.asojuku.asojobs.bo;

import jp.ac.asojuku.asojobs.beans.ManagerLoginInfo;
import jp.ac.asojuku.asojobs.exception.HashMistakeException;

public interface ManagerLoginBo {
	
	public ManagerLoginInfo loginAdmin(String loginmail,String password,String hash)throws HashMistakeException;
	public ManagerLoginInfo login(String loginmail,String password,String hash)throws HashMistakeException;
	
}
