package cn.zucc.edu.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StuMainFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuMainFrm frame = new StuMainFrm();
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
	public StuMainFrm() {
		setTitle("CompetitionRegisterSys学生模式");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("组队报名");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("竞赛组队");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("竞赛报名");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("查询统计");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("竞赛信息查询");
		mnNewMenu_2.add(mntmNewMenuItem_1_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("获奖信息查询");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_4_1 = new JMenuItem("竞赛信息统计");
		mnNewMenu_2.add(mntmNewMenuItem_4_1);
		
		JMenu mnNewMenu_1 = new JMenu("用户管理");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("修改密码");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordModifyActionPerformed(e);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		
		/*
		 * 学生安全退出系统功能
		 */
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("退出登录");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(res == 0){
					int res_2 = JOptionPane.showConfirmDialog(null, "真的不再多了解一会吗{^.^}");
					if(res_2 == 0) {
						dispose();	
					}
				}
				else if(res == 1){
					JOptionPane.showMessageDialog(null, "再多了解了解吧");
				}
				else {
					JOptionPane.showMessageDialog(null, "点错了吧,下次要小心哦");
				}
			}
			
		});
		
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.setLocationRelativeTo(null);
		
	}

	/**
	 * 修改密码函数
	 * @param e
	 */
	protected void passwordModifyActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
}
