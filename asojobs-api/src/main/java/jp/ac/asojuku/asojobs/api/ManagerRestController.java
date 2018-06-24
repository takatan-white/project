package jp.ac.asojuku.asojobs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.ac.asojuku.asojobs.beans.EntryManagerAccount;
import jp.ac.asojuku.asojobs.beans.ManagerAccountExistsParameter;
import jp.ac.asojuku.asojobs.beans.ManagerAccountExistsRespncse;
import jp.ac.asojuku.asojobs.beans.ManagerLoginInfo;
import jp.ac.asojuku.asojobs.beans.ManagerLoginParameter;
import jp.ac.asojuku.asojobs.bo.ManagerAccountEntryBo;
import jp.ac.asojuku.asojobs.bo.ManagerAccountExistsBo;
import jp.ac.asojuku.asojobs.bo.ManagerLoginBo;
import jp.ac.asojuku.asojobs.exception.HashMistakeException;
import jp.ac.asojuku.asojobs.exception.SystemErrorException;
import jp.ac.asojuku.asojobs.exception.UnauthorizedException;

@RestController
@RequestMapping("manager")
public class ManagerRestController {
	
	
	@Autowired
	private ManagerLoginBo managerloginbo;
	@Autowired
	private ManagerAccountExistsBo manageraccountexistsbo;
	@Autowired
	private ManagerAccountEntryBo manageraccountentrybo;
	
	@RequestMapping(path = "entryManagerAccount", method = RequestMethod.POST)
	public void entryMnagerAccount(@Validated @RequestBody EntryManagerAccount entrymanageraccount) throws SystemErrorException{
		int code = 0;
		try {
			code = manageraccountentrybo.entryAccountEntry(entrymanageraccount);
		} catch (HashMistakeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				throw new UnauthorizedException("アクセスが許可できません。");
			} catch (UnauthorizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(code == 0){
			throw new SystemErrorException("システムエラー");
		}
		
	}
	@RequestMapping(path = "existsManagerAccount", method = RequestMethod.POST)
	public ManagerAccountExistsRespncse existsManagerAccount(@Validated @RequestBody ManagerAccountExistsParameter manageraccountexistsparameter){
		ManagerAccountExistsRespncse manageraccountexistsresponse= null;
		try {
			manageraccountexistsresponse = manageraccountexistsbo.accountExists(manageraccountexistsparameter.getMail(), manageraccountexistsparameter.getHash());
		} catch (HashMistakeException e) {
			try {
				throw new UnauthorizedException("アクセスが許可できません。");
			} catch (UnauthorizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return manageraccountexistsresponse;
	}
	@RequestMapping(path = "loginManagerAccount", method = RequestMethod.POST)
	public ManagerLoginInfo loginMangerAdmin(@Validated @RequestBody ManagerLoginParameter managerloginparameter){
		//ManagerLoginParameter
		ManagerLoginInfo managerlogininfo = null;
		System.out.println("S");
		try {
			managerlogininfo = managerloginbo.loginAdmin(managerloginparameter.getMail(), managerloginparameter.getPass(), managerloginparameter.getHash());
		} catch (HashMistakeException e) {
			// TODO Auto-generated catch block
			try {
				throw new UnauthorizedException("アクセスが許可できません。");
			} catch (UnauthorizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return managerlogininfo;
	}
	@RequestMapping(path = "loginManagerGeneralAccount", method = RequestMethod.POST)
	public ManagerLoginInfo loginMangerGeneral(@Validated @RequestBody ManagerLoginParameter managerloginparameter){
		ManagerLoginInfo managerlogininfo = null;
		try {
			managerlogininfo = managerloginbo.login(managerloginparameter.getMail(), managerloginparameter.getPass(), managerloginparameter.getHash());
		} catch (HashMistakeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				throw new UnauthorizedException("アクセスが許可できません。");
			} catch (UnauthorizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return managerlogininfo;
	}
}

