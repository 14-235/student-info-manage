package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.JDBCUtils;

public class CountInfoDao {

	//所有班级数量
	public Integer countAllClasses() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM class");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				res = resultSet.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return res;
	}
	
	//所有学生数量
	public Integer countAllStudents() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM student");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				res = resultSet.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return res;
	}
	//所有系别数量
	public Integer countAllDepts() {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("SELECT COUNT(DISTINCT dept) FROM class");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				res = resultSet.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return res;
	}
	//按系别查询班级数量
	public Integer countClassesByDepts(String depts) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM class where dept =?");
			preparedStatement.setString(1, depts);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				res = resultSet.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return res;
	}
	//按系别查询学生数量
	public Integer countStudentsByDepts(String depts) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM student LEFT JOIN class ON student.`class`=class.`id` WHERE dept=?;");
			preparedStatement.setString(1, depts);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				res = resultSet.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return res;
	}
	//按班级查询学生数量
	public Integer countStudentsByClass(Integer classid) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM student where class =?");
			preparedStatement.setInt(1, classid);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				res = resultSet.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return res;
	}
}
