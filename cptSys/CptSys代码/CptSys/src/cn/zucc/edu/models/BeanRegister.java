package cn.zucc.edu.models;


//
public class BeanRegister {
	private String TeamId;
	private String CptId;
	private String RegiTime;
	private String RegiStatus;
	private String StuId;
	

	public BeanRegister(String teamId, String cptId, String regiTime, String regiStatus, String stuId) {
		super();
		TeamId = teamId;
		CptId = cptId;
		RegiTime = regiTime;
		RegiStatus = regiStatus;
		StuId = stuId;
	}
	public String getStuId() {
		return StuId;
	}
	public void setStuId(String stuId) {
		StuId = stuId;
	}
	public BeanRegister(String teamId, String cptId, String regiTime, String regiStatus) {
		super();
		TeamId = teamId;
		CptId = cptId;
		RegiTime = regiTime;
		RegiStatus = regiStatus;
	}
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
	public String getRegiTime() {
		return RegiTime;
	}
	public void setRegiTime(String regiTime) {
		RegiTime = regiTime;
	}
	public String getRegiStatus() {
		return RegiStatus;
	}
	public void setRegiStatus(String regiStatus) {
		RegiStatus = regiStatus;
	}
	


	
	
}
