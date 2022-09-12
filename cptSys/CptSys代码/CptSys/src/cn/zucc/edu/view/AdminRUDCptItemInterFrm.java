package cn.zucc.edu.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.zucc.edu.dao.CptItemDao;
import cn.zucc.edu.models.BeanCptInfo;
import cn.zucc.edu.models.BeanCptItemInfo;
import cn.zucc.edu.util.DBUtil;
import cn.zucc.edu.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminRUDCptItemInterFrm extends JInternalFrame {
	private JTable CptItemInfoTable;
	private JTextField CptItemTxt;

	private DBUtil dbUtil = new DBUtil();
	private CptItemDao cptItemDao = new CptItemDao();
	
	private JTextField cptItemIdTxt;
	private JTextField cptItemNameTxt;
	private JTextField resPersonTxt;
	private JTextField belongColTxt;
	private JTextField cptLevelTxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRUDCptItemInterFrm frame = new AdminRUDCptItemInterFrm();
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
	public AdminRUDCptItemInterFrm() {
		setTitle("查询/修改/删除赛项信息");
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 1017, 600);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("赛项编号");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		
		CptItemTxt = new JTextField();
		CptItemTxt.setColumns(10);
		
		JButton Query = new JButton("查询");
		Query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CptItemInfoSearchActionPerformed(e);
			}
		});
		Query.setFont(new Font("宋体", Font.BOLD, 20));
		
		JPanel CptItemNameTxt = new JPanel();
		CptItemNameTxt.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u8D5B\u9879\u4FE1\u606F\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CptItemInfoDeleteActionPerformed(e);
			}
		});
		btnNewButton_2.setBounds(602, 127, 97, 33);
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("赛项编号");
		lblNewLabel_1_1.setBounds(25, 60, 71, 20);
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 17));
		
		cptItemIdTxt = new JTextField();
		cptItemIdTxt.setEditable(false);
		cptItemIdTxt.setBounds(104, 59, 83, 21);
		cptItemIdTxt.setColumns(10);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("赛项名称");
		lblNewLabel_1_2_4.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_2_4.setBounds(197, 60, 71, 20);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CptItemInfoUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(239, 127, 97, 33);
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 929, GroupLayout.PREFERRED_SIZE)
								.addComponent(CptItemNameTxt, GroupLayout.PREFERRED_SIZE, 937, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(272)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(CptItemTxt, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(Query, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(CptItemTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addComponent(Query, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(CptItemNameTxt, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		CptItemNameTxt.setLayout(null);
		CptItemNameTxt.add(btnNewButton_1);
		CptItemNameTxt.add(btnNewButton_2);
		CptItemNameTxt.add(lblNewLabel_1_1);
		CptItemNameTxt.add(cptItemIdTxt);
		CptItemNameTxt.add(lblNewLabel_1_2_4);
		
		cptItemNameTxt = new JTextField();
		cptItemNameTxt.setColumns(10);
		cptItemNameTxt.setBounds(278, 61, 83, 21);
		CptItemNameTxt.add(cptItemNameTxt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("负责老师");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(383, 60, 71, 20);
		CptItemNameTxt.add(lblNewLabel_1_1_1);
		
		resPersonTxt = new JTextField();
		resPersonTxt.setColumns(10);
		resPersonTxt.setBounds(462, 59, 83, 21);
		CptItemNameTxt.add(resPersonTxt);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("所属学院");
		lblNewLabel_1_1_2.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_1_2.setBounds(571, 61, 71, 20);
		CptItemNameTxt.add(lblNewLabel_1_1_2);
		
		belongColTxt = new JTextField();
		belongColTxt.setColumns(10);
		belongColTxt.setBounds(650, 60, 83, 21);
		CptItemNameTxt.add(belongColTxt);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("赛项等级");
		lblNewLabel_1_1_3.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_1_1_3.setBounds(759, 61, 71, 20);
		CptItemNameTxt.add(lblNewLabel_1_1_3);
		
		cptLevelTxt = new JTextField();
		cptLevelTxt.setColumns(10);
		cptLevelTxt.setBounds(838, 60, 89, 21);
		CptItemNameTxt.add(cptLevelTxt);
		
		CptItemInfoTable = new JTable();
		CptItemInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cptItemInfoTableMousePressed(e);
			}
		});
		CptItemInfoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8D5B\u9879\u7F16\u53F7", "\u8D5B\u9879\u540D\u79F0", "\u8D1F\u8D23\u8001\u5E08", "\u6240\u5C5E\u5B66\u9662", "\u8D5B\u9879\u7B49\u7EA7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(CptItemInfoTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new BeanCptItemInfo());
	}

	
	/**
	 * 赛项信息删除
	 * @param evt
	 */
	private void CptItemInfoDeleteActionPerformed(ActionEvent evt) {
		String id = cptItemIdTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确认要删除此记录吗？");
		if(n == 0) {
			Connection conn = null;
			try {
				conn = dbUtil.getConn();
				int delete = cptItemDao.delete(conn, id);
				if(delete == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.reSetValue();
					this.fillTable(new BeanCptItemInfo());
				}else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "该赛项存在竞赛不可删除");
			}
		}
	}
	
	
	
	
	/**
	 * 赛项信息修改
	 * @param e
	 */
	private void CptItemInfoUpdateActionPerformed(ActionEvent evt) {
		String cptItemId = cptItemIdTxt.getText();
		String cptItemName = cptItemNameTxt.getText();
		String resPerson = resPersonTxt.getText();
		String belongCol = belongColTxt.getText();
		String cptLevel = cptLevelTxt.getText();
		
		if(StringUtil.isEmpty(cptItemId)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(cptItemId) || StringUtil.isEmpty(cptItemName) || StringUtil.isEmpty(resPerson) 
				|| StringUtil.isEmpty(belongCol) || StringUtil.isEmpty(cptLevel)){
			JOptionPane.showMessageDialog(null, "请将要修改的信息填写完整");
			return;
		}
		
		BeanCptItemInfo cptItemInfo = new BeanCptItemInfo(cptItemId,cptItemName,resPerson,belongCol,cptLevel);
		Connection conn = null;
		
		try {
			conn = dbUtil.getConn();
			int rs = cptItemDao.update(conn, cptItemInfo);
			if(rs == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				
				this.reSetValue();//清楚留在表格中的数据
				
				this.fillTable(new BeanCptItemInfo());//在上面的table中显示已经更新过的信息
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
		this.cptItemIdTxt.setText("");
		this.cptItemNameTxt.setText("");
		this.resPersonTxt.setText("");
		this.belongColTxt.setText("");
		this.cptLevelTxt.setText("");
	}


	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void cptItemInfoTableMousePressed(MouseEvent e) {
		int row = CptItemInfoTable.getSelectedRow();
		
		this.cptItemIdTxt.setText((String)CptItemInfoTable.getValueAt(row, 0));
		this.cptItemNameTxt.setText((String) CptItemInfoTable.getValueAt(row,1));
		this.resPersonTxt.setText((String)CptItemInfoTable.getValueAt(row, 2));
		this.belongColTxt.setText((String)CptItemInfoTable.getValueAt(row,3));
		this.cptLevelTxt.setText((String)CptItemInfoTable.getValueAt(row, 4));
	}

	/**
	 * 赛项信息查询
	 * @param e
	 */
	private void CptItemInfoSearchActionPerformed(ActionEvent e) {
		String c_cptItem = this.CptItemTxt.getText();
		BeanCptItemInfo cptItemInfo = new BeanCptItemInfo();
		cptItemInfo.setCptItemId(c_cptItem);
		this.fillTable(cptItemInfo);
	}
	
	
	/**
	 * 显示赛项信息
	 * @param cptItemInfo
	 */
	private void fillTable(BeanCptItemInfo cptItemInfo) {
		DefaultTableModel dtm = (DefaultTableModel) CptItemInfoTable.getModel();
		dtm.setRowCount(0);
		Connection conn = null;
		try {
			conn = dbUtil.getConn();
			ResultSet rs = cptItemDao.query(conn,cptItemInfo);
			while(rs.next())
			{
				Vector v = new Vector();

				v.add(rs.getString("CptItemId"));
				v.add(rs.getString("CptItemName"));
				v.add(rs.getString("ResPerson"));
				v.add(rs.getString("BelongCol"));
				v.add(rs.getString("CptLevel"));
				
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
