package cn.zucc.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.zucc.edu.models.BeanCptItemInfo;

/**
 * 赛项Dao类
 * @author PC
 *
 */
public class CptItemDao {

/**
 * 赛项添加
 * @param conn
 * @param cptItemInfo
 * @return
 * @throws Excetions
 */
	public int add(Connection conn, BeanCptItemInfo cptItemInfo) throws Exception{
		String sql = "insert into cpt_itm_info values(?,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, cptItemInfo.getCptItemId());
		pstmt.setString(2, cptItemInfo.getCptItemName());
		pstmt.setString(3, cptItemInfo.getResPerson());
		pstmt.setString(4, cptItemInfo.getBelongCol());
		pstmt.setString(5, cptItemInfo.getCptLevel());
	
		return pstmt.executeUpdate();
	}
	

}
