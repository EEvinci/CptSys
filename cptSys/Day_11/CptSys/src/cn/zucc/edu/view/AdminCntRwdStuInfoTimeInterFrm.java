package cn.zucc.edu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class AdminCntRwdStuInfoTimeInterFrm extends JInternalFrame {

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
		setTitle("特定时间获奖学生信息统计");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1011, 605);
		getContentPane().setLayout(null);

	}

}
