package com.ssh.demo.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ssh.demo.entity.User;
import com.ssh.demo.repository.UserRepository;
import com.ssh.demo.util.PageJSON;

public class UserService {
	
	private UserRepository userRepository;
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public List<User> getAll(){
		List<User> users=userRepository.getAll();
		 //to do sth users
		return users;
	}
	
	public void saveOrUpdate(User user){
		userRepository.saveOrUpdate(user);
	}
	public void del(Integer id){
		userRepository.delete(id);
	}
	public User  get(Integer id){
		return userRepository.get(id);
	}
	
	public String getPageJSON(int page, int rows,  Map<String, String> map) {

        PageJSON<User> pj = new PageJSON<User>() ; 
        
        String rtn = "{\"total\":0,\"rows\":[ ]}" ;//ת���ַ�
        
        int total = userRepository.findTotal(map) ;
        
        if(total > 0)
        {
            List<User> list = userRepository.find(page, rows, map) ;
            
            //��List����תΪJSON����
            String json_list = JSONArray.toJSONString(list) ;
            
            pj.setRows(list);
            pj.setTotal(total);
            
            rtn = JSONObject.toJSONString(pj) ;
            
        }
        
        return rtn ;
        
    }
}
