package jp.ac.asojuku.asojobs.bo;

import jp.ac.asojuku.asojobs.beans.ManagerAccountExistsRespncse;
import jp.ac.asojuku.asojobs.exception.HashMistakeException;

public interface ManagerAccountExistsBo {
	public ManagerAccountExistsRespncse accountExists(String email,String hash)throws HashMistakeException;
}
