package jp.ac.asojuku.asojobs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.ac.asojuku.asojobs.beans.JobofferRegistrationInfo;
import jp.ac.asojuku.asojobs.bo.JobofferBo;
import jp.ac.asojuku.asojobs.exception.NullParameterException;

@RestController
@RequestMapping("joboffer")
public class JobOfferRestController {
	
	@Autowired
	private JobofferBo jobofferBo;
	
	@RequestMapping(path = "entryjoboffer", method = RequestMethod.POST)
	public void EntryJobOffer(@Validated @RequestBody JobofferRegistrationInfo jobofferregistrationinfo) throws NullParameterException{
		
		if(jobofferregistrationinfo == null){
			throw new NullParameterException("ビジネスロジックでエラー");
		}
		jobofferBo.entryJoboffer(jobofferregistrationinfo);
		System.out.println(jobofferregistrationinfo);
		
	}
	
}
