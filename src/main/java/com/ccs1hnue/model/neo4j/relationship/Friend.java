package com.ccs1hnue.model.neo4j.relationship;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.ccs1hnue.model.neo4j.node.User;

@RelationshipEntity(type="friend")
public class Friend {
	@GraphId   private Long id;
    @Property  private int friendly;
    @Property  private int friendtype;
    @StartNode private User user1;
    @EndNode   private User user2;
    
    public Friend() {
    	this.friendly = 1;
    	this.friendtype = 1;
    }
}
