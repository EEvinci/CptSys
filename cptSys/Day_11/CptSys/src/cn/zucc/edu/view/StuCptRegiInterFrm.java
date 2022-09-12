package cn.zucc.edu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class StuCptRegiInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuCptRegiInterFrm frame = new StuCptRegiInterFrm();
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
	public StuCptRegiInterFrm() {
		setTitle("学生竞赛报名");
		setBounds(100, 100, 999, 601);

	}

}
