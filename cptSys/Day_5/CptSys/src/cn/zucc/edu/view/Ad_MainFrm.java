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

public class Ad_MainFrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ad_MainFrm frame = new Ad_MainFrm();
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
	public Ad_MainFrm() {
		setTitle("CompetitionSys管理员模式");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu SysMng = new JMenu("系统管理");
		menuBar.add(SysMng);
		
		JMenuItem StuMng = new JMenuItem("学生管理");
		SysMng.add(StuMng);
		
		JMenuItem CptItmMng = new JMenuItem("赛项管理");
		CptItmMng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ad_CptItemAddInterFrm cptItemAddInterFrm = new Ad_CptItemAddInterFrm();
				cptItemAddInterFrm.setVisible(true);
				contentPane.add(cptItemAddInterFrm);
			}
		});
		SysMng.add(CptItmMng);
		
		JMenuItem CptMng = new JMenuItem("竞赛管理");
		SysMng.add(CptMng);
		
		JMenuItem RwdMng = new JMenuItem("获奖管理");
		SysMng.add(RwdMng);
		
		/*
		 * 管理员安全退出功能
		 */
		JMenuItem mntmNewMenuItem = new JMenuItem("安全退出");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "是否确认退出");
				if(res == 0) {
					dispose();
				}
				else if(res == 1)
				{
					JOptionPane.showMessageDialog(null, "再多管理一会吧");
				}
			}
		});
		SysMng.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("查询统计");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem SrchStuAwd = new JMenuItem("查询学生获奖情况");
		mnNewMenu_1.add(SrchStuAwd);
		
		JMenuItem SrchCptRegi = new JMenuItem("查询竞赛报名情况");
		mnNewMenu_1.add(SrchCptRegi);
		
		JMenuItem SrchCptAwd = new JMenuItem("查询竞赛获奖情况");
		mnNewMenu_1.add(SrchCptAwd);
		
		JMenuItem CntStuAwd = new JMenuItem("统计学生获奖数量");
		mnNewMenu_1.add(CntStuAwd);
		
		JMenu CntAwdStuInfo = new JMenu("统计获奖学生信息");
		mnNewMenu_1.add(CntAwdStuInfo);
		
		JMenuItem CptBased = new JMenuItem("竞赛基准");
		CntAwdStuInfo.add(CptBased);
		
		JMenuItem TimeProBased = new JMenuItem("时间/专业基准");
		CntAwdStuInfo.add(TimeProBased);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.setLocationRelativeTo(null);
	}

}
