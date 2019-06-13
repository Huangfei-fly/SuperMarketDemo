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

	/* ӳ��login���󣬽����¼���� */
	@RequestMapping("/login")
	public String Login() {
		return "login";
	}
	
	@RequestMapping("/toIndex")
	public String ToIndex() {
		return "index";
	}

	/* ӳ�䶼login������ɵ������ ��תҳ�� */
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
			session.setAttribute("error", "�û��������벻��ȷ");
			return "login";
		}
	}

	/* ҳ����ת���û����� ���з�ҳ��ѯ */
//	@RequestMapping("/toAdmin")
//	public String ToAdmin(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model) {
//		PageHelper.startPage(pn, 5);
//		List<User> user = userService.getUser();
//		PageInfo page = new PageInfo(user,5);
//		model.addAttribute("pageInfo", page);
//		return "admin/admin";
//	}

	/* ��ת��admin.jsp */
	@RequestMapping("/toAdmin")
	public String ToAdmin() {
		return "admin/admin";
	}

	/* ȡ���û����е��������� */
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	@ResponseBody
	public Msg ToAdmin1(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<User> user = userService.getUser();
		PageInfo page = new PageInfo(user, 5);
		return Msg.success().add("pageInfo", page);
	}

	/* ȡ��Ȩ�ޱ��е�����Ȩ�� */
	@RequestMapping("/getRoles")
	@ResponseBody
	public Msg getRole() {
		List<Role> roles = roleService.getRole();
		return Msg.success().add("role", roles);
	}

	/* �����û� */
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	@ResponseBody
	public Msg AddUser(User user) {
		userService.addUser(user);
		return Msg.success();
	}

	/* ��idȡ��Ա����Ϣ */
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Msg GetUer(@PathVariable("id") String id) {
		User user1 = userService.getUserByid(id);
		return Msg.success().add("user1", user1);
	}

	/* �����û� */
	@RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.PUT)
	@ResponseBody
	public Msg updateUser(User user) {
		System.out.println(user.getUserId());
		userService.updateUserByid(user);
		return Msg.success();
	}
	
	/* ɾ���û� */
	@RequestMapping(value = "/delUser/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delUser(@PathVariable("userId")String userId) {
		userService.delUser(userId);
	}
}
