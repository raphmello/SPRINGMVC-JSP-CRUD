package com.project.springmvc.crudProject.config;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.project.springmvc.crudProject.dao.ExameDAO;
import com.project.springmvc.crudProject.dao.ExameDAOImpl;

@Configuration
@ComponentScan(basePackages="com.project.springmvc.crudProject")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/job-crud-project?useSSL=false&serverTimezone=GMT-3");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");
         
        return dataSource;
    }
     
    @Bean
    public ExameDAO getExameDAO() {
        return new ExameDAOImpl(getDataSource());
    }
    
//    @Bean
//    public ResourceBundleMessageSource messageSource() {
//
//        var source = new ResourceBundleMessageSource();
//        source.setBasenames("resources/messages");
//        source.setUseCodeAsDefaultMessage(true);
//
//        return source;
//    }
    
    @Bean
    public MessageSource messageSource() {
    	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("resources/messages");
 
        return messageSource;
    }
	
}
