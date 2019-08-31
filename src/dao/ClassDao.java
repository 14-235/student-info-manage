package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import entities.Classinfo;
import utils.JDBCUtils;

public class ClassDao {
	
	public HashSet<String> depts = new HashSet<>();
	
	public HashSet<String> getAllDepts() {
		return this.depts;
	}
	 
	public List<Classinfo> getAllClasses() {
		
		ArrayList<Classinfo> classes = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("select * from class");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				depts.add(resultSet.getString("dept"));
				classes.add(new Classinfo(resultSet.getInt("id"), resultSet.getString("classname"), resultSet.getString("subject"),resultSet.getString("dept")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return classes;
	}
	
	public Classinfo getClassByName(String name) {
		Classinfo classinfo = null;
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("select * from class where classname = ?");
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				classinfo = new Classinfo(resultSet.getInt("id"), resultSet.getString("classname"), resultSet.getString("subject"),resultSet.getString("dept"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return classinfo;
	}
	
	public int addClass(Classinfo classinfo) {
		
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("insert into class (classname,subject,dept) values (?,?,?)");
			preparedStatement.setString(1, classinfo.getClassname());
			preparedStatement.setString(2, classinfo.getSubject());
			preparedStatement.setString(3, classinfo.getDept());
			res = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return res;
	}
	
	public int updateClass(Classinfo classinfo) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("update class set classname=?,subject=?,dept=? where id=?");
			preparedStatement.setString(1, classinfo.getClassname());
			preparedStatement.setString(2, classinfo.getSubject());
			preparedStatement.setString(3, classinfo.getDept());
			preparedStatement.setInt(4, classinfo.getId());
			res = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return res;
	}
	public int deleteClass(Integer id) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("delete from class where id=?");
			preparedStatement.setInt(1, id);
			res = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return res;
	}
	
}
