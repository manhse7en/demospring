package com.ccs1hnue;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ccs1hnue.config.component.ParentBean;


@SpringBootApplication
@EntityScan(basePackages = "com.ccs1hnue.model.neo4j")
@EnableNeo4jRepositories(basePackages = "com.ccs1hnue.repository.neo4j")
@EnableTransactionManagement
public class RestMongodbApplication {
	private static final Logger LOGGER = Logger.getLogger(RestMongodbApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(RestMongodbApplication.class, args);
        ParentBean parentBean = applicationContext.getBean(ParentBean.class);
        parentBean.test();
	}
	
	public void run(String... args) throws Exception{
		if(args.length > 0)
		{
			System.out.println(args[0].toString());
		}
	}
}
