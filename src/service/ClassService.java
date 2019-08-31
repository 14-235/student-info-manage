package service;



import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import dao.ClassDao;
import entities.Classinfo;

public class ClassService {
	
	ClassDao classDao = new ClassDao();
	
	
	public JSONObject getAllClasses() {
		classDao.getAllClasses();
		JSONObject res = new JSONObject();
		res.put("classes", classDao.getAllClasses());
		res.put("depts", classDao.getAllDepts());
		return res;
		
	}
	
	public JSONObject addClass(Classinfo classInfo) {
		JSONObject res = new JSONObject();
		if(classDao.getClassByName(classInfo.getClassname())==null) {
			int status = classDao.addClass(classInfo);
			res.put("status", status);
			res.put("info", status==1?"添加成功!":"添加失败!");
		} else {
			res.put("status", 0);
			res.put("info", "该班级名称已经存在！");
		}
		
		return res;
	}
	
	public JSONObject updateClass(Classinfo classInfo) {
		JSONObject res = new JSONObject();
		

		int status = classDao.updateClass(classInfo);
		res.put("status", status);
		res.put("info", status==1?"修改成功!":"修改失败!");
	


		
		return res;
	}
	
	public JSONObject deleteClass(Integer id) {
		JSONObject res = new JSONObject();
		int status = classDao.deleteClass(id);
		res.put("status", status);
		res.put("info", status==1?"修改成功!":"修改失败!");
		return res;
	}
}
