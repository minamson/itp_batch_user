package com.rfiot.itp.toDB.config;

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
    entityManagerFactoryRef = "ToUserEntityManagerFactory",
    transactionManagerRef = "ToTransactionManager",
    basePackages = { "com.rfiot.itp.toDB.repository" }
)
class ToEntityManagerFactoryConfiguration {

//    @Autowired
//    @Qualifier("ToDataSource")
//    private DataSource toDataSource;
    @Bean(name = "ToDataSource")
    @ConfigurationProperties(prefix = "spring.to-db")
    public DataSource getToDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "ToUserEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getToUserEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
            .dataSource(getToDataSource())
            .packages("com.rfiot.itp.toDB.entity")
            .persistenceUnit("ToUser")
            .build();
    }

    @Bean(name = "ToTransactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        EntityManagerFactory entityManagerFactory = Objects.requireNonNull(getToUserEntityManagerFactory(builder).getObject());
        return new JpaTransactionManager(entityManagerFactory);

    }

}
