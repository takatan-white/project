package jp.ac.asojuku.asojobs.beans;

public class ManagerAccountExistsParameter {
	private String mail;
	private String hash;
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
}
