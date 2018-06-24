package jp.ac.asojuku.asojobs.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import jp.ac.asojuku.asojobs.beans.Company;
import jp.ac.asojuku.asojobs.beans.CompanyParamer;
import jp.ac.asojuku.asojobs.beans.CompanyResource;
import jp.ac.asojuku.asojobs.beans.Name;
import jp.ac.asojuku.asojobs.bo.CompanyBo;
import jp.ac.asojuku.asojobs.exception.CompanyResourceConflictException;
import jp.ac.asojuku.asojobs.exception.CompanyResourceNotFoundException;
import jp.ac.asojuku.asojobs.exception.ParamerBadRequest;
import jp.ac.asojuku.asojobs.util.EncodeUtil;

@RestController
@RequestMapping("jobs")
public class CompanysRestController {
	
	@Autowired
	private CompanyBo companyBo;
	
	@RequestMapping(path = "companyInfo",method = RequestMethod.GET)
	public CompanyResource[] companyInfo(@Validated CompanyParamer companyparamer) throws ParamerBadRequest, CompanyResourceNotFoundException{
		//企業コードパラメータからを取得する
		Integer companyId  = companyparamer.getCompanyId();
		//企業情報を返却するbeans
		CompanyResource[] companyresource = null;
		if(companyId != null){
			//企業情報を保持
			companyresource = companyBo.companyInfo(companyId);
			//件数を保持
			int result = companyresource.length;
			if(result == 0){
				//データがない場合
				throw new CompanyResourceNotFoundException();
			}
		}else {
			throw new ParamerBadRequest();
		}
		return companyresource;
	}
	@RequestMapping(value = "/delete/{companyno}", method = RequestMethod.POST)
	public void companyDelete(@PathVariable Integer companyno) throws ParamerBadRequest{
		if(companyno == 0){
			//パラメータ情報がおかしい事をスローする(Http response code 400)
			throw new ParamerBadRequest();
		}
	}
	@RequestMapping(path = "seach",method = RequestMethod.GET)
	//@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Company[] seach(@Validated CompanyParamer companyparamer) throws ParamerBadRequest, CompanyResourceNotFoundException{
		System.out.println("到達");
		//企業コードパラメータからを取得する
		Integer companyId  = companyparamer.getCompanyId();
		//企業名をパラメータから取得する
		String companyName = companyparamer.getCompanyName();
		//企業の配列を宣言
		Company[] companyArray = null;
		
		
		if(companyId != null){
			//企業コードをもとに企業名＋企業コードを取得する
			companyArray = companyBo.seachCompany(companyId);
			int result = companyArray.length;
			if(result == 0){
				throw new CompanyResourceNotFoundException();
			}
		}else if(companyName != null ){
			//companyList = companyBo.seachCompany(companyName);
			//企業名をデコードする
			companyName = EncodeUtil.decode(companyName);
			//デコードが失敗した場合は、エンコードされていない文字コードの場合。
			if(companyName.equals("")){
				//パラメータ情報がおかしい事をスローする(Http response code 400)
				throw new ParamerBadRequest();
			}
			//企業名をもとに、企業コードと企業名を取得する。
			companyArray = companyBo.seachCompany(companyName);
			int result = companyArray.length;
			if(result == 0){
				throw new CompanyResourceNotFoundException();
			}
		}else{
			try{
				//パラメータが何も指定されていない場合。
				//throw new ParamerBadRequest();
				int a = 0;
				a = companyId.toString().length();
				a = companyName.length();
			}catch(Exception e){
				//パラメータ情報がおかしい事をスローする(Http response code 400)
				throw new ParamerBadRequest();
			}
			
		}
		if(companyArray != null){
			System.out.println(companyArray);
		}
		return companyArray;
	}
	@RequestMapping(method = RequestMethod.GET)
	public Name findAll(){
		Object obj = new Object();
		try{
			
		obj = companyBo.insertCompany();
		
		}catch(Exception e){
			throw new CompanyResourceConflictException();
		}
		
		Name name = new Name();
		name.setName(companyBo.findAll());
		return name;
	}
	@RequestMapping(path = "/bo",method = RequestMethod.GET)
	public Name put(@Validated Name name){
		Name na = new Name();
		na.setName(name.getName());
		Company company[] = new Company[5];
		//company[0] = null;x
		for(int i = 0; i < company.length; i++){
			company[i] = new Company();
			company[i].setCompanycode(100);
			company[i].setCompanyname("aso");
		}
		na.setCompany(company);
		//na.getCompany()[0].setCompanycode(1200);
		//na.getCompany()[0].setCompanyname("taka");
		return na;
	}
	
	
}
