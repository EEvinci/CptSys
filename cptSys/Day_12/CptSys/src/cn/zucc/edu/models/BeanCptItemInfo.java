package cn.zucc.edu.models;

public class BeanCptItemInfo {
	private String CptItemId;
	private String CptItemName;
	private String ResPerson;
	private String BelongCol;
	private String CptLevel;
	
	public BeanCptItemInfo(String cptItemId, String cptItemName, String resPerson, String belongCol, String cptLevel) {
		super();
		CptItemId = cptItemId;
		CptItemName = cptItemName;
		ResPerson = resPerson;
		BelongCol = belongCol;
		CptLevel = cptLevel;
	}
	
	public BeanCptItemInfo() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	/*
	 *getter and setter 
	 */
	public String getCptItemId() {
		return CptItemId;
	}
	public void setCptItemId(String cptItemId) {
		CptItemId = cptItemId;
	}
	public String getCptItemName() {
		return CptItemName;
	}
	public void setCptItemName(String cptItemName) {
		CptItemName = cptItemName;
	}
	public String getResPerson() {
		return ResPerson;
	}
	public void setResPerson(String resPerson) {
		ResPerson = resPerson;
	}
	public String getBelongCol() {
		return BelongCol;
	}
	public void setBelongCol(String belongCol) {
		BelongCol = belongCol;
	}
	public String getCptLevel() {
		return CptLevel;
	}
	public void setCptLevel(String cptLevel) {
		CptLevel = cptLevel;
	}



	
}
