package cn.zucc.edu.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.zucc.edu.models.BeanTeam;
import cn.zucc.edu.util.StringUtil;
import java.awt.event.ActionListener;

public class AdminSetStuRwdInfo extends JInternalFrame {
	private JTextField TeamNameTxt;
	private JTextField RwdGradeTxt;
	private JTextField isPtcptTxt;
	
	private JTextField TeamIdTxt;
	
	private JTextField insertTeamIdTxt;
	private JTextField CptIdTxt;
	
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSetStuRwdInfo frame = new AdminSetStuRwdInfo();
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
	public AdminSetStuRwdInfo() {
		setBounds(100, 100, 1019, 601);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u961F\u4F0D\u4FE1\u606F\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel.setBounds(28, 335, 937, 179);
		getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1.setBounds(239, 127, 97, 33);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("重置");
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_2.setBounds(602, 127, 97, 33);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("队伍编号");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(225, 59, 71, 20);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("队伍名称");
		lblNewLabel_1_2_4.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_2_4.setBounds(397, 59, 71, 20);
		panel.add(lblNewLabel_1_2_4);
		
		TeamNameTxt = new JTextField();
		TeamNameTxt.setColumns(10);
		TeamNameTxt.setBounds(478, 60, 83, 21);
		panel.add(TeamNameTxt);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("获奖等级");
		lblNewLabel_1_1_2.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_1_2.setBounds(571, 61, 71, 20);
		panel.add(lblNewLabel_1_1_2);
		
		RwdGradeTxt = new JTextField();
		RwdGradeTxt.setColumns(10);
		RwdGradeTxt.setBounds(650, 60, 83, 21);
		panel.add(RwdGradeTxt);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("是否完赛");
		lblNewLabel_1_1_3.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_1_3.setBounds(759, 61, 71, 20);
		panel.add(lblNewLabel_1_1_3);
		
		isPtcptTxt = new JTextField();
		isPtcptTxt.setColumns(10);
		isPtcptTxt.setBounds(838, 60, 89, 21);
		panel.add(isPtcptTxt);
		
		insertTeamIdTxt = new JTextField();
		insertTeamIdTxt.setColumns(10);
		insertTeamIdTxt.setBounds(306, 59, 83, 21);
		panel.add(insertTeamIdTxt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("竞赛编号");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(40, 59, 71, 20);
		panel.add(lblNewLabel_1_1_1);
		
		CptIdTxt = new JTextField();
		CptIdTxt.setColumns(10);
		CptIdTxt.setBounds(121, 59, 83, 21);
		panel.add(CptIdTxt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 81, 910, 227);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7ADE\u8D5B\u7F16\u53F7", "\u961F\u4F0D\u540D\u79F0", "\u961F\u4F0D\u7F16\u53F7", "\u83B7\u5956\u7B49\u7EA7", "\u662F\u5426\u5B8C\u8D5B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("队伍编号");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(294, 39, 83, 24);
		getContentPane().add(lblNewLabel);
		
		TeamIdTxt = new JTextField();
		TeamIdTxt.setColumns(10);
		TeamIdTxt.setBounds(387, 34, 197, 29);
		getContentPane().add(TeamIdTxt);
		
		JButton Query = new JButton("查询");
		Query.setFont(new Font("宋体", Font.BOLD, 20));
		Query.setBounds(625, 30, 97, 33);
		getContentPane().add(Query);

//		this.fillTable(new BeanTeam());//将表中的信息传入到表格中
	}
	
//	/**
//	 * 获奖信息修改
//	 * @param e
//	 */
//	private void RwdInfoUpdateActionPerformed(ActionEvent evt) {
//		// TODO 自动生成的方法存根
//		String TeamId = insertTeamIdTxt.getText();
//		String TeamName = TeamNameTxt.getText();
//		String MemNum = CptIdTxt.getText();
//		String RwdGrade = RwdGradeTxt.getText();
//		String IsFinCpt = isPtcptTxt.getText();
//		
//		if(StringUtil.isEmpty(TeamId)) {
//			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
//			return;
//		}
//		if(StringUtil.isEmpty(TeamId) || StringUtil.isEmpty(TeamName) || StringUtil.isEmpty(MemNum) ){
//			JOptionPane.showMessageDialog(null, "请将要修改的信息填写完整");
//			return;
//		}
//		
//		BeanTeam team = new BeanTeam(TeamId,TeamName,Integer.parseInt(MemNum),RwdGrade,IsFinCpt);
//		Connection conn = null;
//		
//		try {
//			conn = dbUtil.getConn();
//			int rs = teamDao.update(conn, team);
//			if(rs == 1) {
//				JOptionPane.showMessageDialog(null, "修改成功");
//				
//				this.reSetValue();//清楚留在表格中的数据
//				
//				this.fillTable(new BeanTeam());//在上面的table中显示已经更新过的信息
//			}else {
//				JOptionPane.showMessageDialog(null, "修改失败");
//			}
//		} catch (Exception e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}	
//	}
//	
//	
//	
//	/**
//	 *重置表单 
//	 */
//	private void reSetValue() {
//		this.insertTeamIdTxt.setText("");
//		this.TeamNameTxt.setText("");
//		this.CptIdTxt.setText("");
//		this.RwdGradeTxt.setText("");
//		this.isPtcptTxt.setText("");
//	}
//	
//	
//	
//	/**
//	 * 表格行点击事件处理	
//	 * @param e
//	 */
//	private void TeamTableMousePressed(MouseEvent e) {
//		int row = teamTable.getSelectedRow();
//		
//		insertTeamIdTxt.setText((String)teamTable.getValueAt(row, 0));
//		TeamNameTxt.setText((String)teamTable.getValueAt(row, 1));
//		CptIdTxt.setText((String)teamTable.getValueAt(row, 2));
//		RwdGradeTxt.setText((String)teamTable.getValueAt(row, 3));
//		isPtcptTxt.setText((String)teamTable.getValueAt(row, 4));
//		
//	}
//	
//	
//	/**
//	 * 获奖信息查询
//	 * @param e
//	 */
//	private void TeamInfoSearchActionPerformed(ActionEvent e) {
//		
//		String c_team = this.teamTxt.getText();
//		BeanTeam team = new BeanTeam();
//		team.setTeamId(c_team);
//		this.fillTable(team);
//	}
//	
//	/**
//	 * 队伍信息填充表格
//	 * @param teamInfo
//	 */
//	private void fillTable(BeanTeam teamInfo) {
//		DefaultTableModel dtm = (DefaultTableModel) teamTable.getModel();
//		dtm.setRowCount(0);
//		Connection conn = null;
//		try {
//			conn = dbUtil.getConn();
//			ResultSet rs = teamDao.query(conn,teamInfo);
//			while(rs.next())
//			{
//				Vector v = new Vector();
//				
//				v.add(rs.getString("TeamId"));
//				v.add(rs.getString("TeamName"));
//				v.add(rs.getString("MemNum"));
//				v.add(rs.getString("RwdGrade"));
//				v.add(rs.getString("IsFinCpt"));
//
//				dtm.addRow(v);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally {
//			try {
//				dbUtil.closeConn(conn);
//			}catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//		}
//	}
}
