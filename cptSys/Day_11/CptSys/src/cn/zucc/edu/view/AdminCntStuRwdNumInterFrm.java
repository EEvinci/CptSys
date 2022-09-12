package cn.zucc.edu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminCntStuRwdNumInterFrm extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCntStuRwdNumInterFrm frame = new AdminCntStuRwdNumInterFrm();
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
	public AdminCntStuRwdNumInterFrm() {
		setTitle("学生获奖数量统计");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1001, 603);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 95, 921, 421);
		getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("竞赛名称");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 23));
		lblNewLabel.setBounds(58, 31, 111, 27);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(169, 26, 202, 34);
		getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 24));
		btnNewButton.setBounds(819, 26, 97, 37);
		getContentPane().add(btnNewButton);
		
		JLabel CptHoldYear = new JLabel("举行年份");
		CptHoldYear.setFont(new Font("宋体", Font.BOLD, 23));
		CptHoldYear.setBounds(433, 31, 111, 27);
		getContentPane().add(CptHoldYear);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(544, 26, 202, 34);
		getContentPane().add(textField_1);

	}

}
