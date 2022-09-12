package cn.zucc.edu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import cn.zucc.edu.dao.StuLogDao;
import cn.zucc.edu.models.BeanStuInfo;
import cn.zucc.edu.util.DBUtil;
import cn.zucc.edu.util.StringUtil;
import javax.swing.JPasswordField;

public class StuLogOnFrm_1 extends JFrame {

	private JPanel contentPane;
	
	private JTextField UserIDTxt;
	private JPasswordField PassWordTxt;
	
	private DBUtil dbUtil = new DBUtil();
	private StuLogDao stuLogDao = new StuLogDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuLogOnFrm_1 frame = new StuLogOnFrm_1();
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
	public StuLogOnFrm_1() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel CptRegiSys = new JLabel("竞赛报名系统");
		CptRegiSys.setFont(new Font("宋体", Font.BOLD, 23));
		CptRegiSys.setIcon(new ImageIcon(StuLogOnFrm_1.class.getResource("/cn/zucc/edu/images/2542800.png")));
		
		JLabel id = new JLabel("用户名");
		id.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel pwd = new JLabel("密  码");
		pwd.setFont(new Font("宋体", Font.BOLD, 18));
		
		UserIDTxt = new JTextField();
		UserIDTxt.setColumns(10);
		
		JButton Login = new JButton("登录");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		JButton Reset = new JButton("重置");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		PassWordTxt = new JPasswordField();
		
		JButton AdminLogin = new JButton("管理员登录");
		/*
		 * 显示管理员登陆界面 
		 */
		AdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogOnFrm adLogOnFrm = new AdminLogOnFrm();
				adLogOnFrm.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Login, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Reset, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(AdminLogin, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(pwd, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(id))
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(PassWordTxt)
								.addComponent(UserIDTxt, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
							.addGap(9))
						.addComponent(CptRegiSys, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(CptRegiSys, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(id)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(pwd))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(UserIDTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(PassWordTxt, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Login)
						.addComponent(Reset)
						.addComponent(AdminLogin))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}

	
	/**
	 * 登录事件处理
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String StuID = this.UserIDTxt.getText();
		String Password = this.PassWordTxt.getText();
		if(StringUtil.isEmpty(StuID)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(Password))
		{
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		BeanStuInfo stu = new BeanStuInfo(StuID,Password);//创建stu对象接收传入的用户名和密码
		Connection conn = null;
		try {
			conn = dbUtil.getConn();
			BeanStuInfo currentStu = stuLogDao.login(conn, stu);//用stu中的信息和数据库中的用户信息做比照,匹配则会传入信息到currentStu
			if(currentStu != null)
			{
				dispose();
				new StuMainFrm().setVisible(true);
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
		this.UserIDTxt.setText("");
		this.PassWordTxt.setText("");
	}
}
