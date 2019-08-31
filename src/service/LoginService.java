package service;

import com.alibaba.fastjson.JSONObject;

import dao.UserDao;

public class LoginService {
	UserDao userDao = new UserDao();
	public JSONObject login(String un,String up) {
		JSONObject res = userDao.findUserByNameAndPassword(un, up);
		
		return res;
	}
}
