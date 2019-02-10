package recipe_lab.database_config;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 * Database Configuration Class
 * Here I'm Using H2 Database 
 * Note: In Case of We Want to User Database Like Mysql,Sqllite
 * Before That please Update this Configuration File According to Your Requirements
 * Don't Forget to inject Dependancy Like Drivers
 * EveryThing Else Automatically Handle By Hibernate So, No need to Change Method of Any Other class or Query
 * */
@Configuration
@ComponentScan(basePackages = { "recipe_lab" })
@EnableTransactionManagement
public class HibernateConfig {
	BasicDataSource dataSource;
	// Change the below final variable value based on database you choose here i am
	// using H2 database.
	private final static String DATABASE_URL = "jdbc:h2:~/recipelab"; // Change this to your Database url
	private final static String DATABASE_DRIVER = "org.h2.Driver"; // Chnage Driver Name
	private final static String DATABASE_DIALECTS = "org.hibernate.dialect.H2Dialect"; // Add Dialects According to Your
																						// Database
	private final static String DATABASE_USERNAME = "sa"; // Username
	private final static String DATABASE_PASSWORD = "sa"; // Password

	// Database will be available
	@Bean("dataSource")
	public DataSource getSource() {
		dataSource = new BasicDataSource();
		// Providing database connection Information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;
	}

	// Database will be available
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("recipe_lab.dto");
		return builder.buildSessionFactory();
	}

	// For Hibernate property return
	private Properties getHibernateProperties() { // Don't Change this Untill you need Advance Feature
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECTS);
		properties.put("hibernate.show_sql", "true"); // Show Which Query Is generated By hibernate
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	// HibernateTransactionManager
	@Bean
	public HibernateTransactionManager getTransactionManagement(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
