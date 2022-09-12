package cn.zucc.edu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import cn.zucc.edu.dao.CptDao;
import cn.zucc.edu.models.BeanCptInfo;
import cn.zucc.edu.util.DBUtil;
import java.awt.event.ActionListener;

public class AdminQueryCptRegiInterFrm extends JInternalFrame {
	private JTable table;
	private JTextField CptItemNameTxt;
	private JTextField CptHoldYearTxt;

	private DBUtil dbUtil = new DBUtil();
	private CptDao cptDao = new CptDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminQueryCptRegiInterFrm frame = new AdminQueryCptRegiInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminQueryCptRegiInterFrm() {
		setTitle("竞赛报名信息查询");
		setClosable(true);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 1000, 600);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 100, 921, 421);
		
		JLabel lblNewLabel = new JLabel("竞赛名称");
		lblNewLabel.setBounds(54, 36, 111, 27);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 23));
		
		CptItemNameTxt = new JTextField();
		CptItemNameTxt.setBounds(165, 31, 202, 34);
		CptItemNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CptRegiInfoSearchActionPerformed(e);
			}
		});
		btnNewButton.setBounds(815, 31, 97, 37);
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 24));
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6240\u5C5E\u8D5B\u9879", "\u7ADE\u8D5B\u540D\u79F0", "\u5B66\u751F\u59D3\u540D", "\u5B66\u53F7", "\u62A5\u540D\u72B6\u6001", "\u62A5\u540D\u65F6\u95F4", "\u961F\u4F0D\u7F16\u53F7", "\u4E13\u4E1A", "\u5E74\u7EA7", "\u73ED\u7EA7"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().add(scrollPane);
		getContentPane().add(lblNewLabel);
		getContentPane().add(CptItemNameTxt);
		getContentPane().add(btnNewButton);
		
		JLabel CptHoldYear = new JLabel("举行年份");
		CptHoldYear.setFont(new Font("宋体", Font.BOLD, 23));
		CptHoldYear.setBounds(429, 36, 111, 27);
		getContentPane().add(CptHoldYear);
		
		CptHoldYearTxt = new JTextField();
		CptHoldYearTxt.setColumns(10);
		CptHoldYearTxt.setBounds(540, 31, 202, 34);
		getContentPane().add(CptHoldYearTxt);

		this.fillTable(new BeanCptInfo());//将表中的信息传入到表格中
	}
	
	
	/**
	 * 竞赛报名信息查询
	 * @param e
	 */
	private void CptRegiInfoSearchActionPerformed(ActionEvent e) {
		String cptName = this.CptItemNameTxt.getText();
		String cptHoldyear = this.CptHoldYearTxt.getText();
		BeanCptInfo cptInfo = new BeanCptInfo();
		cptInfo.setCptName(cptName);
		cptInfo.setHoldYear(cptHoldyear);
		this.fillTable(cptInfo);
	}
	
	
	
	/**
	 * 竞赛报名信息显示填充表格
	 * @param cptInfo
	 */
	private void fillTable(BeanCptInfo cptInfo) {
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0); //清空表格
		
		Connection conn = null;
		try {
			conn = dbUtil.getConn();
			ResultSet rs = cptDao.queryCptRegi(conn,cptInfo);
			while(rs.next())
			{
				Vector v = new Vector();
				
				//从查询结果中提取CptItemName属性填入到队列v中，这里的顺序和sql查询语句中属性的顺序可以不一样，只要属性对照即可
				v.add(rs.getString("CptItemName"));
				v.add(rs.getString("CptName"));
				v.add(rs.getString("StuId"));
				v.add(rs.getString("Name"));
				v.add(rs.getString("RegiStatus"));
				v.add(rs.getString("RegiTime"));
				v.add(rs.getString("TeamId"));
				v.add(rs.getString("Profess"));
				v.add(rs.getString("Grade"));
				v.add(rs.getString("SClass"));

				//将队列v添加到表格的行中
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
