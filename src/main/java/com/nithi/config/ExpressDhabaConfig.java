package com.nithi.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.nithi")
@EnableTransactionManagement
@PropertySource(value = "classpath:applications.properties")
public class ExpressDhabaConfig implements WebMvcConfigurer {
	
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Bean
	public InternalResourceViewResolver getViewResolver() {

		InternalResourceViewResolver viewresolver = new InternalResourceViewResolver();
		viewresolver.setPrefix("/WEB-INF/view/");
		viewresolver.setSuffix(".jsp");
		return viewresolver;

	}

	@Bean
	public BasicDataSource dataSource() throws PropertyVetoException {

		System.out.println("Datasource loading from Enviroment :"+environment.getProperty("MySql.url"));
		//DriverManagerDataSource datasource = new DriverManagerDataSource();

//		ComboPooledDataSource datasource = new ComboPooledDataSource();
//		
//		datasource.setJdbcUrl("jdbc:mysql://localhost:3306/express-dhaba?useSSL=false");
//		datasource.setUser("root");
//		datasource.setPassword("Nithi21");
//		datasource.setDriverClass("com.mysql.cj.jdbc.Driver");
//		
//		datasource.setInitialPoolSize(30);
//		datasource.setMaxPoolSize(50);
//		datasource.setAcquireIncrement(5);

		BasicDataSource datasource = new BasicDataSource();
		//datasource.setUrl("jdbc:mysql://localhost:3306/express-dhaba?useSSL=false");
		//datasource.setUsername("root");
		//datasource.setPassword("Nithi21");
		//datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		//****** Loading from property file*********//
		
		
		String url = environment.getProperty("MySql.url");
		String username = environment.getProperty("MySql.username");
		String password = environment.getProperty("MySql.password");
		
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(environment.getProperty("MySql.driverclass"));
		
		datasource.setInitialSize(30);
		datasource.setMaxActive(50);
		return datasource;

	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() throws PropertyVetoException {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.nithi.entity");
		sessionFactory.setHibernateProperties(setHibernateproperties());
		return sessionFactory;

	}

	private Properties setHibernateproperties() {

		Properties hibernateproperties = new Properties();
		hibernateproperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hibernateproperties.setProperty("hibernate.show_sql", "true");
		//hibernateproperties.setProperty("hibernate.current_session_context_class", "thread");
		return hibernateproperties;

	}
	
	
	//Here to active Transacation we need Transaction manager(HibernateTransacationManger is class) and we need to create 
	//SessionFactory(Bean) Object.We already created is local bean for sessionFactory
	//@EnableTransactionManagement is to active all features of @Transactional annotation(we can you Class leave also).
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addResourceHandlers(registry);
		
		registry.addResourceHandler("/bootstraphandler/**").addResourceLocations("/webjars/");
	}
}