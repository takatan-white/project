package jp.ac.asojuku.asojobs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompanyResourceNotFoundException extends Exception{
	public CompanyResourceNotFoundException(){
		super("CompanyInfoNotFound");
	}
}
