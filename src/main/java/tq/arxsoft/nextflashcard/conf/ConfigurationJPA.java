/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tq.arxsoft.nextflashcard.conf;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 *
 * @author tkudas
 */
@Configuration
public class ConfigurationJPA {

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/EnglishFlashCard");
        ds.setUsername("postgres");
        ds.setPassword("adminadmin");
        return ds;
    }

    @Bean
    LocalSessionFactoryBean localEntityManagerFactoryBean(DataSource dataSource) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan(new String[]{"tq.arxsoft.nextflashcard"});
        //Properties props = new Properties();
        //props.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");
        //props.setProperty("show_sql", "true");
        //factoryBean.setHibernateProperties(props);
        return factoryBean;
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("tq.arxsoft_NextFlashCard_war_1.0-SNAPSHOTPU");
        return emfb;
    }
}
