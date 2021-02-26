/**
 * 
 */
package com.maybank.orsapp.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 80003905
 *
 */

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	//@Bean
	//public LocalSessionFactoryBean sessionFactory() {
		//LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		//sessionFactory.setDataSource(dataSource());
		//sessionFactory.setPackagesToScan("com.maybank.mbbors");
		//Properties hibernateProperties = new Properties();
		//hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
		//hibernateProperties.put("hibernate.show_sql", true);
		//hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		//sessionFactory.setHibernateProperties(hibernateProperties);
		//return sessionFactory;
	//}

	
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("com.maybank.orsapp");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");
		hibernateProperties.put("hibernate.show_sql", true);
		//hibernateProperties.put("hibernate.generate_statistics", true);
		//hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "none");
		em.setJpaProperties(hibernateProperties);
		return em;
	}

	
	@Bean(name = "orsDataSource", destroyMethod = "")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		//For POC server
		//dataSource.setUrl("jdbc:sqlserver://172.30.2.31;databaseName=ORS;");
		
		//For JBoss server
		//dataSource.setUrl("jdbc:sqlserver://172.31.183.171;databaseName=ORS;");
		
		//For Local server
		dataSource.setUrl("jdbc:sqlserver://0.0.0.0:1433;databaseName=ORSA;");
		
		dataSource.setUsername("orsdbuser");
		dataSource.setPassword("P@ssw0rd123");
		return dataSource;
	}

	//@Bean
	//public HibernateTransactionManager transactionManager() {
		//HibernateTransactionManager txManager = new HibernateTransactionManager();
		//txManager.setSessionFactory(sessionFactory().getObject());
		//return txManager;
	//}
	
	@Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
	
	//@Bean
	//public JpaTransactionManager jpaTransactionManager(EntityManagerFactory emf) {
		//JpaTransactionManager transactionManager = new JpaTransactionManager();
        //transactionManager.setEntityManagerFactory(emf);
        //return transactionManager;
	//}

}
