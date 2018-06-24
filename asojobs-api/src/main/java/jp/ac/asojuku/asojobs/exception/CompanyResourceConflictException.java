package jp.ac.asojuku.asojobs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CompanyResourceConflictException extends RuntimeException{
	public CompanyResourceConflictException(){
		super("ConflictException");
	}
}
