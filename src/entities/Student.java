package entities;

public class Student {
	private int sid;
	private String sname;
	private Integer sex;
	private Integer classid;
	private String date;
	public Student() {

	}
	public Student( String sname, Integer sex, Integer classid, String date) {

		this.sname = sname;
		this.sex = sex;
		this.classid = classid;
		this.date = date;
	}
	public Student(int sid, String sname, Integer sex, Integer classid, String date) {

		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.classid = classid;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sex=" + sex + ", classid=" + classid + ", date=" + date
				+ "]";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getClassid() {
		return classid;
	}
	public void setClassid(Integer classid) {
		this.classid = classid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
