package com.ccs1hnue.config.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:dev.properties")
public class ChildBean {
	
	@Autowired
	Environment env;
	public String test()
	{
		return env.getProperty("name");
	}
	
}
