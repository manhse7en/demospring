package com.ccs1hnue.model.neo4j.node;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="status")
public class Status extends Post{
	@SuppressWarnings("unused")
	public Status(){
		super();
	}
}
