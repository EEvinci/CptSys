package cn.zucc.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zucc.edu.models.BeanAdminInfo;

/**
 * 管理员登录信息管理
 * @author PC
 *
 */
public class AdminLogDao {
	public static BeanAdminInfo login(Connection conn, BeanAdminInfo admin) throws Exception {
		// TODO 自动生成的方法存根
		BeanAdminInfo resultAdmin = null;
		String sql = "select AdminId,AdPsw from admininfo where AdminId=? and AdPsw=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, admin.getAdminId());
		pstmt.setString(2, admin.getAdPsw());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
		{
			resultAdmin = new BeanAdminInfo();
			resultAdmin.setAdminId("id");
			resultAdmin.setAdPsw("password");
		}
		return resultAdmin;
	}

}
