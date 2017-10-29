package com.qbd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qbd.model.User;
import com.qbd.service.UserService;
import com.qbd.utils.PageBean;
import com.qbd.utils.StringUtil;

@Controller
public class UserController {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/userlist")
	public Map<String, Object> getAll(String page, String rows, @ModelAttribute User user) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uname", StringUtil.formatLike(user.getUname()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<User> userList = userService.find(map);
		Long total = userService.getTotal(map);
		map.clear();
		map.put("total", total);
		map.put("users", userList);
		return map;
	}

	@RequestMapping("/list")
	public Map<String, Object> List() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uname", null);
		map.put("start", null);
		map.put("size", null);
		List<User> userList = userService.find(map);
		Long total = userService.getTotal(map);
		map.clear();
		map.put("total", total);
		map.put("users", userList);
		return map;
	}

	@RequestMapping("/usersave")
	public Map<String, Object> save(@ModelAttribute User user) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		int resultTotal = 0; // �����ļ�¼����
		if (user.getUid() == 0) {
			resultTotal = userService.add(user);
		} else {
			resultTotal = userService.update(user);
		}
		if (resultTotal > 0) {
			map.put("success", "保存成功");
		} else {
			map.put("success", "保存失败");
		}
		return map;
	}

	@RequestMapping("/userdelete")
	public Map<String, Object> delete(@RequestParam(value = "deluids") String ids) throws Exception {
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			userService.delete(Integer.parseInt(idsStr[i]));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", "删除成功");
		return map;

	}

	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
}
