package jp.ac.asojuku.asojobs.dao.impl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

//import jp.ac.asojuku.asojobs.beans.Company;
import jp.ac.asojuku.asojobs.beans.CompanyResource;
import jp.ac.asojuku.asojobs.dao.CompanyDAO;
import jp.ac.asojuku.asojobs.entity.Company;
import jp.ac.asojuku.asojobs.entity.Indstry;



public class CompanyDAOImpl implements CompanyDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	ModelMapper modelMapper;
	
	public CompanyDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT name FROM public WHERE id = ?";
		
		return jdbcTemplate.queryForObject(sql,new Object[]{new String("2")},
                String.class);
	}

	@Override
	public void insertCompany() {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO test_table(test_id,test_name) values(?,?)";
		jdbcTemplate.update(sql,4,"taka");
		
	}

	@Override
	public List<jp.ac.asojuku.asojobs.beans.Company> seachCompany(Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT "+ Company.COMPANY_NAME +", " + Company.COMPANY_NO  +","+Company.COMPANY_BRANCH +" FROM " 
		+ Company.COMPANY_TABLE+ " WHERE " + Company.COMPANY_NO + " = ?";
		List<jp.ac.asojuku.asojobs.beans.Company> companyList = new ArrayList<jp.ac.asojuku.asojobs.beans.Company>();
		List<Map<String,Object>> resultlist = jdbcTemplate.queryForList(sql,id);
		/*
		for(Map<String,Object> result : resultlist){
			Company company = new Company();
			company.setCompanycode((int)result.get(CompanyEntity.COMPANY_NO));
			company.setCompanyname((String)result.get(CompanyEntity.COMPANY_NAME));
			companyList.add(company);
		}
		*/
		resultlist.stream().forEach(e ->{
			jp.ac.asojuku.asojobs.beans.Company company = new jp.ac.asojuku.asojobs.beans.Company();
			company.setCompanycode((int)e.get(Company.COMPANY_NO));
			company.setCompanyname((String)e.get(Company.COMPANY_NAME));
			company.setCompany_branch((String)e.get(Company.COMPANY_BRANCH));
			companyList.add(company);
		});
		return companyList;
	}

	@Override
	public List<jp.ac.asojuku.asojobs.beans.Company>seachCompany(String name) {
		// TODO Auto-generated method stub
		name = this.makeLikeParameter(name);
		String sql = "SELECT "+ Company.COMPANY_NAME +", " + Company.COMPANY_NO +","+Company.COMPANY_BRANCH +
				" FROM " + Company.COMPANY_TABLE +" WHERE " + Company.COMPANY_NAME + " LIKE ? ";
		List<jp.ac.asojuku.asojobs.beans.Company> companyList = new ArrayList<jp.ac.asojuku.asojobs.beans.Company>();
				List<Map<String,Object>> resultlist = jdbcTemplate.queryForList(sql,name);
		/*for(Map<String,Object> result : resultlist){
			Company company = new Company();
			company.setCompanycode((int)result.get(CompanyEntity.COMPANY_NO));
			company.setCompanyname((String)result.get(CompanyEntity.COMPANY_NAME));
			companyList.add(company);
		}*/
		
		resultlist.stream().forEach(e ->{
			jp.ac.asojuku.asojobs.beans.Company company = new jp.ac.asojuku.asojobs.beans.Company();
			company.setCompanycode((int)e.get(Company.COMPANY_NO));
			company.setCompanyname((String)e.get(Company.COMPANY_NAME));
			company.setCompany_branch((String)e.get(Company.COMPANY_BRANCH));
			companyList.add(company);
		});
		return companyList;
	}
	

	@Override
	public List<CompanyResource> companyInfo(Integer id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM " 
				+ Company.COMPANY_TABLE+ " AS c, " +Indstry.INDSTRY_TBL_NAME 
				+" AS i"+" WHERE " + "c.indstry_no = i.indstry_no AND c."+ 
					Company.COMPANY_NO + " = ?";
		List<CompanyResource> companyList = new ArrayList<CompanyResource>();
		List<Map<String,Object>> resultlist = jdbcTemplate.queryForList(sql,id);
		resultlist.stream().forEach(e -> {
			Company company = new Company();
			
			Indstry indstry = new Indstry();
			
			CompanyResource companyResource = null;
			
			company.setCompany_no((Integer)e.get(Company.COMPANY_NO));
			company.setCompany_name((String)e.get(Company.COMPANY_NAME));
			company.setCompany_kana((String)e.get(Company.COMPANY_KANA));
			company.setCompany_branch((String)e.get(Company.COMPANY_BRANCH));
			company.setCompany_branch_kana((String)e.get(Company.COMPANY_BRANCH_KANA));
			company.setCompany_capital((Integer)e.get(Company.COMPANY_CAPITAL));
			company.setCompany_sales((Integer)e.get(Company.COMPANY_SALES));
			company.setCompany_day((String)e.get(Company.COMPANY_DAY));
			company.setCompany_sum((Integer)e.get(Company.COMPANY_SUM));
			company.setCompany_man((Integer)e.get(Company.COMPANY_MAN));
			company.setCompany_woman((Integer)e.get(Company.COMPANY_WOMAN));
			String zipcode = ((String)e.get(Company.COMPANY_ZIPCODE));
			zipcode = fomatZipode(zipcode);
			company.setCompany_zipcode(zipcode);
			company.setCompany_prefectures((String)e.get(Company.COMPANY_PREFECTURES));
			company.setCompany_address((String)e.get(Company.COMPANY_ADDRESS));
			indstry.setIndstry_name((String)e.get(Indstry.INDStRY_TBL_INDSTRYNAME));
			indstry.setIndstry_no((Integer)e.get(Indstry.INDSTRY_TBL_INDSTRYNO));
			company.setIndstry(indstry);
			company.setCompany_business((String)e.get(Company.COMPANY_BUSINESS));
			
			company.setCompany_mail((String)e.get(Company.COMPANY_MAIL));
			company.setCompany_tel((String)e.get(Company.COMPANY_TEL));
			company.setCompany_fax((String)e.get(Company.COMPANY_FAX));
			company.setCompany_url((String)e.get(Company.COMPANY_URL));
			company.setCompany_stock((String)e.get(Company.COMPANY_STOCK));
			
			companyResource = chegeEntityToDto(company);
			
			companyList.add(companyResource);
		});
		return companyList;
	}
	
	private String makeLikeParameter(String param){

		//%があった場合を考慮
		StringUtils.replace(param, "%", "\\%");
		//_があった場合を考慮
		StringUtils.replace(param, "_", "\\_");

		return "%"+param+"%";
	}
	private String fomatZipode(String zipcode){
		return zipcode.substring(0, 3) + "-" + zipcode.substring(3);
	}
	@Override
	public CompanyResource chegeEntityToDto(Company company){
		CompanyResource dto = modelMapper.map(company, CompanyResource.class);
		return dto;
	}
	
}
