package com.ccs1hnue.model.neo4j.node;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label="post")
public class Post {
	@GraphId
	private Long id;
	@Property(name="_id")
	private Long _id;
}
