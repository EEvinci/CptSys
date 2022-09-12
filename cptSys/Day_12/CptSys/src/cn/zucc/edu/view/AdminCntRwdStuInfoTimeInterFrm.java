package cn.zucc.edu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.zucc.edu.dao.CptDao;
import cn.zucc.edu.models.BeanStuInfo;
import cn.zucc.edu.models.BeanTeamUp;
import cn.zucc.edu.util.DBUtil;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

public class AdminCntRwdStuInfoTimeInterFrm extends JInternalFrame {
	private JTable table;
	private JTextField stuGradeTxt;
	private JTextField teamIdTxt;

	private DBUtil dbUtil = new DBUtil();
	private CptDao cptDao = new CptDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCntRwdStuInfoTimeInterFrm frame = new AdminCntRwdStuInfoTimeInterFrm();
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
	public AdminCntRwdStuInfoTimeInterFrm() {
		setTitle("特定年级获奖学生信息统计");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1011, 605);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("统计");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuRwdCntActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 24));
		btnNewButton.setBounds(830, 33, 97, 37);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 80, 921, 421);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u83B7\u5956\u6570\u91CF", "\u83B7\u5956\u7B49\u7EA7", "\u5B66\u751F\u59D3\u540D", "\u7ADE\u8D5B\u540D\u79F0", "\u7ADE\u8D5B\u7F16\u53F7", "\u5B66\u53F7", "\u961F\u4F0D\u7F16\u53F7", "\u961F\u4F0D\u540D\u79F0", "\u4E13\u4E1A", "\u5E74\u7EA7", "\u73ED\u7EA7"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel CptHoldYear = new JLabel("年级");
		CptHoldYear.setFont(new Font("宋体", Font.BOLD, 23));
		CptHoldYear.setBounds(105, 38, 54, 27);
		getContentPane().add(CptHoldYear);
		
		stuGradeTxt = new JTextField();
		stuGradeTxt.setColumns(10);
		stuGradeTxt.setBounds(169, 33, 202, 34);
		getContentPane().add(stuGradeTxt);
		
		JLabel CptHoldYear_1 = new JLabel("队伍编号");
		CptHoldYear_1.setFont(new Font("宋体", Font.BOLD, 23));
		CptHoldYear_1.setBounds(424, 38, 97, 27);
		getContentPane().add(CptHoldYear_1);
		
		teamIdTxt = new JTextField();
		teamIdTxt.setColumns(10);
		teamIdTxt.setBounds(531, 33, 202, 34);
		getContentPane().add(teamIdTxt);

		this.fillTable(new BeanStuInfo(),new BeanTeamUp());
	}
	
	/**
	 * 特定年级获奖学生信息统计
	 * @param e
	 */
	private void StuRwdCntActionPerformed(ActionEvent e) {
		String stuGrade = this.stuGradeTxt.getText();
		String teamId = this.teamIdTxt.getText();
		BeanStuInfo stu = new BeanStuInfo();
		BeanTeamUp teamup = new BeanTeamUp();
		stu.setGrade(stuGrade);
		teamup.setTeamId(teamId);
		this.fillTable(stu,teamup);
	}
	
	
	
	/**
	 * 获奖学生信息显示填充表格
	 * @param cptInfo
	 */
	private void fillTable(BeanStuInfo stuInfo,BeanTeamUp teamup) {
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0); //清空表格
		
		Connection conn = null;
		try {
			conn = dbUtil.getConn();
			ResultSet rs = cptDao.queryRwdStuCpt(conn,stuInfo,teamup);
			while(rs.next())
			{
				Vector v = new Vector();
				
				v.add(rs.getString("RwdNum"));
				v.add(rs.getString("RwdGrade"));
				v.add(rs.getString("Name"));
				v.add(rs.getString("CptName"));
				v.add(rs.getString("CptId"));
				v.add(rs.getString("StuId"));
				v.add(rs.getString("TeamId"));
				v.add(rs.getString("TeamName"));
				v.add(rs.getString("Profess"));
				v.add(rs.getString("Grade"));
				v.add(rs.getString("SClass"));
				
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
