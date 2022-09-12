package cn.zucc.edu.models;

//组队信息表
public class BeanTeamUp {
	private String StuId;
	private String TeamId;
	private String IsLeader;
	private String IsPtcpt;
	
	/*
	 *getter and setter 
	 */
	public String getStuId() {
		return StuId;
	}
	public void setStuId(String stuId) {
		StuId = stuId;
	}
	public String getTeamId() {
		return TeamId;
	}
	public void setTeamId(String teamId) {
		TeamId = teamId;
	}
	public String getIsLeader() {
		return IsLeader;
	}
	public void setIsLeader(String isLeader) {
		IsLeader = isLeader;
	}
	public String getIsPtcpt() {
		return IsPtcpt;
	}
	public void setIsPtcpt(String isPtcpt) {
		IsPtcpt = isPtcpt;
	}
	
	
}
