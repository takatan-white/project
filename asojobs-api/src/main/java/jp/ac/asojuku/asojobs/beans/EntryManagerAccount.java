package jp.ac.asojuku.asojobs.beans;


/**
 * 
 * @author takamichi
 *  管理アカウント beans
 *
 */
public class EntryManagerAccount {
	
	//管理者のパスワード
	private String  managerpass;
	
	//管理者の名前
	private String managername;
	
	//管理者のフリガナ
	private String managerkana;
	
	//管理者のメールアドレス
	private String managermail;
	private String  securitykey;

	public String getSecuritykey() {
		return securitykey;
	}
	public void setSecuritykey(String securitykey) {
		this.securitykey = securitykey;
	}
	public String getManagerpass() {
		return managerpass;
	}
	public void setManagerpass(String managerpass) {
		this.managerpass = managerpass;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerkana() {
		return managerkana;
	}
	public void setManagerkana(String managerkana) {
		this.managerkana = managerkana;
	}
	public String getManagermail() {
		return managermail;
	}
	public void setManagermail(String managermail) {
		this.managermail = managermail;
	}
}
