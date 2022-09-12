package cn.zucc.edu.models;

//学生信息表
public class BeanStuInfo {
	private String StuId;
	private String Name;
	private String StuPsw;
	private String SClass;
	private String Grade;
	private String Profess;
	private String PhoneNum;

	
	public BeanStuInfo() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	
	//学生登陆
	public BeanStuInfo(String stuId, String stuPsw) {
		super();
		StuId = stuId;
		StuPsw = stuPsw;
	}

	//学生信息增删改查
	public BeanStuInfo(String stuId, String name, String stuPsw, String sClass, String grade, String profess,
			String phoneNum) {
		super();
		StuId = stuId;
		Name = name;
		StuPsw = stuPsw;
		SClass = sClass;
		Grade = grade;
		Profess = profess;
		PhoneNum = phoneNum;
	}




	/*
	 *getter and setter 
	 */
	public String getStuId() {
		return StuId;
	}

	public void setStuId(String stuId) {
		StuId = stuId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getStuPsw() {
		return StuPsw;
	}

	public void setStuPsw(String stuPsw) {
		StuPsw = stuPsw;
	}

	public String getSClass() {
		return SClass;
	}

	public void setSClass(String sClass) {
		SClass = sClass;
	}

	public String getGrade() {
		return Grade;
	}

	public void setGrade(String grade) {
		Grade = grade;
	}

	public String getProfess() {
		return Profess;
	}

	public void setProfess(String profess) {
		Profess = profess;
	}

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}
	
	
}
