package com.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.util.NullableWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.domain.AdminUser;
import com.app.domain.User;
import com.app.service.AdminUserService;
import com.app.service.UserService;
import com.google.gson.Gson;
/**
 * 
 * @author young
 *
 */
@Controller
public class TestController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private AdminUserService adminService;
		
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private RestHighLevelClient client;
	

	@RequestMapping(value="/", method=RequestMethod.POST, produces="text/palin; charset=utf-8")
	@ResponseBody 
	public String get()
	{
		return service.getById(1).getName();
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public int add(@RequestParam String name)
	{
		User user = new User();
		user.setName(name);
		service.add(user);
		return user.getId();
	}
	
	@RequestMapping("/amdin")
	@ResponseBody
	public List<AdminUser> admin() {
		List<AdminUser> users = adminService.getUsers();
		return users;
	}
	
	@RequestMapping("/es")
	@ResponseBody
	public void es() {
		List<AdminUser> users = adminService.getUsers();
		Gson gson = new Gson();
		for(AdminUser user:users) {
			IndexRequest request = new IndexRequest("admin_users","user",Integer.toString(user.getUserId()));
			request.source(gson.toJson(user),XContentType.JSON);
			try {
				client.index(request);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("/map")
	@ResponseBody
	public void map() {
		Map<String, Integer> map = new HashMap<String,Integer>(3);
		Integer i = map.computeIfAbsent("Yang", s->s.length());
		System.out.println(map.get("Yang"));
	}
	
}
