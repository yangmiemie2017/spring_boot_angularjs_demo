package com.mydemo.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Date;
//import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
//import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mydemo.dao.UserDao;
import com.mydemo.entity.Department;
import com.mydemo.entity.Role;
import com.mydemo.entity.User;
import com.mydemo.service.DataService;
import com.mydemo.service.UserService;

/**
 * @ClassName: UserController
 * @Description: User控制器
 * @author mengfanzhu
 * @date 2017年2月20日 下午5:58:19
 */
@RestController
@RequestMapping("/user")
public class UserController {

	protected static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private DataService dataService;

	@RequestMapping("/demo/{name}")
	// @ResponseBody
	public String demoShowName(@PathVariable String name) {
		logger.debug("访问getUserByName,Name={}", name);
		return "name is " + name;
	}

	/**
	 * @Title: UserController @Description: 数据初始化 @author mengfanzhu @throws
	 */
	@RequestMapping("/initdata")
	// @ResponseBody
	public String initData() {
		dataService.initData();
		return "success";
	}

	@RequestMapping("/initdata1")
	// @ResponseBody
	public String initData1() {
		dataService.initData1();
		return "success1";
	}

	/**
	 * @Title: UserController @Description: 由loginName获取user @param
	 *         loginName @author mengfanzhu @throws
	 */
	@RequestMapping("/list")
	// @ResponseBody
	public List<User> list() {
		Map<String, Object> result = new HashMap<String, Object>();
		return userService.findAll();

	}
	
	@RequestMapping("/getUserByLoginName/{loginName}")
	// @ResponseBody
	public Map<String, Object> getUserByName(@PathVariable String loginName) {
		Map<String, Object> result = new HashMap<String, Object>();
		User user = userService.readByLoginName(loginName);
		// Assert.notNull(user);
		result.put("name", user.getName());
		result.put("loginName", user.getLoginName());
		result.put("departmentName", user.getDepartment().getName());
		result.put("departmentId", user.getDepartment().getId());
		result.put("roleName", user.getRoleList().get(0).getName());
		return result;
	}
	
	@RequestMapping("/{id}")
	// @ResponseBody
	public User getUserById(@PathVariable Long id) {

		User user = userService.findById(id);

		return user;
	}

	//@RequestMapping(value = "/add", method = RequestMethod.POST)
	@RequestMapping(value = "/add")
	public Map<String, Object> addUser(String userJson) {
		User user = new User();
		String timeStr = new java.util.Date().toString().replaceAll(" ", "");
		user.setName("test" + timeStr);
		user.setLoginName("testL" + timeStr);
		user.setDepartment(dataService.getDepartmentById(4));
		List<Role> roleList = dataService.getAllRoles();
		user.setRoleList(roleList);
		user.setPassword("123456");
		userService.save(user);

		Map<String, Object> response = new LinkedHashMap<>();
		response.put("message", "user add successfully");
		response.put("user", user);
		return response;
	}
	


	@RequestMapping(method = RequestMethod.POST)
	User add(@PathVariable Long userId, @RequestBody User input) {
		this.validateUser(userId);

		return userService.save(input);

	}


	private void validateUser(Long userId) {
		userService.findById(userId);
	}
}
