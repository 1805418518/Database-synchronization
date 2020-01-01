package sqltongbu;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import util.DBUtil;
import util.DBUtil2;

public class button {

	
	public static String ac_address;
	public  static String ac_user;
	public static String ac_password;
	public static String ac_surface;
	static Vector<String> items = new Vector<String>();
	static Vector<String> items1=new Vector<String>();
	static Vector<String> items2=new Vector<String>();
	 static ResultSet rs=null;
	static Connection conn=null;
	 static PreparedStatement ps=null;
		public static String ac_zl;

	
	public static void jcselect()  {
	
		conn=DBUtil.getConnection();
		String sql="Select *from sqldata where ACZL=1";
		try {
			ps=conn.prepareStatement(sql);
		rs=	ps.executeQuery();
		while(rs.next())
		{
			items.add(rs.getString("ACREMARKS"));
		}
			
		} catch (SQLException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		}	
		
		String sql1="Select *from SQLDATA where ACZL=2";
		
		try {
			ps=conn.prepareStatement(sql1);
			rs=ps.executeQuery();
			while(rs.next())
			{
				items1.add(rs.getString("ACREMARKS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql2="Select *from SQLDATA where ACZL=3";
		
		try {
			ps=conn.prepareStatement(sql2);
			rs=ps.executeQuery();
			while(rs.next())
			{
				items2.add(rs.getString("ACREMARKS"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class source_edit implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e){
			// TODO Auto-generated method stub
		
			JFrame jf=new JFrame("源数据库编辑连接");
			jf.setLayout(null);
			JLabel jl_address=new JLabel("地址");
			JLabel jl_user=new JLabel("账号");
			JLabel jl_password=new  JLabel("密码");
			JLabel jl_surface=new JLabel("库名");
			JLabel jl_remarks=new JLabel("备注");
			 
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			JTextField jt_surface=new JTextField();
			JTextField jt_remarks=new JTextField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");
			String ac_source=(String) index.jc_source.getSelectedItem();
			
			conn=DBUtil.getConnection();
			String sql="Select * from SQLDATA where ACREMARKS='"+ac_source+"'";
			try {
				ps=conn.prepareStatement(sql);
			rs=	ps.executeQuery();
			while(rs.next())
			{
			 jt_addres.setText(rs.getString("ACADDRESS"));
			 jt_user.setText(rs.getString("ACUSER"));
			 jp_password.setText(rs.getString("ACPASSWORD"));
			 jt_surface.setText(rs.getString("ACSURFACE"));
			 jt_remarks.setText(rs.getString("ACREMARKS"));
			  ac_zl=rs.getString("ACZL");
				
			}
				
			} catch (SQLException e11) {
				// TODO Auto-generated catch block
				e11.printStackTrace();
			}	
			
			jt_remarks.setEditable(false);
			jb_submission.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					String ac_remarks=jt_remarks.getText();
					 conn = DBUtil.getConnection();
					 if(DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address)==0) {
							JOptionPane.showMessageDialog(null, "连接成功", "连接成功", JOptionPane.PLAIN_MESSAGE);
							try {
								 String sql1="update  sqldata set ACADDRESS=?,ACUSER=?,ACPASSWORD=?,ACSURFACE=?,ACZL=? where ACREMARKS='"+ac_source+"'";
						         ps=conn.prepareStatement(sql1);
						         ps.setString(1, ac_address);
						         ps.setString(2,ac_user);
						         ps.setString(3,ac_password);
						         ps.setString(4,ac_surface);
						         ps.setString(5, ac_zl);
						        int s= ps.executeUpdate();
						        if(s>0) {
						        	
								JOptionPane.showMessageDialog(null, "数据更新成功", "数据更新提交成功", JOptionPane.PLAIN_MESSAGE);
								
						        } 
						       
						        ps.close();//关闭资源
								conn.close();//关闭资源
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					 }
					 else {
							JOptionPane.showMessageDialog(null, "连接失败", "连接失败", JOptionPane.PLAIN_MESSAGE);

					 }
						 
					}
			});
						
			jb_test.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					
					if(DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address)==0) {
						JOptionPane.showMessageDialog(null, "连接成功", "连接成功", JOptionPane.PLAIN_MESSAGE);

				 }
				 else {
						JOptionPane.showMessageDialog(null, "连接失败", "连接失败", JOptionPane.PLAIN_MESSAGE);

				 }
					
						
				}
			});
			
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			jl_surface.setBounds(50, 155, 100, 25);
			jl_remarks.setBounds(50, 190, 100, 25);
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			jt_surface.setBounds(100, 150, 150, 25);
			jt_remarks.setBounds(100, 180, 150, 25);
			
			jb_submission.setBounds(50, 220, 80, 25);
			jb_test.setBounds(140, 220, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jl_surface);
			jf.add(jl_remarks);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.add(jt_surface);
			jf.add(jt_remarks);
			jf.setLocation(500, 200);
			jf.setSize(300, 350);
			jf.setVisible(true);
		}

	}
	
