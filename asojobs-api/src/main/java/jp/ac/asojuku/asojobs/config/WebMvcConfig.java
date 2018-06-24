package jp.ac.asojuku.asojobs.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import jp.ac.asojuku.asojobs.dao.BooksDAO;
import jp.ac.asojuku.asojobs.dao.CompanyDAO;
import jp.ac.asojuku.asojobs.dao.impl.BooksDAOImpl;
import jp.ac.asojuku.asojobs.dao.impl.CompanyDAOImpl;
import jp.ac.asojuku.asojobs.dao.impl.JobofferDAOImpl;
import jp.ac.asojuku.asojobs.dao.impl.ManagerDAOImpl;
import jp.ac.asojuku.asojobs.dao.ManagerDAO;
import jp.ac.asojuku.asojobs.bo.CompanyBo;
import jp.ac.asojuku.asojobs.bo.ManagerAccountExistsBo;
import jp.ac.asojuku.asojobs.bo.impl.CompanyBoImpl;
import jp.ac.asojuku.asojobs.bo.JobofferBo;
import jp.ac.asojuku.asojobs.bo.ManagerAccountEntryBo;
import jp.ac.asojuku.asojobs.bo.ManagerLoginBo;
import jp.ac.asojuku.asojobs.dao.JobofferDAO;

import jp.ac.asojuku.asojobs.bo.impl.JobofferBoImpl;
import jp.ac.asojuku.asojobs.bo.impl.ManagerAccountEntryBoImpl;
import jp.ac.asojuku.asojobs.bo.impl.ManagerAccountExistsBoImpl;
import jp.ac.asojuku.asojobs.bo.impl.ManagerLoginBoImpl;

@EnableWebMvc
@ComponentScan(basePackages="jp.ac.asojuku.asojobs")
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
		return new MappingJackson2HttpMessageConverter(
				Jackson2ObjectMapperBuilder.json().indentOutput(true).build());
	}
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
		converters.add(0,mappingJackson2HttpMessageConverter());
	}
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/asofind");
		dataSource.setUsername("XXXXXXXX");
		dataSource.setPassword("XXXXXXXX");
		
		return dataSource;
	}
	
	@Bean
	public BooksDAO getBooksDAO(){
		return new BooksDAOImpl(getDataSource());
	}
	/*
	@Bean
	public CompanyDAO getCompanyDAO(){
		return new CompanyDAOImpl(getDataSource());
	}
	
	*/
	@Bean
	public CompanyBo CompanyBo(){
		CompanyBo companybo = new CompanyBoImpl();
		//companybo.setCompanydao(CompanyDAO());
		return companybo;
		
	}
	@Bean
	public CompanyDAO CompanyDAO(){
		CompanyDAO companydao = new CompanyDAOImpl(getDataSource());
		return companydao;
	}
	@Bean
	public JobofferBo JobofferBo(){
		JobofferBo jobofferbo = new JobofferBoImpl();
		return jobofferbo;
	}
	@Bean
	public JobofferDAO JobofferDAO(){
		JobofferDAO jobofferdao = new JobofferDAOImpl(getDataSource());
		return jobofferdao;
	}
	
	@Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(getDataSource());
    }
	
	@Bean
	public ManagerLoginBo ManagerLoginBo(){
		ManagerLoginBo  managerLoginBo= new ManagerLoginBoImpl();
		return managerLoginBo;
	}
	@Bean
	public ManagerAccountExistsBo managerAccountExistsBo(){
		ManagerAccountExistsBo manageraccountexistsbo = new ManagerAccountExistsBoImpl();
		return manageraccountexistsbo;
	}
	@Bean
	public ManagerAccountEntryBo managerAccountEntrybo(){
		ManagerAccountEntryBo anagerAccountEntryBo = new ManagerAccountEntryBoImpl();
		return anagerAccountEntryBo;
	}
	@Bean
	public ManagerDAO ManagerDAO(){
		ManagerDAO managerDAO = new ManagerDAOImpl(getDataSource());
		return managerDAO;
	}
}
