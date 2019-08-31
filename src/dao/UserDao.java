package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.fastjson.JSONObject;

import entities.User;

import utils.JDBCUtils;


public class UserDao {
	

	
	
	public JSONObject findUserByNameAndPassword(String un,String up) {
		
		User user = null;
		JSONObject res = new JSONObject();
		
		try {
			Connection connection = JDBCUtils.getConn();
			PreparedStatement pstmt = connection.prepareStatement("select * from user where username =? and password =?");
			pstmt.setString(1, un);
			pstmt.setString(2, up);
			ResultSet resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				user = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("password"));
			}
			if(user == null) {
				res.put("flag", "0");
				res.put("info", "用户不存在或密码错误！");
				System.out.println("用户不存在或密码错误！");
				
				
			}else {
				res.put("flag", "1");
				res.put("username", user.getUsername());
				res.put("info", "登录成功！");
				System.out.println(user);
			}
			res.put("user", user);
			return res;
			
		} catch (Exception e) {
			res.put("info", "系统异常！");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;


		
	}
	
}
