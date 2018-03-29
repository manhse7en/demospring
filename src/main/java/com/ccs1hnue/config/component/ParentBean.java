package com.ccs1hnue.config.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParentBean {
	
	@Autowired
	private ChildBean childBean;

	public ChildBean getChildBean() {
		return childBean;
	}
	
	@Autowired
	public void setChildBean(ChildBean childBean) {
		this.childBean = childBean;
	}

	public void test()
	{
		System.out.println(childBean.test());
	}
	
}
