package com.ccs1hnue;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.ccs1hnue.config.component.ParentBean;


@SpringBootApplication
public class RestMongodbApplication {
	private static final Logger LOGGER = Logger.getLogger(RestMongodbApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(RestMongodbApplication.class, args);
        ParentBean parentBean = applicationContext.getBean(ParentBean.class);
        parentBean.test();
	}
	
}
