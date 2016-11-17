package com.sport.mvc.config;

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

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.sport.mvc"})
@PropertySource("classpath:db.properties")
public class HibernateConfig {

    private static final String DATABASE_DRIVER = "db.driver";
    private static final String DATABASE_URL = "db.url";
    private static final String DATABASE_USERNAME = "db.username";
    private static final String DATABASE_PASSWORD = "db.password";
    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String ENTITY_MANAGER_PACKAGES_TO_SCAN = "packagesToScan";
    private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String HIBERNATE_ENABLE_LAZY_LOAD_NO_TRANS = "hibernate.enable_lazy_load_no_trans";
    private static final String HIBERNATE_CONNECTION_CHARSET = "hibernate.connection.Charset";
    private static final String HIBERNATE_CONNECTION_CHARSET_ENCODING = "hibernate.connection.CharacterEncoding";
    private static final String HIBERNATE_CONNECTION_USE_UNICODE = "hibernate.connection.Useunicode";

    @Resource
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty(DATABASE_DRIVER));
        dataSource.setUrl(environment.getRequiredProperty(DATABASE_URL));
        dataSource.setUsername(environment.getRequiredProperty(DATABASE_USERNAME));
        dataSource.setPassword(environment.getRequiredProperty(DATABASE_PASSWORD));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(environment.getRequiredProperty(ENTITY_MANAGER_PACKAGES_TO_SCAN));
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(HIBERNATE_DIALECT, environment.getRequiredProperty(HIBERNATE_DIALECT));
        properties.put(HIBERNATE_SHOW_SQL, environment.getRequiredProperty(HIBERNATE_SHOW_SQL));
        properties.put(HIBERNATE_HBM2DDL_AUTO, environment.getRequiredProperty(HIBERNATE_HBM2DDL_AUTO));
        properties.put(HIBERNATE_ENABLE_LAZY_LOAD_NO_TRANS, environment.getRequiredProperty(HIBERNATE_ENABLE_LAZY_LOAD_NO_TRANS));
        properties.put(HIBERNATE_CONNECTION_CHARSET, environment.getRequiredProperty(HIBERNATE_CONNECTION_CHARSET));
        properties.put(HIBERNATE_CONNECTION_CHARSET_ENCODING, environment.getRequiredProperty(HIBERNATE_CONNECTION_CHARSET_ENCODING));
        properties.put(HIBERNATE_CONNECTION_USE_UNICODE, environment.getRequiredProperty(HIBERNATE_CONNECTION_USE_UNICODE));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
