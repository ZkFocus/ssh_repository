package com.mybatis.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybatis.demo.entity.PageBean;
import com.mybatis.demo.entity.User;
import com.mybatis.demo.service.UserService;
import com.mybatis.demo.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("listall")
	public String getAll(@RequestParam(value="page",required=false)String page,@RequestParam(value="rows",required=false)String rows,HttpServletResponse response,User user) throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", user.getName());
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<User> userList=userService.getUsers(map);
		Long total=userService.getTotalUser();
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(userList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	@RequestMapping("list")
	public String list(){
		return "list";
	}
	
	/**
	 * 添加用户
	 * @param customer
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(User user,HttpServletResponse response)throws Exception{
		int resultTotal=0; // 操作的记录条数
		if(user.getId()==null){
			resultTotal=userService.addUser(user);
		}else{
			resultTotal=userService.updateUser(user);
		}
		JSONObject result=new JSONObject();
		if(resultTotal>0){ // 执行成功
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 删除用户
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response)throws Exception{
		JSONObject result=new JSONObject();
		String []idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			userService.deleteUser(Integer.parseInt(idsStr[i]));
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
