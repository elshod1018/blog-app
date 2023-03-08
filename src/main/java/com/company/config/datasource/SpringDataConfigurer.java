package com.company.config.datasource;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@RequiredArgsConstructor
@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.company")
public class SpringDataConfigurer {
    private final Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getRequiredProperty("spring.datasource.jdbc.url"));
        dataSource.setSchema(environment.getRequiredProperty("spring.datasource.jdbc.schema"));
        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.jdbc.user"));
        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.jdbc.password"));
        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.jdbc.driver"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource());
        emfb.setPackagesToScan("com.company");

        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setJpaProperties(properties());
        return emfb;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(LocalContainerEntityManagerFactoryBean bean) {
        return new JpaTransactionManager(Objects.requireNonNull(bean.getObject()));
    }

    private Properties properties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", environment.getRequiredProperty("spring.datasource.hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("spring.datasource.hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("spring.datasource.hibernate.hbm2ddl.auto"));
        return properties;
    }
}