	static  class source_new implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFrame jf=new JFrame("源数据库新建连接");
			jf.setLayout(null);
			
			JLabel jl_address=new JLabel("地址");
			JLabel jl_user=new JLabel("账号");
			JLabel jl_password=new  JLabel("密码");
			JLabel jl_surface=new JLabel("库名");
			JLabel jL_remarks=new JLabel("备注");
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			JTextField jt_surface=new JTextField();
			JTextField jt_remarks=new JTextField();
			
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");

			
			jb_submission.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					String ac_remarks=jt_remarks.getText();
					System.out.print(ac_address+" "+ac_user+" "+ac_password);
					 conn = DBUtil.getConnection();
					 if(DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address)==0) {
							JOptionPane.showMessageDialog(null, "连接成功", "连接成功", JOptionPane.PLAIN_MESSAGE);
							try {
								 String sql1="insert into sqldata (ACADDRESS,ACUSER,ACPASSWORD,ACSURFACE,ACZL,ACREMARKS) values(?,?,?,?,?,?)";
						         ps=conn.prepareStatement(sql1);
						         ps.setString(1, ac_address);
						         ps.setString(2,ac_user);
						         ps.setString(3,ac_password);
						         ps.setString(4,ac_surface);
						         ps.setString(5, "1");
						         ps.setString(6,ac_remarks);
						        int s= ps.executeUpdate();
						        if(s>0) {
						        	
								JOptionPane.showMessageDialog(null, "数据新建成功", "数据新建提交成功", JOptionPane.PLAIN_MESSAGE);
								
						        } 
						       
						        ps.close();//关闭资源
								conn.close();//关闭资源
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					 }
					 else {
							JOptionPane.showMessageDialog(null, "连接失败", "连接失败", JOptionPane.PLAIN_MESSAGE);

					 }
						 
					}
			});
			jb_test.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					if(DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address)==0) {
						JOptionPane.showMessageDialog(null, "连接成功", "连接成功", JOptionPane.PLAIN_MESSAGE);

				 }
				 else {
						JOptionPane.showMessageDialog(null, "连接失败", "连接失败", JOptionPane.PLAIN_MESSAGE);

				 }
						 
				}
			});
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			jl_surface.setBounds(50, 155, 100, 25);
			jL_remarks.setBounds(50, 190, 100, 25);
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			jt_surface.setBounds(100, 150, 150, 25);
			jt_remarks.setBounds(100, 185, 150, 25);
			
			jb_submission.setBounds(50, 220, 80, 25);
			jb_test.setBounds(140, 220, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jl_surface);
			jf.add(jL_remarks);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.add(jt_surface);
			jf.add(jt_remarks);
			jf.setLocation(500, 200);
			
			jf.setSize(300, 350);
			jf.setVisible(true);
		}

	}


	

	
	static  class target_edit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFrame jf=new JFrame("目标数据库编辑连接");
			jf.setLayout(null);
			JLabel jl_address=new JLabel("地址");
			JLabel jl_user=new JLabel("账号");
			JLabel jl_password=new  JLabel("密码");
			JLabel jl_surface=new JLabel("库名");
			JLabel jl_remarks=new JLabel("备注");
			 
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			JTextField jt_surface=new JTextField();
			JTextField jt_remarks=new JTextField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");
			String ac_source=(String) index.jc_target.getSelectedItem();
			
			conn=DBUtil.getConnection();
			String sql="Select *from SQLDATA where ACREMARKS='"+ac_source+"'";
			try {
				ps=conn.prepareStatement(sql);
			rs=	ps.executeQuery();
			while(rs.next())
			{
			 jt_addres.setText(rs.getString("ACADDRESS"));
			 jt_user.setText(rs.getString("ACUSER"));
			 jp_password.setText(rs.getString("ACPASSWORD"));
			 jt_surface.setText(rs.getString("ACSURFACE"));
			 jt_remarks.setText(rs.getString("ACREMARKS"));
			  ac_zl=rs.getString("ACZL");
				
			}
				
			} catch (SQLException e11) {
				// TODO Auto-generated catch block
				e11.printStackTrace();
			}	
			
			jt_remarks.setEditable(false);
			jb_submission.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					String ac_remarks=jt_remarks.getText();
					 conn = DBUtil.getConnection();
					 if(DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address)==0) {
							JOptionPane.showMessageDialog(null, "连接成功", "连接成功", JOptionPane.PLAIN_MESSAGE);
							try {
								 String sql1="update  sqldata set ACADDRESS=?,ACUSER=?,ACPASSWORD=?,ACSURFACE=?,ACZL=? where ACREMARKS='"+ac_source+"'";
						         ps=conn.prepareStatement(sql1);
						         ps.setString(1, ac_address);
						         ps.setString(2,ac_user);
						         ps.setString(3,ac_password);
						         ps.setString(4,ac_surface);
						         ps.setString(5, ac_zl);
						        int s= ps.executeUpdate();
						        if(s>0) {
						        	
								JOptionPane.showMessageDialog(null, "数据更新成功", "数据更新提交成功", JOptionPane.PLAIN_MESSAGE);
								
						        } 
						       
						        ps.close();//关闭资源
								conn.close();//关闭资源
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					 }
					 else {
							JOptionPane.showMessageDialog(null, "连接失败", "连接失败", JOptionPane.PLAIN_MESSAGE);

					 }
						 
					}
			});
						
			jb_test.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					
					if(DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address)==0) {
						JOptionPane.showMessageDialog(null, "连接成功", "连接成功", JOptionPane.PLAIN_MESSAGE);

				 }
				 else {
						JOptionPane.showMessageDialog(null, "连接失败", "连接失败", JOptionPane.PLAIN_MESSAGE);

				 }
					
						
				}
			});
			
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			jl_surface.setBounds(50, 155, 100, 25);
			jl_remarks.setBounds(50, 190, 100, 25);
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			jt_surface.setBounds(100, 150, 150, 25);
			jt_remarks.setBounds(100, 180, 150, 25);
			
			jb_submission.setBounds(50, 220, 80, 25);
			jb_test.setBounds(140, 220, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jl_surface);
			jf.add(jl_remarks);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.add(jt_surface);
			jf.add(jt_remarks);
			jf.setLocation(500, 200);
			jf.setSize(300, 350);
			jf.setVisible(true);
		}

	}
	static class target_new implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JFrame jf=new JFrame("目标数据库新建连接");
