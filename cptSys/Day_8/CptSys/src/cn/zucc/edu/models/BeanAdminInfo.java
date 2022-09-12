package cn.zucc.edu.models;

public class BeanAdminInfo {
	
	private String AdminId;
	private String Name;
	private String AdPsw;
	
	public BeanAdminInfo() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public BeanAdminInfo(String adminId, String logPsw) {
		super();
		AdminId = adminId;
		AdPsw = logPsw;
	}
	
	/*
	 *getter and setter 
	 */
	public String getAdminId() {
		return AdminId;
	}
	public void setAdminId(String adminId) {
		AdminId = adminId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAdPsw() {
		return AdPsw;
	}
	public void setAdPsw(String logPsw) {
		AdPsw = logPsw;
	}
	
}
