package cn.zucc.edu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class AdminQueryCptRegiInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminQueryCptRegiInterFrm frame = new AdminQueryCptRegiInterFrm();
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
	public AdminQueryCptRegiInterFrm() {
		setBounds(100, 100, 450, 300);

	}

}
