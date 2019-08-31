package entities;

public class Classinfo {
	private Integer id;
	private String classname;
	private String subject;
	private String dept;

	public Classinfo() {

	}

	@Override
	public String toString() {
		return "Classinfo [id=" + id + ", classname=" + classname + ", subject=" + subject + ", dept=" + dept + "]";
	}

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Classinfo(String classname, String subject, String dept) {
		this.classname = classname;
		this.subject = subject;
		this.dept = dept;
	}

	public Classinfo(Integer id, String classname, String subject, String dept) {

		this.id = id;
		this.classname = classname;
		this.subject = subject;
		this.dept = dept;
	}




	
}
