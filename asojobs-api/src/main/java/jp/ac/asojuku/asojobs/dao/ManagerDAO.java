package jp.ac.asojuku.asojobs.dao;

import jp.ac.asojuku.asojobs.beans.ManagerAccountExistsRespncse;
import jp.ac.asojuku.asojobs.beans.ManagerLoginInfo;

public interface ManagerDAO {
	public ManagerLoginInfo getManagerInfoByUser(String user,String pass);
	public ManagerLoginInfo getMangeerGeneralInfoByUserPassword(String user,String pass);
	public ManagerAccountExistsRespncse getMangerMailExists(String email);
	public Integer entryManagerAccount(String name,String hurigana,String mail,String hashpass);
}
