package com.prisys.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prisys.web.entity.User;


@Controller
@RequestMapping(value="/testAjaxController")
public class TestAjaxController {
	private String message;
	/**
	 * ajax1
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/ajax",method=RequestMethod.POST)
	public  void ajax(HttpServletResponse response) {
		User user=new User();
		user.setId(1l);
		user.setUsername("123");
		JSONObject json=JSONObject.fromObject(user);
		message=json.toString();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(message);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
	/**
	 * '@RequestBody' 返回的是字符串
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/ajax1",method=RequestMethod.POST)
	@ResponseBody
	public  String ajax1(@RequestBody User user) {
		JSONObject json=JSONObject.fromObject(user);
		message=json.toString();
		return message;
	}
	/**
	 * '@RequestBody' 返回的是字符串
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/ajax2",method=RequestMethod.POST)
	@ResponseBody
	public  String ajax2(@RequestBody List<User> user) {
		JSONArray json=JSONArray.fromObject(user);
		message=json.toString();
		return message;
	}
	/**
	 * '@RequestBody' 返回的是字符串
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/ajax3",method=RequestMethod.POST)
	@ResponseBody
	public  User ajax3(@RequestBody User user) {
		return user;
	}
	/**
	 * '@RequestBody' 返回的是字符串
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/ajax4",method=RequestMethod.POST)
	@ResponseBody
	public  List<User> ajax4(@RequestBody List<User> user) {
		return user;
	}
}
