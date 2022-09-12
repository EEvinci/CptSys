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

import cn.zucc.edu.dao.CptDao;
import cn.zucc.edu.models.BeanCptInfo;
import cn.zucc.edu.util.DBUtil;
import cn.zucc.edu.util.StringUtil;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminCptAddInterFrm extends JInternalFrame {
	private JTextField CptIdTxt;
	private JTextField CptNameTxt;
	private JTextField HoldYearTxt;
	private JTextField RegiTimeTxt;
	private JTextField ContactTxt;
	private JTextField WebTxt;
	private JTextField RegiEnd;
	private JTextField HoldDayTxt;
	private JTextField CptYearTxt;
	private JTextField CptItemIdTxt;

	
	private DBUtil dbUtil = new DBUtil();
	private CptDao cptDao = new CptDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCptAddInterFrm frame = new AdminCptAddInterFrm();
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
	public AdminCptAddInterFrm() {
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("竞赛编号");
		
		JLabel lblNewLabel_1 = new JLabel("竞赛名称");
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		JLabel lblNewLabel_4 = new JLabel("联系老师");
		
		JLabel lblNewLabel_3 = new JLabel("开始报名时间");
		
		JLabel lblNewLabel_10 = new JLabel("举办年份");
		
		CptIdTxt = new JTextField();
		CptIdTxt.setColumns(10);
		
		CptNameTxt = new JTextField();
		CptNameTxt.setColumns(10);
		
		HoldYearTxt = new JTextField();
		HoldYearTxt.setColumns(10);
		
		RegiTimeTxt = new JTextField();
		RegiTimeTxt.setColumns(10);
		
		ContactTxt = new JTextField();
		ContactTxt.setColumns(10);
		
		JButton AddTxt = new JButton("添加");
		AddTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CptAddActionPerformed(e);
			}
		});
		
		JButton ResetTxt = new JButton("重置");
		ResetTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_9 = new JLabel("竞赛官网");
		
		WebTxt = new JTextField();
		WebTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("结束报名时间");
		
		RegiEnd = new JTextField();
		RegiEnd.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("举办日期");
		
		HoldDayTxt = new JTextField();
		HoldDayTxt.setColumns(10);
		
		JLabel CptYearTxr = new JLabel("竞赛期届");
		
		CptYearTxt = new JTextField();
		CptYearTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("赛项编号");
		
		CptItemIdTxt = new JTextField();
		CptItemIdTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(CptIdTxt, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(CptItemIdTxt, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(CptNameTxt, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(CptYearTxr, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(CptYearTxt, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(HoldYearTxt, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(HoldDayTxt, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(76)
							.addComponent(AddTxt, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(ResetTxt, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(ContactTxt, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(RegiTimeTxt, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(54)
									.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(RegiEnd, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addGap(48)
									.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(WebTxt, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addComponent(CptIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_5))
						.addComponent(CptItemIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(CptNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(CptYearTxr))
						.addComponent(CptYearTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(lblNewLabel_10))
						.addComponent(HoldYearTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_7))
						.addComponent(HoldDayTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3)
							.addComponent(RegiTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_8)
							.addComponent(RegiEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(ContactTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_9))
						.addComponent(WebTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(AddTxt)
						.addComponent(ResetTxt))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 添加竞赛信息函数
	 * @param evt
	 */
	private void CptAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String cptId = this.CptIdTxt.getText();
		String cptItemId = this.CptNameTxt.getText();
		String cptName = this.HoldYearTxt.getText();
		String cptYear = this.RegiTimeTxt.getText();
		String holdYear = this.ContactTxt.getText();
		String holdDay = this.WebTxt.getText();
		String regiStart = this.RegiEnd.getText();
		String regiEnd = this.HoldDayTxt.getText();
		String contact = this.CptYearTxt.getText();
		String web = this.CptItemIdTxt.getText();
		
		
		if(StringUtil.isEmpty(cptId) || StringUtil.isEmpty(cptItemId) || StringUtil.isEmpty(cptName) 
				|| StringUtil.isEmpty(cptYear) || StringUtil.isEmpty(holdYear) || StringUtil.isEmpty(holdDay) 
				|| StringUtil.isEmpty(regiStart) || StringUtil.isEmpty(regiEnd) || StringUtil.isEmpty(contact) 
				|| StringUtil.isEmpty(web)){
			JOptionPane.showMessageDialog(null, "请将竞赛信息填写完整");
			return;
		}
		BeanCptInfo cptInfo = new BeanCptInfo(cptId,cptItemId,cptName,cptYear,holdYear,holdDay,regiStart,regiEnd,contact,web);
		Connection conn = null;
		try{
			conn = dbUtil.getConn();
			int n = cptDao.add(conn,cptInfo);
			if(n == 1) {
				JOptionPane.showMessageDialog(null, "竞赛信息添加成功");
			}
			else {
				JOptionPane.showMessageDialog(null, "竞赛信息添加失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "竞赛信息添加失败");
			}finally {
				try {
					dbUtil.closeConn(conn);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	/**
	 * 重置函数
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		this.CptIdTxt.setText("");
		this.CptNameTxt.setText("");
		this.HoldYearTxt.setText("");
		this.RegiTimeTxt.setText("");
		this.ContactTxt.setText("");
		this.WebTxt.setText("");
		this.RegiEnd.setText("");
		this.HoldDayTxt.setText("");
		this.CptYearTxt.setText("");
		this.CptItemIdTxt.setText("");
		
	}
}
