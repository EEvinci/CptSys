package cn.zucc.edu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.zucc.edu.dao.CptDao;
import cn.zucc.edu.dao.StuDao;
import cn.zucc.edu.models.BeanCptInfo;
import cn.zucc.edu.models.BeanStuInfo;
import cn.zucc.edu.models.BeanTeamUp;
import cn.zucc.edu.util.DBUtil;

public class AdminCntRwdStuInfoTimeInterFrm extends JInternalFrame {
	private JTable table;
	private JTextField stuProTxt;

	private DBUtil dbUtil = new DBUtil();
	private StuDao stuDao = new StuDao();
	private JTextField timeTxt;
	
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
				"\u83B7\u5956\u6570\u91CF", "\u83B7\u5956\u7B49\u7EA7", "\u5B66\u751F\u59D3\u540D", "\u5B66\u53F7", "\u4E13\u4E1A", "\u5E74\u7EA7", "\u73ED\u7EA7"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel CptHoldYear_1 = new JLabel("专业");
		CptHoldYear_1.setFont(new Font("宋体", Font.BOLD, 23));
		CptHoldYear_1.setBounds(592, 38, 47, 27);
		getContentPane().add(CptHoldYear_1);
		
		stuProTxt = new JTextField();
		stuProTxt.setColumns(10);
		stuProTxt.setBounds(649, 33, 155, 34);
		getContentPane().add(stuProTxt);
		
		timeTxt = new JTextField();
		timeTxt.setColumns(10);
		timeTxt.setBounds(204, 33, 120, 34);
		getContentPane().add(timeTxt);
		
		JLabel lblNewLabel_1 = new JLabel("时间");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(150, 39, 83, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("请以yyyy-MM-dd格式进行填写");
		lblNewLabel.setBounds(334, 47, 168, 15);
		getContentPane().add(lblNewLabel);

		this.fillTable(new BeanStuInfo(),new BeanCptInfo());
	}
	
	/**
	 * 特定年级获奖学生信息统计
	 * @param e
	 */
	private void StuRwdCntActionPerformed(ActionEvent e) {
		String time = this.timeTxt.getText();
		String stuPro = this.stuProTxt.getText();
		BeanStuInfo stu = new BeanStuInfo();
		BeanCptInfo cpt = new BeanCptInfo();
		stu.setProfess(stuPro);
		cpt.setHoldDay(time);
		this.fillTable(stu,cpt);
	}
	
	
	
	/**
	 * 获奖学生信息显示填充表格
	 * @param cptInfo
	 */
	private void fillTable(BeanStuInfo stuInfo,BeanCptInfo cpt) {
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0); //清空表格
		
		Connection conn = null;
		try {
			conn = dbUtil.getConn();
			ResultSet rs = stuDao.cntRwdStuCpt(conn,stuInfo,cpt);
			while(rs.next())
			{
				Vector v = new Vector();
				
				v.add(rs.getString("RwdNum"));
				v.add(rs.getString("RwdGrade"));
				v.add(rs.getString("Name"));
				v.add(rs.getString("StuId"));
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
