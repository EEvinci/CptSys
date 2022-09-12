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
import javax.swing.JTextField;

import cn.zucc.edu.dao.CptItemDao;
import cn.zucc.edu.util.DBUtil;

public class Ad_CptItemAddInterFrm extends JInternalFrame {
	private JTextField CptItemIdTxt;
	private JTextField CptItemName;
	private JTextField ResPersonTxt;
	private JTextField BelongCol;
	private JTextField CptLevel;
	private DBUtil dbUtil = new DBUtil();
	private CptItemDao cptItemDao = new CptItemDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ad_CptItemAddInterFrm frame = new Ad_CptItemAddInterFrm();
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
	public Ad_CptItemAddInterFrm() {
		setIconifiable(true);
		setResizable(true);
		setClosable(true);
		setTitle("赛项管理");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("赛项编号");
		
		JLabel lblNewLabel_1 = new JLabel("赛项名称");
		
		JLabel lblNewLabel_1_1 = new JLabel("负责老师");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("所属学院");
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("赛项等级");
		
		CptItemIdTxt = new JTextField();
		CptItemIdTxt.setColumns(10);
		
		CptItemName = new JTextField();
		CptItemName.setColumns(10);
		
		ResPersonTxt = new JTextField();
		ResPersonTxt.setColumns(10);
		
		BelongCol = new JTextField();
		BelongCol.setColumns(10);
		
		CptLevel = new JTextField();
		CptLevel.setColumns(10);
		
		JButton Add = new JButton("添加");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				try {
					conn = dbUtil.getConn();
					
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		
		JButton Modify = new JButton("修改");
		
		JButton Reset = new JButton("重置");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(60)
							.addComponent(Add, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Modify, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Reset, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(CptLevel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(BelongCol, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(ResPersonTxt, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(CptItemName, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(CptItemIdTxt, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(CptItemIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(CptItemName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(ResPersonTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1)
						.addComponent(BelongCol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_1_1)
						.addComponent(CptLevel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Modify)
						.addComponent(Reset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Add))
					.addGap(18))
		);
		getContentPane().setLayout(groupLayout);
		
	}
	
	/**
	 * 重置函数
	 * @param evt
	 * 
	 */
	
	private void resetValueActionPerformed(ActionEvent evt) {
		this.CptItemIdTxt.setText("");
		this.CptItemName.setText("");
		this.ResPersonTxt.setText("");
		this.BelongCol.setText("");
		this.CptLevel.setText("");
	}
}
