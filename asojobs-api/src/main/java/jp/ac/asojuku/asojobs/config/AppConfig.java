package jp.ac.asojuku.asojobs.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
public class AppConfig {
	@Bean
	public TransactionTemplate transactionTemplate(
			PlatformTransactionManager transationManager){
		TransactionTemplate transactionTemplate = new TransactionTemplate(transationManager);
		transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		transactionTemplate.setTimeout(30);
		return transactionTemplate;
		
	}
	@Bean
    ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}