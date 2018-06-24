package jp.ac.asojuku.asojobs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class NullParameterException extends Exception{
	public NullParameterException(String errmsg){
		super(errmsg);
	}
}
