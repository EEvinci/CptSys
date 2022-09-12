package cn.zucc.edu.models;

public class BeanPlayer {
	private String StuId;
	private String CptId;
	private String ItemId;
	
	public BeanPlayer() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public BeanPlayer(String stuId, String cptId, String itemId) {
		super();
		StuId = stuId;
		CptId = cptId;
		ItemId = itemId;
	}
	public String getStuId() {
		return StuId;
	}
	public void setStuId(String stuId) {
		StuId = stuId;
	}
	public String getCptId() {
		return CptId;
	}
	public void setCptId(String cptId) {
		CptId = cptId;
	}
	public String getItemId() {
		return ItemId;
	}
	public void setItemId(String itemId) {
		ItemId = itemId;
	}
	
	
}