jf.setLayout(null);
			
			JLabel jl_address=new JLabel("地址");
			JLabel jl_user=new JLabel("账号");
			JLabel jl_password=new  JLabel("密码");
			JLabel jl_surface=new JLabel("库名");
			JLabel jL_remarks=new JLabel("备注");
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			JTextField jt_surface=new JTextField();
			JTextField jt_remarks=new JTextField();
			
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");

			
			jb_submission.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					String ac_remarks=jt_remarks.getText();
					 conn = DBUtil.getConnection();
					 if(DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address)==0) {
							JOptionPane.showMessageDialog(null, "连接成功", "连接成功", JOptionPane.PLAIN_MESSAGE);
							try {
								 String sql1="insert into sqldata (ACADDRESS,ACUSER,ACPASSWORD,ACSURFACE,ACZL,ACREMARKS) values(?,?,?,?,?,?)";
						         ps=conn.prepareStatement(sql1);
						         ps.setString(1, ac_address);
						         ps.setString(2,ac_user);
						         ps.setString(3,ac_password);
						         ps.setString(4,ac_surface);
						         ps.setString(5, "2");
						         ps.setString(6,ac_remarks);
						        int s= ps.executeUpdate();
						        if(s>0) {
						        	
								JOptionPane.showMessageDialog(null, "数据新建成功", "数据新建提交成功", JOptionPane.PLAIN_MESSAGE);
								
						        } 
						       
						        ps.close();//关闭资源
								conn.close();//关闭资源
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					 }
					 else {
							JOptionPane.showMessageDialog(null, "连接失败", "连接失败", JOptionPane.PLAIN_MESSAGE);

					 }
						 
					}
			});
			jb_test.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					if(DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address)==0) {
						JOptionPane.showMessageDialog(null, "连接成功", "连接成功", JOptionPane.PLAIN_MESSAGE);

				 }
				 else {
						JOptionPane.showMessageDialog(null, "连接失败", "连接失败", JOptionPane.PLAIN_MESSAGE);

				 }
						 
				}
			});
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			jl_surface.setBounds(50, 155, 100, 25);
			jL_remarks.setBounds(50, 190, 100, 25);
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			jt_surface.setBounds(100, 150, 150, 25);
			jt_remarks.setBounds(100, 185, 150, 25);
			
			jb_submission.setBounds(50, 220, 80, 25);
			jb_test.setBounds(140, 220, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jl_surface);
			jf.add(jL_remarks);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.add(jt_surface);
			jf.add(jt_remarks);
			jf.setLocation(500, 200);
			jf.setSize(300, 350);
			jf.setVisible(true);
		}

	}

	static class control_edit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFrame jf=new JFrame("控制数据库编辑连接");
			jf.setLayout(null);
			JLabel jl_address=new JLabel("地址");
			JLabel jl_user=new JLabel("账号");
			JLabel jl_password=new  JLabel("密码");
			JLabel jl_surface=new JLabel("库名");
			JLabel jl_remarks=new JLabel("备注");
			 
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			JTextField jt_surface=new JTextField();
			JTextField jt_remarks=new JTextField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");
			String ac_source=(String) index.jc_control.getSelectedItem();
			
			conn=DBUtil.getConnection();
			String sql="Select *from SQLDATA where ACREMARKS='"+ac_source+"'";
			try {
				ps=conn.prepareStatement(sql);
			rs=	ps.executeQuery();
			while(rs.next())
			{
			 jt_addres.setText(rs.getString("ACADDRESS"));
			 jt_user.setText(rs.getString("ACUSER"));
			 jp_password.setText(rs.getString("ACPASSWORD"));
			 jt_surface.setText(rs.getString("ACSURFACE"));
			 jt_remarks.setText(rs.getString("ACREMARKS"));
			  ac_zl=rs.getString("ACZL");
				
			}
				
			} catch (SQLException e11) {
				// TODO Auto-generated catch block
				e11.printStackTrace();
			}	
			
			jt_remarks.setEditable(false);
			jb_submission.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					String ac_remarks=jt_remarks.getText();
					 conn = DBUtil.getConnection();
					 if(DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address)==0) {
							JOptionPane.showMessageDialog(null, "连接成功", "连接成功", JOptionPane.PLAIN_MESSAGE);
							try {
								 String sql1="update  sqldata set ACADDRESS=?,ACUSER=?,ACPASSWORD=?,ACSURFACE=?,ACZL=? where ACREMARKS='"+ac_source+"'";
						         ps=conn.prepareStatement(sql1);
						         ps.setString(1, ac_address);
						         ps.setString(2,ac_user);
						         ps.setString(3,ac_password);
						         ps.setString(4,ac_surface);
						         ps.setString(5, ac_zl);
						        int s= ps.executeUpdate();
						        if(s>0) {
						        	
								JOptionPane.showMessageDialog(null, "数据更新成功", "数据更新提交成功", JOptionPane.PLAIN_MESSAGE);
								
						        } 
						       
						        ps.close();//关闭资源
								conn.close();//关闭资源
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					 }
					 else {
							JOptionPane.showMessageDialog(null, "连接失败", "连接失败", JOptionPane.PLAIN_MESSAGE);

					 }
						 
					}
			});
						
			jb_test.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					
					if(DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address)==0) {
						JOptionPane.showMessageDialog(null, "连接成功", "连接成功", JOptionPane.PLAIN_MESSAGE);

				 }
				 else {
						JOptionPane.showMessageDialog(null, "连接失败", "连接失败", JOptionPane.PLAIN_MESSAGE);

				 }
					
						
				}
			});
			
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			jl_surface.setBounds(50, 155, 100, 25);
			jl_remarks.setBounds(50, 190, 100, 25);
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			jt_surface.setBounds(100, 150, 150, 25);
			jt_remarks.setBounds(100, 180, 150, 25);
			
			jb_submission.setBounds(50, 220, 80, 25);
			jb_test.setBounds(140, 220, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jl_surface);
			jf.add(jl_remarks);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.add(jt_surface);
			jf.add(jt_remarks);
			jf.setLocation(500, 200);
			jf.setSize(300, 350);
			jf.setVisible(true);
		}

	}

	

	static class control_new implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFrame jf=new JFrame("控制数据库新建连接");
