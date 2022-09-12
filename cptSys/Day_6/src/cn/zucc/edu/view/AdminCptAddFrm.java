package cn.zucc.edu.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import cn.zucc.edu.dao.CptDao;
import cn.zucc.edu.models.BeanCptInfo;
import cn.zucc.edu.util.DBUtil;
import cn.zucc.edu.util.StringUtil;

public class AdminCptAddFrm extends JFrame {

	private JPanel contentPane;
	private JTextField CptIdTxt;
	private JTextField CptItemIdTxt;
	private JTextField CptNameTxt;
	private JTextField CptYearTxt;
	private JTextField HoldYearTxt;
	private JTextField HoldDayTxt;
	private JTextField RegiStartTxt;
	private JTextField RegiEndTxt;
	private JTextField ContactTxt;
	private JTextField WebTxt;

	private DBUtil dbUtil = new DBUtil();
	private CptDao cptDao = new CptDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCptAddFrm frame = new AdminCptAddFrm();
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
	public AdminCptAddFrm() {
		setResizable(false);
		setAutoRequestFocus(false);
		setTitle("添加竞赛信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("竞赛编号");
		
		JLabel lblNewLabel_1 = new JLabel("竞赛名称");
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		JLabel lblNewLabel_3 = new JLabel("开始报名时间");
		
		JLabel lblNewLabel_4 = new JLabel("联系老师");
		
		JLabel lblNewLabel_5 = new JLabel("赛项编号");
		
		JLabel CptYearTxr = new JLabel("竞赛期届");
		
		JLabel lblNewLabel_7 = new JLabel("举办日期");
		
		JLabel lblNewLabel_8 = new JLabel("结束报名时间");
		
		JLabel lblNewLabel_9 = new JLabel("竞赛官网");
		
		CptIdTxt = new JTextField();
		CptIdTxt.setColumns(10);
		
		CptItemIdTxt = new JTextField();
		CptItemIdTxt.setColumns(10);
		
		CptNameTxt = new JTextField();
		CptNameTxt.setColumns(10);
		
		CptYearTxt = new JTextField();
		CptYearTxt.setColumns(10);
		
		HoldYearTxt = new JTextField();
		HoldYearTxt.setColumns(10);
		
		HoldDayTxt = new JTextField();
		HoldDayTxt.setColumns(10);
		
		RegiStartTxt = new JTextField();
		RegiStartTxt.setColumns(10);
		
		RegiEndTxt = new JTextField();
		RegiEndTxt.setColumns(10);
		
		ContactTxt = new JTextField();
		ContactTxt.setColumns(10);
		
		WebTxt = new JTextField();
		WebTxt.setColumns(10);
		
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
		
		JLabel lblNewLabel_10 = new JLabel("举办年份");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(CptIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CptNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(HoldYearTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(RegiStartTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ContactTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(AddTxt, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(ResetTxt, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(WebTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(RegiEndTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(HoldDayTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(CptYearTxr, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(CptYearTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(CptItemIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_5)
						.addComponent(CptIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CptItemIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(CptYearTxr)
						.addComponent(CptNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CptYearTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_7)
						.addComponent(HoldYearTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(HoldDayTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_8))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_9)
								.addComponent(ContactTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(RegiEndTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(RegiStartTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(WebTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(AddTxt)
						.addComponent(ResetTxt))
					.addGap(18))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}


	/**
	 * 竞赛重置函数
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		this.CptIdTxt.setText("");
		this.CptItemIdTxt.setText("");
		this.CptNameTxt.setText("");
		this.CptYearTxt.setText("");
		this.HoldYearTxt.setText("");
		this.HoldDayTxt.setText("");
		this.RegiStartTxt.setText("");
		this.RegiEndTxt.setText("");
		this.ContactTxt.setText("");
		this.WebTxt.setText("");
	}

	
	/**
	 * 竞赛信息添加函数
	 * @param evt
	 */
	private void CptAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String cptId = this.CptIdTxt.getText();
		String cptItemId = this.CptItemIdTxt.getText();
		String cptName = this.CptNameTxt.getText();
		String cptYear = this.CptYearTxt.getText();
		String holdYear = this.HoldYearTxt.getText();
		String holdDay = this.HoldDayTxt.getText();
		String regiStart = this.RegiStartTxt.getText();
		String regiEnd = this.RegiEndTxt.getText();
		String contact = this.ContactTxt.getText();
		String web = this.WebTxt.getText();
		
		
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
	
}
