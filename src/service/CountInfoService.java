package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import dao.ClassDao;
import dao.CountInfoDao;
import entities.Classinfo;

public class CountInfoService {

	ClassDao classDao = new ClassDao();
	CountInfoDao countInfoDao = new CountInfoDao();
	public JSONObject getAllCountData(HashSet<String> AllDeptsSet) {
		JSONObject res = new JSONObject();
		//所有班级数量
		res.put("AllClassesNum", countInfoDao.countAllClasses());
		//所有学生数量
		res.put("AllStudentsNum", countInfoDao.countAllStudents());
		//所有系别数量
		res.put("AllDeptsNum", countInfoDao.countAllDepts());
		//按系别查询班级数量  按系别查询学生数量
		HashMap deptClassMap = new HashMap<>();
		HashMap deptStudentMap = new HashMap<>();
		for (String dept:AllDeptsSet) {
			deptClassMap.put(dept, countInfoDao.countClassesByDepts(dept));
			deptStudentMap.put(dept, countInfoDao.countStudentsByDepts(dept));
		}
		res.put("deptClassNum",deptClassMap);
		res.put("deptStudentNum",deptStudentMap);
		//根据班级查询学生数量
		HashMap classStudentMap = new HashMap<>();
		HashMap classDeptMap = new HashMap<>();
		List<Classinfo> classeslist = classDao.getAllClasses();
		for(Classinfo classinfo : classeslist) {
			classStudentMap.put(classinfo.getClassname(), countInfoDao.countStudentsByClass(classinfo.getId()));
			classDeptMap.put(classinfo.getClassname(),classinfo.getDept());
		}
		res.put("classStudentMap",classStudentMap);
		res.put("classDeptMap", classDeptMap);
		return res;
	}
	
}
