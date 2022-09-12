package cn.zucc.edu.models;

//组队信息表
public class BeanTeamUp {
	private String StuId;
	private String StuName;
	private String TeamId;
	private String TeamName;
	private String CptId;
	private String IsLeader;
	private String IsPtcpt;
	
	public BeanTeamUp() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public void setIsPtcpt(String isPtcpt) {
		IsPtcpt = isPtcpt;
	}
	
	public BeanTeamUp(String stuId, String stuName, String teamId, String teamName, String cptId,String isLeader, String isPtcpt) {
		super();
		StuId = stuId;
		StuName = stuName;
		TeamId = teamId;
		TeamName = teamName;
		CptId = cptId;
		IsLeader = isLeader;
		IsPtcpt = isPtcpt;
	}

	/*
	 * getter and setter
	 */

	public String getStuId() {
		return StuId;
	}
	public void setStuId(String stuId) {
		StuId = stuId;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public String getTeamId() {
		return TeamId;
	}
	public void setTeamId(String teamId) {
		TeamId = teamId;
	}
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	public String getCptId() {
		return CptId;
	}
	public void setCptId(String cptId) {
		CptId = cptId;
	}
	public String getIsLeader() {
		return IsLeader;
	}
	public void setIsLeader(String isLeader) {
		IsLeader = isLeader;
	}
	public BeanTeamUp(String isPtcpt) {
		super();
		IsPtcpt = isPtcpt;
	}

	public String getIsPtcpt() {
		return IsPtcpt;
	}
	
	

	
	
}
