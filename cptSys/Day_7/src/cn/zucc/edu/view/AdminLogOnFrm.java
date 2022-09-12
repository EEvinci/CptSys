package cn.zucc.edu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import cn.zucc.edu.dao.AdminLogDao;
import cn.zucc.edu.models.BeanAdminInfo;
import cn.zucc.edu.models.BeanStuInfo;
import cn.zucc.edu.util.DBUtil;
import cn.zucc.edu.util.StringUtil;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class AdminLogOnFrm extends JFrame {

	private JPanel Reset_1;
	private JTextField AdminNameTxt;
	private JPasswordField AdminPasswordTxt;
	private DBUtil dbUtil = new DBUtil();
	private AdminLogDao adminDao = new AdminLogDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogOnFrm frame = new AdminLogOnFrm();
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
	public AdminLogOnFrm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Reset_1 = new JPanel();
		Reset_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Reset_1);
		
		JLabel lblNewLabel = new JLabel("管理员登录");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("用户名");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 17));
		
		JLabel lblNewLabel_2 = new JLabel("密  码");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 17));
		
		AdminNameTxt = new JTextField();
		AdminNameTxt.setColumns(10);
		
		AdminPasswordTxt = new JPasswordField();
		
		JButton Login = new JButton("登录");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		Login.setFont(new Font("宋体", Font.BOLD, 20));
		Login.setBackground(Color.GRAY);
		
		JButton Reset = new JButton("重置");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		Reset.setFont(new Font("宋体", Font.BOLD, 20));
		Reset.setBackground(Color.GRAY);
		Reset.setForeground(Color.BLACK);
		GroupLayout gl_Reset_1 = new GroupLayout(Reset_1);
		gl_Reset_1.setHorizontalGroup(
			gl_Reset_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Reset_1.createSequentialGroup()
					.addContainerGap(98, Short.MAX_VALUE)
					.addGroup(gl_Reset_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_Reset_1.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_Reset_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_Reset_1.createParallelGroup(Alignment.LEADING)
								.addComponent(AdminPasswordTxt)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addComponent(AdminNameTxt, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
							.addGap(63))
						.addGroup(Alignment.TRAILING, gl_Reset_1.createSequentialGroup()
							.addGap(23)
							.addComponent(Login, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(Reset, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(82))))
		);
		gl_Reset_1.setVerticalGroup(
			gl_Reset_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Reset_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_Reset_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(AdminNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_Reset_1.createParallelGroup(Alignment.LEADING)
						.addComponent(AdminPasswordTxt, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_Reset_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(Reset)
						.addComponent(Login))
					.addGap(24))
		);
		Reset_1.setLayout(gl_Reset_1);
		
		//设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}

	private void loginActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String AdminID = this.AdminNameTxt.getText();
		String Password = this.AdminPasswordTxt.getText();
		if(StringUtil.isEmpty(AdminID)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(Password))
		{
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		BeanAdminInfo stu = new BeanAdminInfo(AdminID,Password);//创建admin对象接收传入的用户名和密码
		Connection conn = null;
		try {
			conn = dbUtil.getConn();
			BeanAdminInfo currentAdmin = AdminLogDao.login(conn, stu);//用admin中的信息和数据库中的用户信息做比照,匹配则会传入信息到currentStu
			if(currentAdmin != null) {
				dispose();
				new AdminMainFrm().setVisible(true);
			}
			else
				JOptionPane.showConfirmDialog(null, "用户名或密码错误!");
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	}

	/**
	 * reset the value of passwordTxt and UserIDTxt 
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.AdminNameTxt.setText("");
		this.AdminPasswordTxt.setText("");
	}
}
