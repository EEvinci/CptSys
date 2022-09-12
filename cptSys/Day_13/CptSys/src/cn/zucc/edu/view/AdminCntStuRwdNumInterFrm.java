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

import cn.zucc.edu.dao.StuDao;
import cn.zucc.edu.models.BeanCptInfo;
import cn.zucc.edu.models.BeanStuInfo;
import cn.zucc.edu.util.DBUtil;

public class AdminCntStuRwdNumInterFrm extends JInternalFrame {
	private JTextField cptHoldTxt;
	private JTextField professTxt;
	private JTable table;

	private DBUtil dbUtil = new DBUtil();
	private StuDao stuDao = new StuDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCntStuRwdNumInterFrm frame = new AdminCntStuRwdNumInterFrm();
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
	public AdminCntStuRwdNumInterFrm() {
		setTitle("学生获奖数量统计");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 1002, 600);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 99, 921, 421);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u83B7\u5956\u6570\u91CF", "\u5B66\u751F\u59D3\u540D", "\u5B66\u53F7", "\u4E13\u4E1A", "\u5E74\u7EA7", "\u73ED\u7EA7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("统计");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuRwdCntActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 24));
		btnNewButton.setBounds(796, 29, 97, 37);
		getContentPane().add(btnNewButton);
		
		JLabel CptHoldYear = new JLabel("竞赛举行时间");
		CptHoldYear.setFont(new Font("宋体", Font.BOLD, 23));
		CptHoldYear.setBounds(47, 34, 142, 27);
		getContentPane().add(CptHoldYear);
		
		cptHoldTxt = new JTextField();
		cptHoldTxt.setColumns(10);
		cptHoldTxt.setBounds(199, 29, 202, 34);
		getContentPane().add(cptHoldTxt);
		
		JLabel CptHoldYear_1 = new JLabel("专业");
		CptHoldYear_1.setFont(new Font("宋体", Font.BOLD, 23));
		CptHoldYear_1.setBounds(450, 34, 54, 27);
		getContentPane().add(CptHoldYear_1);
		
		professTxt = new JTextField();
		professTxt.setColumns(10);
		professTxt.setBounds(514, 29, 202, 34);
		getContentPane().add(professTxt);
		
		JLabel lblNewLabel = new JLabel("请以yyyy-MM-dd格式填写");
		lblNewLabel.setBounds(209, 73, 147, 15);
		getContentPane().add(lblNewLabel);

		this.fillTable(new BeanStuInfo(),new BeanCptInfo());
	}
	
	
	/**
	 * 学生获奖数量统计
	 * @param e
	 */
	private void StuRwdCntActionPerformed(ActionEvent e) {
		String cptHold = this.cptHoldTxt.getText();
		String profess = this.professTxt.getText();
		BeanStuInfo stu = new BeanStuInfo();
		BeanCptInfo cpt = new BeanCptInfo();
		
		stu.setProfess(profess);
		cpt.setHoldDay(cptHold);
		
		this.fillTable(stu,cpt);
	}
	
	
	
	/**
	 * 竞赛报名信息显示填充表格
	 * @param cptInfo
	 */
	private void fillTable(BeanStuInfo stu,BeanCptInfo cpt) {
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0); //清空表格
		
		Connection conn = null;
		try {
			conn = dbUtil.getConn();
			ResultSet rs = stuDao.queryRwdStuCpt(conn,stu,cpt);
			while(rs.next())
			{
				Vector v = new Vector();
				
				v.add(rs.getString("RwdNum"));
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