package com.ccs1hnue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class EmployeeControllerTests extends RestMongodbApplicationTests{
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	
	@Before
	public void setup()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void validate_employeeId() throws Exception
	{
		mockMvc.perform(get("/employees/employee/5abae239f778701ed07ba952"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/hal+json;charset=UTF-8"))
			.andExpect(jsonPath("$.firstName").value("Gicu"));
	}
}
