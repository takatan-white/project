package jp.ac.asojuku.asojobs.dao;

import java.util.List;

//import jp.ac.asojuku.asojobs.beans.Company;
import jp.ac.asojuku.asojobs.beans.CompanyResource;
import jp.ac.asojuku.asojobs.entity.Company;

public interface CompanyDAO {
	public String findAll();
	public void insertCompany();
	public List<jp.ac.asojuku.asojobs.beans.Company> seachCompany(Integer id);
	public List<jp.ac.asojuku.asojobs.beans.Company> seachCompany(String  name);
	public List<CompanyResource> companyInfo(Integer id);
	public CompanyResource chegeEntityToDto(Company company);
}
