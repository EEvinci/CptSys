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
		setBounds(100, 100, 450, 300);

	}

}
