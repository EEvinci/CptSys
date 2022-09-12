package cn.zucc.edu.models;


//队伍信息表
public class BeanTeam {
	private String TeamId;
	private String TeamName;
	private int MemNum;
	private String RwdGrade;
	private String IsFinCpt;
	
	public BeanTeam() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public BeanTeam(String teamId, String teamName, int memNum, String rwdGrade,String isFinCpt) {
		super();
		TeamId = teamId;
		TeamName = teamName;
		MemNum = memNum;
		RwdGrade = rwdGrade;
		IsFinCpt = isFinCpt;
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
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	public int getMemNum() {
		return MemNum;
	}
	public void setMemNum(int memNum) {
		MemNum = memNum;
	}
	public String getRwdGrade() {
		return RwdGrade;
	}
	public void setRwdGrade(String rwdGrade) {
		RwdGrade = rwdGrade;
	}
	public String getIsFinCpt() {
		return IsFinCpt;
	}
	public void setIsFinCpt(String isFinCpt){
		IsFinCpt = isFinCpt;
	}
	
	
}
