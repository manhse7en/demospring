package com.ccs1hnue.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccs1hnue.model.mongodb.Employee;

@RestController
@RequestMapping("redis/")
public class RedisController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	private ClusterOperations<String, Object> clusterOperations;
	private HashOperations<String, String, Employee> hashOperations;
	private HyperLogLogOperations<String, Object> hyperLogLogOperations;
	private ListOperations<String, Object> listOperations;
	private SetOperations<String, Object> setOperations;
	private ValueOperations<String, Object> valueOperations;
	private ZSetOperations<String, Object> zSetOperations;

	@RequestMapping(value = "cluster")
	public HttpEntity<?> demoCluster()
	{
		clusterOperations = redisTemplate.opsForCluster();
		Employee e = new Employee("1","Nguyễn Đức", "Mạnh", 25);
		e.add(linkTo(methodOn(RedisController.class).demoCluster()).withSelfRel());
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
	
	@RequestMapping(value = "hash")
	public HttpEntity<?> demoHash()
	{
		hashOperations = redisTemplate.opsForHash();
		Employee e1 = new Employee("1","Nguyễn Đức", "Mạnh", 25);
		Employee e2 = new Employee("2","Nguyễn Thùy", "Dương", 19);
		hashOperations.put("Employee","1",e1);
		hashOperations.put("Employee","2",e2);
		Map<String,Employee> employees = hashOperations.entries("Employee");
		employees.forEach((k,v) -> v.add(linkTo(methodOn(RedisController.class).demoHash()).withSelfRel()));
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@RequestMapping(value = "set")
	public HttpEntity<?> demoSet()
	{
		setOperations = redisTemplate.opsForSet();
		Employee e = new Employee("3","Hà Đức", "Thọ", 33);
		setOperations.add("3", e.toString());
		e.add(linkTo(methodOn(RedisController.class).demoSet()).withSelfRel());
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
}
