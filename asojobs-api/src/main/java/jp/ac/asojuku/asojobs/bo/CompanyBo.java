package jp.ac.asojuku.asojobs.bo;

import java.util.List;

import jp.ac.asojuku.asojobs.beans.Company;
import jp.ac.asojuku.asojobs.beans.CompanyResource;

import jp.ac.asojuku.asojobs.dao.CompanyDAO;

public interface CompanyBo {

	public String findAll();
	
	public Object insertCompany();
	public Company[] seachCompany(Integer id);
	public Company[] seachCompany(String  name);
	public CompanyResource[] companyInfo(Integer id);
	
}