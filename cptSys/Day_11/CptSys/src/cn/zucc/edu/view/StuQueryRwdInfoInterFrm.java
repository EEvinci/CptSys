package cn.zucc.edu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class StuQueryRwdInfoInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuQueryRwdInfoInterFrm frame = new StuQueryRwdInfoInterFrm();
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
	public StuQueryRwdInfoInterFrm() {
		setBounds(100, 100, 450, 300);

	}

}
