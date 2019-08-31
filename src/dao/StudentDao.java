package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Classinfo;
import entities.Student;
import utils.JDBCUtils;

public class StudentDao {
	
	public List<Student> getAllStudents() {
		
		ArrayList<Student> students = new ArrayList<>();
		try {
			Connection connection = JDBCUtils.getConn();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				students.add(new Student(resultSet.getInt("sid"), resultSet.getString("sname"), resultSet.getInt("sex"),resultSet.getInt("class"),resultSet.getString("date")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(students);
		return students;
	}
	
	public List<Student> getStudentsBySidORSname(String idOrName) {
		
		ArrayList<Student> students = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("select * from student where sid = ? or sname =?");
			preparedStatement.setInt(1, Integer.parseInt(idOrName));
			preparedStatement.setString(2, idOrName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {	
				students.add(new Student(resultSet.getInt("sid"), resultSet.getString("sname"), resultSet.getInt("sex"),resultSet.getInt("class"),resultSet.getString("date")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return students;
		
	}
	public List<Student> getStudentByClassid(Integer classid) {
		ArrayList<Student> students = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("select * from student where class = ?");
			preparedStatement.setInt(1, classid);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {	
				students.add(new Student(resultSet.getInt("sid"), resultSet.getString("sname"), resultSet.getInt("sex"),resultSet.getInt("class"),resultSet.getString("date")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return students;
	}
	public Student getStudentBySid(Integer sid) {
		Student student = null;
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("select * from student where sid = ?");
			preparedStatement.setInt(1, sid);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {	
				student = new Student(resultSet.getInt("sid"),resultSet.getString("name"),resultSet.getInt("sex"),resultSet.getInt("sid"),resultSet.getString("date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return student;
	}
	
	
	public int addStudent(Student student) {
		
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("insert into student (sname,sex,class,date) values (?,?,?,?)");
			preparedStatement.setString(1, student.getSname());
			preparedStatement.setInt(2, student.getSex());
			preparedStatement.setInt(3, student.getClassid());
			preparedStatement.setString(4,student.getDate());
			res = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return res;
	}
	
	public int updateStudent(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("update student set sname=?,sex=?,class=?,date=? where sid=?");
			preparedStatement.setString(1, student.getSname());
			preparedStatement.setInt(2, student.getSex());
			preparedStatement.setInt(3, student.getClassid());
			preparedStatement.setString(4, student.getDate());
			preparedStatement.setInt(5, student.getSid());
			res = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return res;
	}
	public int deleteStudent(Integer sid) {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet = null;
		int res = 0;
		try {
			connection = JDBCUtils.getConn();
			preparedStatement = connection.prepareStatement("delete from student where sid=?");
			preparedStatement.setInt(1, sid);
			res = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, preparedStatement, connection);
		}
		return res;
	}
	
	
}
