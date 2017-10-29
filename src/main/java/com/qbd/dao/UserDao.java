package com.qbd.dao;

import java.util.List;
import java.util.Map;

import com.qbd.model.User;

public interface UserDao {

	public List<User> getAll();
	public User getUser(User user);
	public int delete(int id);
	public int update(User user);
	public int add(User user);
	public List<User> find(Map<String,Object> map);
	public List<User> findbyid(Integer uid);
	public Long getTotal(Map<String,Object> map);
}
