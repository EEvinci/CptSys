package cn.zucc.edu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import cn.zucc.edu.dao.TeamDao;
import cn.zucc.edu.models.BeanCptInfo;
import cn.zucc.edu.models.BeanTeam;
import cn.zucc.edu.util.DBUtil;
import cn.zucc.edu.util.StringUtil;

public class AdminRUDTeamInterFrm extends JInternalFrame {
	private JTextField teamTxt;
	private JTable teamTable;
	
	private DBUtil dbUtil = new DBUtil();
	private TeamDao teamDao = new TeamDao();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRUDTeamInterFrm frame = new AdminRUDTeamInterFrm();
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
	public AdminRUDTeamInterFrm() {
		setTitle("查询/修改/删除队伍信息");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 1001, 598);
		
		JLabel lblNewLabel = new JLabel("队伍编号");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		teamTxt = new JTextField();
		teamTxt.setColumns(10);
		
		JButton Query = new JButton("查询");
		Query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeamInfoSearchActionPerformed(e);
			}
		});
		Query.setFont(new Font("宋体", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u961F\u4F0D\u4FE1\u606F\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeamUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1.setBounds(239, 127, 97, 33);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeamDeleteActionPerformed(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_2.setBounds(602, 127, 97, 33);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("队伍编号");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(25, 60, 71, 20);
		panel.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(104, 59, 83, 21);
		panel.add(textField);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("队伍名称");
		lblNewLabel_1_2_4.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_2_4.setBounds(197, 60, 71, 20);
		panel.add(lblNewLabel_1_2_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(278, 61, 83, 21);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("队伍人数");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(383, 60, 71, 20);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(462, 59, 83, 21);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("获奖等级");
		lblNewLabel_1_1_2.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_1_2.setBounds(571, 61, 71, 20);
		panel.add(lblNewLabel_1_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(650, 60, 83, 21);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("是否完赛");
		lblNewLabel_1_1_3.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_1_3.setBounds(759, 61, 71, 20);
		panel.add(lblNewLabel_1_1_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(838, 60, 89, 21);
		panel.add(textField_4);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 937, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 910, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(291, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(10)
					.addComponent(teamTxt, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(Query, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(266))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(4)
								.addComponent(teamTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addComponent(Query, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		
		teamTable = new JTable();
		teamTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TeamTableMousePressed(e);
			}
		});
		teamTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u961F\u4F0D\u7F16\u53F7", "\u961F\u4F0D\u540D\u79F0", "\u961F\u4F0D\u4EBA\u6570", "\u83B7\u5956\u7B49\u7EA7", "\u662F\u5426\u5B8C\u8D5B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(teamTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new BeanTeam());//将表中的信息传入到表格中

	}


	
	/**
	 * 队伍信息删除
	 * @param evt
	 */
	private void TeamDeleteActionPerformed(ActionEvent evt) {
		String id = textField.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确认要删除此记录吗？");
		if(n == 0) {
			Connection conn = null;
			try {
				conn = dbUtil.getConn();
				int delete = teamDao.delete(conn, id);
				if(delete == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.reSetValue();
					this.fillTable(new BeanTeam());
				}else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		}
	}
	

	/**
	 * 队伍信息修改
	 * @param e
	 */
	private void TeamUpdateActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String TeamId = textField.getText();
		String TeamName = textField_1.getText();
		String MemNum = textField_2.getText();
		String RwdGrade = textField_3.getText();
		String IsFinCpt = textField_4.getText();
		
		if(StringUtil.isEmpty(TeamId)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(TeamId) || StringUtil.isEmpty(TeamName) || StringUtil.isEmpty(MemNum) ){
			JOptionPane.showMessageDialog(null, "请将要修改的信息填写完整");
			return;
		}
		
		BeanTeam team = new BeanTeam(TeamId,TeamName,Integer.parseInt(MemNum),RwdGrade,IsFinCpt);
		Connection conn = null;
		
		try {
			conn = dbUtil.getConn();
			int rs = teamDao.update(conn, team);
			if(rs == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				
				this.reSetValue();//清楚留在表格中的数据
				
				this.fillTable(new BeanTeam());//在上面的table中显示已经更新过的信息
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
	}
	
	
	
	/**
	 *重置表单 
	 */
	private void reSetValue() {
		this.textField.setText("");
		this.textField_1.setText("");
		this.textField_2.setText("");
		this.textField_3.setText("");
		this.textField_4.setText("");
	}
	
	
	
	/**
	 * 表格行点击事件处理	
	 * @param e
	 */
	private void TeamTableMousePressed(MouseEvent e) {
		int row = teamTable.getSelectedRow();
		
		textField.setText((String)teamTable.getValueAt(row, 0));
		textField_1.setText((String)teamTable.getValueAt(row, 1));
		textField_2.setText((String)teamTable.getValueAt(row, 2));
		textField_3.setText((String)teamTable.getValueAt(row, 3));
		textField_4.setText((String)teamTable.getValueAt(row, 4));
		
	}
	
	
	/**
	 * 队伍信息查询
	 * @param e
	 */
	private void TeamInfoSearchActionPerformed(ActionEvent e) {
		
		String c_team = this.teamTxt.getText();
		BeanTeam team = new BeanTeam();
		team.setTeamId(c_team);
		this.fillTable(team);
	}
	
	/**
	 * 队伍信息填充表格
	 * @param teamInfo
	 */
	private void fillTable(BeanTeam teamInfo) {
		DefaultTableModel dtm = (DefaultTableModel) teamTable.getModel();
		dtm.setRowCount(0);
		Connection conn = null;
		try {
			conn = dbUtil.getConn();
			ResultSet rs = teamDao.query(conn,teamInfo);
			while(rs.next())
			{
				Vector v = new Vector();
				
				v.add(rs.getString("TeamId"));
				v.add(rs.getString("TeamName"));
				v.add(rs.getString("MemNum"));
				v.add(rs.getString("RwdGrade"));
				v.add(rs.getString("IsFinCpt"));

				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeConn(conn);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