jf.setLayout(null);
			
			JLabel jl_address=new JLabel("地址");
			JLabel jl_user=new JLabel("账号");
			JLabel jl_password=new  JLabel("密码");
			JLabel jl_surface=new JLabel("库名");
			JLabel jL_remarks=new JLabel("备注");
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			JTextField jt_surface=new JTextField();
			JTextField jt_remarks=new JTextField();
			
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");

			
			jb_submission.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					String ac_remarks=jt_remarks.getText();
					System.out.print(ac_address+" "+ac_user+" "+ac_password);
					 conn = DBUtil.getConnection();
					 if(DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address)==0) {
							JOptionPane.showMessageDialog(null, "连接成功", "连接成功", JOptionPane.PLAIN_MESSAGE);
							try {
								 String sql1="insert into sqldata (ACADDRESS,ACUSER,ACPASSWORD,ACSURFACE,ACZL,ACREMARKS) values(?,?,?,?,?,?)";
						         ps=conn.prepareStatement(sql1);
						         ps.setString(1, ac_address);
						         ps.setString(2,ac_user);
						         ps.setString(3,ac_password);
						         ps.setString(4,ac_surface);
						         ps.setString(5, "3");
						         ps.setString(6,ac_remarks);
						        int s= ps.executeUpdate();
						        if(s>0) {
						        	
								JOptionPane.showMessageDialog(null, "数据新建成功", "数据新建提交成功", JOptionPane.PLAIN_MESSAGE);
								
						        } 
						       
						        ps.close();//关闭资源
								conn.close();//关闭资源
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					 }
					 else {
							JOptionPane.showMessageDialog(null, "连接失败", "连接失败", JOptionPane.PLAIN_MESSAGE);

					 }
						 
					}
			});
			jb_test.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					if(DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address)==0) {
						JOptionPane.showMessageDialog(null, "连接成功", "连接成功", JOptionPane.PLAIN_MESSAGE);

				 }
				 else {
						JOptionPane.showMessageDialog(null, "连接失败", "连接失败", JOptionPane.PLAIN_MESSAGE);

				 }
						 
				}
			});
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			jl_surface.setBounds(50, 155, 100, 25);
			jL_remarks.setBounds(50, 190, 100, 25);
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			jt_surface.setBounds(100, 150, 150, 25);
			jt_remarks.setBounds(100, 185, 150, 25);
			
			jb_submission.setBounds(50, 220, 80, 25);
			jb_test.setBounds(140, 220, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jl_surface);
			jf.add(jL_remarks);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.add(jt_surface);
			jf.add(jt_remarks);
			jf.setLocation(500, 200);
			jf.setSize(300, 350);
			jf.setVisible(true);
		}

	}


	
	
}
