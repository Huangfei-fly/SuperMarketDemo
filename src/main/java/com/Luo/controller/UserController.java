package com.Luo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Luo.bean.Msg;
import com.Luo.bean.Role;
import com.Luo.bean.User;
import com.Luo.service.RoleService;
import com.Luo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	/* 映射login请求，进入登录界面 */
	@RequestMapping("/login")
	public String Login() {
		return "login";
	}
	
	@RequestMapping("/toIndex")
	public String ToIndex() {
		return "index";
	}

	/* 映射都login请求，完成登入操作 跳转页面 */
	@RequestMapping(value = "/dologin")
	public String doLogin(@RequestParam("userId") String userId, @RequestParam("userPassword") String password,
			HttpSession session) {
		com.Luo.bean.User user = userService.login(userId, password);
		if (user != null) {
			if (Integer.parseInt(user.getRoleId()) == 1) {
				session.setAttribute("user", user);
				return "frame/AdminFrame";
			} else if (Integer.parseInt(user.getRoleId()) == 2) {
				session.setAttribute("user", user);
				return "frame/ManagerFrame";
			} else if (Integer.parseInt(user.getRoleId()) == 3) {
				session.setAttribute("user", user);
				return "frame/CashierFrame";
			} else
				return "frame/ExecutorFrame";

		} else {
			session.setAttribute("error", "用户名或密码不正确");
			return "login";
		}
	}

	/* 页面跳转到用户管理 进行分页查询 */
//	@RequestMapping("/toAdmin")
//	public String ToAdmin(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model) {
//		PageHelper.startPage(pn, 5);
//		List<User> user = userService.getUser();
//		PageInfo page = new PageInfo(user,5);
//		model.addAttribute("pageInfo", page);
//		return "admin/admin";
//	}

	/* 跳转到admin.jsp */
	@RequestMapping("/toAdmin")
	public String ToAdmin() {
		return "admin/admin";
	}

	/* 取得用户表中的所有数据 */
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ResponseBody
	public Msg ToAdmin1(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<User> user = userService.getUser();
		PageInfo page = new PageInfo(user, 5);
		return Msg.success().add("pageInfo", page);
	}

	/* 取得权限表中的所有权限 */
	@RequestMapping("/getRoles")
	@ResponseBody
	public Msg getRole() {
		List<Role> roles = roleService.getRole();
		return Msg.success().add("role", roles);
	}

	/* 新增用户 */
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	@ResponseBody
	public Msg AddUser(User user) {
		userService.addUser(user);
		return Msg.success();
	}

	/* 以id取得员工信息 */
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Msg GetUer(@PathVariable("id") String id) {
		User user1 = userService.getUserByid(id);
		return Msg.success().add("user1", user1);
	}

	/* 更新用户 */
	@RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.PUT)
	@ResponseBody
	public Msg updateUser(User user) {
		System.out.println(user.getUserId());
		userService.updateUserByid(user);
		return Msg.success();
	}
	
	/* 删除用户 */
	@RequestMapping(value = "/delUser/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delUser(@PathVariable("userId")String userId) {
		userService.delUser(userId);
	}
}
