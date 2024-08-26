package com.rfiot.itp.fromDB.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "FromUserEntityManagerFactory",
    transactionManagerRef = "FromTransactionManager",
    basePackages = { "com.rfiot.itp.fromDB.repository" }
)
public class FromEntityManagerFactoryConfiguration {

    @Primary
    @Bean(name = "FromDataSource")
    @ConfigurationProperties(prefix = "spring.from-db")
    public DataSource getFromDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "FromUserEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getFromUserEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
            .dataSource(getFromDataSource())
            .packages("com.rfiot.itp.fromDB.entity")
            .persistenceUnit("FromUser")
            .build();
    }

    @Bean(name = "FromTransactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        EntityManagerFactory entityManagerFactory = Objects.requireNonNull(getFromUserEntityManagerFactory(builder).getObject());
        return new JpaTransactionManager(entityManagerFactory);
    }

}
