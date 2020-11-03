package com.fa.inventory.config;

/**
 * @author Nandhu
 */
import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com.fa.inventory.repository" }, entityManagerFactoryRef = "InventoryFactory", transactionManagerRef = "InventoryTransactionManager")
@PropertySource({ "classpath:configuration/Inventory.properties" })
@Configuration
public class SpringConfig {

	private static final String PROPERTY_NAME_SQLSERVER_IP = "InventorySqlserverIp";
	private static final String PROPERTY_NAME_SQLSERVER_PORT = "InventorySqlserverPort";
	private static final String PROPERTY_NAME_DRIVERNAME = "InventoryDriverName";
	private static final String PROPERTY_NAME_DATABASENAME = "InventorydatabaseName";
	private static final String PROPERTY_NAME_DBUSERNAME = "InventoryDBUsername";
	private static final String PROPERTY_NAME_DBPASSWORD = "InventoryDBPassword";
	private static final String PROPERTY_NAME_HIBERNATEDIALET = "InventoryHibernateDialet";
	private static final String PROPERTY_NAME_ENTITY_PACKAGE = "InventoryEntityPackage";

	@Resource
	private Environment env;

	@Bean
	@Primary
	public DataSource dataSourceInventoryMaster() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getProperty(PROPERTY_NAME_DRIVERNAME));

		dataSource.setUrl("jdbc:mysql://" + env.getProperty(PROPERTY_NAME_SQLSERVER_IP) + ":"
				+ env.getProperty(PROPERTY_NAME_SQLSERVER_PORT) + "/"
				 + env.getProperty(PROPERTY_NAME_DATABASENAME));

		dataSource.setUsername(env.getProperty(PROPERTY_NAME_DBUSERNAME));
		dataSource.setPassword(env.getProperty(PROPERTY_NAME_DBPASSWORD));

		return dataSource;

	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

	@Bean(name = "InventoryFactory")
	@Primary
	public EntityManagerFactory InventoryManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);
		vendorAdapter.setShowSql(true);
		vendorAdapter.setDatabasePlatform(env.getProperty(PROPERTY_NAME_HIBERNATEDIALET));
		vendorAdapter.setDatabase(Database.MYSQL);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(env.getProperty(PROPERTY_NAME_ENTITY_PACKAGE));
		factory.setDataSource(dataSourceInventoryMaster());

		Properties properties = new Properties();
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		factory.setJpaProperties(properties);

		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Bean
	@Primary
	public PlatformTransactionManager InventoryTransactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		JpaDialect jpaDialect = new HibernateJpaDialect();
		txManager.setEntityManagerFactory(InventoryManagerFactory());
		txManager.setJpaDialect(jpaDialect);

		return txManager;
	}

	@Bean("Inventory")
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}

}