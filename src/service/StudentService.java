package service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import dao.StudentDao;
import entities.Classinfo;
import entities.Student;

public class StudentService {
	StudentDao studentDao = new StudentDao();
	
	
	public String getAllStudents() {
		return JSON.toJSONString(studentDao.getAllStudents());
	}
	public String getStudentsBySidORSname(String idOrName) {
		return JSON.toJSONString(studentDao.getStudentsBySidORSname(idOrName));
	}
	public String getStudentsByClassId(Integer classid) {
		return JSON.toJSONString(studentDao.getStudentByClassid(classid));
	}
	
	
	
	public JSONObject addStudent(Student student) {
		JSONObject res = new JSONObject();
		int stats = studentDao.addStudent(student);
		res.put("status", stats);
		res.put("info", stats==1?"添加成功！":"添加失败!");
		return res;
		
	}
	
	public JSONObject updateClass(Student student) {
		JSONObject res = new JSONObject();
		int status = studentDao.updateStudent(student);
		res.put("status", status);
		res.put("info", status==1?"修改成功!":"修改失败!");
		return res;
	}
	
	public JSONObject deleteClass(Integer sid) {
		JSONObject res = new JSONObject();
		int status = studentDao.deleteStudent(sid);
		res.put("status", status);
		res.put("info", status==1?"修改成功!":"修改失败!");
		return res;
	}
}
