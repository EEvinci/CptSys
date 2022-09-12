package cn.zucc.edu.models;

import java.util.Date;

public class BeanRegister {
	private String TeamId;
	private String CptId;
	private Date RegiTime;
	private String RegiStatus;
	private String AwdGrade;
	
	
	/*
	 *getter and setter 
	 */
	public String getTeamId() {
		return TeamId;
	}
	public void setTeamId(String teamId) {
		TeamId = teamId;
	}
	public String getCptId() {
		return CptId;
	}
	public void setCptId(String cptId) {
		CptId = cptId;
	}
	public Date getRegiTime() {
		return RegiTime;
	}
	public void setRegiTime(Date regiTime) {
		RegiTime = regiTime;
	}
	public String getRegiStatus() {
		return RegiStatus;
	}
	public void setRegiStatus(String regiStatus) {
		RegiStatus = regiStatus;
	}
	public String getAwdGrade() {
		return AwdGrade;
	}
	public void setAwdGrade(String awdGrade) {
		AwdGrade = awdGrade;
	}
	
	
}
