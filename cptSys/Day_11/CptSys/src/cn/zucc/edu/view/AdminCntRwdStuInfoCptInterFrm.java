package cn.zucc.edu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminCntRwdStuInfoCptInterFrm extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCntRwdStuInfoCptInterFrm frame = new AdminCntRwdStuInfoCptInterFrm();
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
	public AdminCntRwdStuInfoCptInterFrm() {
		setTitle("特定竞赛获奖学生信息统计");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 1002, 600);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 99, 921, 421);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("竞赛名称");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel.setBounds(59, 35, 111, 27);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(170, 30, 202, 34);
		getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 24));
		btnNewButton.setBounds(820, 30, 97, 37);
		getContentPane().add(btnNewButton);
		
		JLabel CptHoldYear = new JLabel("举行年份");
		CptHoldYear.setFont(new Font("宋体", Font.BOLD, 23));
		CptHoldYear.setBounds(434, 35, 111, 27);
		getContentPane().add(CptHoldYear);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(545, 30, 202, 34);
		getContentPane().add(textField_1);

	}
}
