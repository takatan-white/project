package jp.ac.asojuku.asojobs.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import jp.ac.asojuku.asojobs.beans.Company;
import jp.ac.asojuku.asojobs.beans.CompanyResource;
import jp.ac.asojuku.asojobs.bo.CompanyBo;

import jp.ac.asojuku.asojobs.dao.CompanyDAO;

public class CompanyBoImpl implements CompanyBo{
	@Autowired
	private CompanyDAO companydao;
	@Autowired
	private TransactionTemplate transactionTemplate;

	@Override
	public String findAll() {
	
		String name = companydao.findAll();
		return name;
	}

	@Override
	public  Object insertCompany() {
		// TODO Auto-generated method stub
		return transactionTemplate.execute(new TransactionCallback<Object>() {

			@Override
			public Object doInTransaction(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				companydao.insertCompany();
				String str2 = null;
				
				System.out.println(str2.length());
				boolean flag = true;
				Object obj = new Object();
				obj = flag;
				return obj;
			}
		});
	}

	@Override
	public Company[] seachCompany(Integer id) {
		// TODO Auto-generated method stub
		//daoからの戻り値がListなのでcompanyのListの変数
		List<Company> companyList = null;
		//企業情報を入れる配列の変数
		Company[] companyarrya = null;
		//企業情報を検索（ID）
		companyList = companydao.seachCompany(id);
		//リストを配列に変換する。
		companyarrya = companyList.toArray(new Company[0]);
		
		return companyarrya;
	}
	

	@Override
	public Company[] seachCompany(String name) {
		// TODO Auto-generated method stub
		List<Company> companyList = null;
		companyList = companydao.seachCompany(name);
		Company[] companyarrya = null;
		companyarrya = companyList.toArray(new Company[0]);
		return companyarrya;
	}
	
	@Override
	public CompanyResource[] companyInfo(Integer id) {
		// TODO Auto-generated method stub
		
		List<CompanyResource> companyList = null;
		companyList = companydao.companyInfo(id);
		CompanyResource[] companyresourcearray = null;
		companyresourcearray = companyList.toArray(new CompanyResource[0]);
		return companyresourcearray ;
	}

}
