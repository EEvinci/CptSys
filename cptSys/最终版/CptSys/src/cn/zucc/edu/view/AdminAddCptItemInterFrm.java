package cn.zucc.edu.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.zucc.edu.dao.AdminLogDao;
import cn.zucc.edu.dao.CptItemDao;
import cn.zucc.edu.models.BeanCptItemInfo;
import cn.zucc.edu.util.DBUtil;
import cn.zucc.edu.util.StringUtil;

public class AdminAddCptItemInterFrm extends JInternalFrame {
	private JTextField CptItemIdTxt;
	private JTextField CptItemNameTxt;
	private JTextField ResPersonTxt;
	private JTextField BelongColTxt;
	private JTextField CptLevelTxt;

	
	private DBUtil dbUtil = new DBUtil();
	private CptItemDao cptItemDao = new CptItemDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddCptItemInterFrm frame = new AdminAddCptItemInterFrm();
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
	public AdminAddCptItemInterFrm() {
		setMaximizable(true);
		setClosable(true);
		setTitle("赛项添加");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("赛项编号");
		
		JLabel lblNewLabel_1 = new JLabel("赛项名称");
		
		JLabel lblNewLabel_2 = new JLabel("负责老师");
		
		JLabel lblNewLabel_3 = new JLabel("所属学院");
		
		JLabel lblNewLabel_4 = new JLabel("赛项级别");
		
		CptItemIdTxt = new JTextField();
		CptItemIdTxt.setColumns(10);
		
		CptItemNameTxt = new JTextField();
		CptItemNameTxt.setColumns(10);
		
		ResPersonTxt = new JTextField();
		ResPersonTxt.setColumns(10);
		
		BelongColTxt = new JTextField();
		BelongColTxt.setColumns(10);
		
		CptLevelTxt = new JTextField();
		CptLevelTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CptItemAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(CptLevelTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(BelongColTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(ResPersonTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(CptItemNameTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(CptItemIdTxt, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(CptItemIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(CptItemNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(ResPersonTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(BelongColTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(CptLevelTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 重置功能
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.CptItemIdTxt.setText("");
		this.CptItemNameTxt.setText("");
		this.ResPersonTxt.setText("");
		this.BelongColTxt.setText("");
		this.CptLevelTxt.setText("");
	}
	
	/**
	 * 赛项添加功能
	 * @param evt
	 */
	private void CptItemAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String cptItemId = this.CptItemIdTxt.getText();
		String cptItemName = this.CptItemNameTxt.getText();
		String resPerson = this.ResPersonTxt.getText();
		String belongCol = this.BelongColTxt.getText();
		String cptLevel = this.CptLevelTxt.getText();
		if(StringUtil.isEmpty(cptItemId) || StringUtil.isEmpty(cptItemName) || StringUtil.isEmpty(resPerson) 
				|| StringUtil.isEmpty(belongCol) || StringUtil.isEmpty(cptLevel)){
			JOptionPane.showMessageDialog(null, "请将赛项信息填写完整");
			return;
		}
		BeanCptItemInfo cptItemInfo = new BeanCptItemInfo(cptItemId,cptItemName,resPerson,belongCol,cptLevel);
		Connection conn = null;
		try{
			conn = dbUtil.getConn();
			int n = cptItemDao.add(conn,cptItemInfo);
			if(n == 1) {
				JOptionPane.showMessageDialog(null, "赛项信息添加成功");
			}
			else {
				JOptionPane.showMessageDialog(null, "赛项信息添加失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "赛项信息重复");
		}finally {
			try {
				dbUtil.closeConn(conn);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
