package com.ccs1hnue.config;

import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EntityScan(basePackages = "com.ccs1hnue.model")
@EnableJpaRepositories(basePackages = "com.ccs1hnue.repository.mysql")
@EnableNeo4jRepositories(basePackages = "com.ccs1hnue.repository.neo4j")
@EnableMongoRepositories(basePackages = "com.ccs1hnue.repository.mongodb")
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry)
	{
		registry.addMapping("/redis")
				.allowedOrigins("http://localhost:8181", "http://localhost:8282")
				.allowedMethods("POST", "GET", "PUT", "DELETE")
				.allowedHeaders("Content-Type")
				.exposedHeaders("header-1", "header-2")
				.allowCredentials(false)
				.maxAge(6000);
	}
	
	@Bean
    public SessionFactory sessionFactory() {
        return new SessionFactory(configuration(), "com.ccs1hnue.model.neo4j");
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        ConfigurationSource properties = new ClasspathConfigurationSource("ogm.properties");
        org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder(properties).build();
        return configuration;
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
