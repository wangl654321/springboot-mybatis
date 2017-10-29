package com.qbd.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbd.dao.UserDao;
import com.qbd.model.User;
import com.qbd.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}

	public int update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	public int add(User user) {
		// TODO Auto-generated method stub
		return userDao.add(user);
	}

	public List<User> find(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.find(map);
	}

	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.getTotal(map);
	}

	

}
