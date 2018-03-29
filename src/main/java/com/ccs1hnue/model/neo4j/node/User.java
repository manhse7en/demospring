package com.ccs1hnue.model.neo4j.node;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import com.ccs1hnue.model.neo4j.relationship.Friend;

@NodeEntity(label="user")
public class User {
	@GraphId
	private Long id;
	@Property(name="_id")
	private Long _id;
	@Property(name="name")
	private String name;
	@Property(name="username")
	private String username;
	
	@Relationship(type="friend")
	private Friend friend;
}
