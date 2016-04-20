package io.fourfinanceit.homework;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


	@Configuration
	@EnableTransactionManagement
	@EnableWebMvc
	@ComponentScan(basePackages = { "io.fourfinanceit.homework"})
	public class AppConfiguration extends WebMvcConfigurerAdapter {

	@Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	    
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    }
	    
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource ds = new DriverManagerDataSource();
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
	        ds.setUrl("jdbc:mysql://localhost:3306/loan?createDatabaseIfNotExist=true");
	        ds.setUsername("root");
	        ds.setPassword("root");
	        return ds;
	    }

	    @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
	        sfb.setDataSource(dataSource());
	        sfb.setPackagesToScan(new String[] { "io.fourfinanceit.homework.risk.model" });
	        Properties props = new Properties();
	        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        props.setProperty("hibernate.show_sql", "true");
	        props.setProperty("hibernate.hbm2ddl.auto", "update");
	        props.setProperty("hibernate.connection.zeroDateTimeBehavior", "convertToNull");
	        sfb.setHibernateProperties(props);
	        return sfb;
	    }

	    @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	        return new HibernateTransactionManager(sessionFactory);
	    }

	    
}
