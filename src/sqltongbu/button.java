package sqltongbu;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
	static class source_edit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFrame jf=new JFrame("源数据库编辑连接");
			jf.setLayout(null);
			 
			JLabel jl_address=new JLabel("地址");
			JLabel jl_user=new JLabel("账号");
			JLabel jl_password=new  JLabel("密码");
			JLabel jl_surface=new JLabel("库名");
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			JTextField jt_surface=new JTextField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");

			
			jb_test.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					System.out.print(ac_address+" "+ac_user+" "+ac_password+" "+ac_surface);
					DBUtil2.getConnection(ac_user,ac_password,ac_surface,ac_address);
					
						
				}
			});
			
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			jl_surface.setBounds(50, 155, 100, 25);
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			jt_surface.setBounds(100, 150, 150, 25);
			
			jb_submission.setBounds(50, 200, 80, 25);
			jb_test.setBounds(140, 200, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jl_surface);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.add(jt_surface);
			jf.setLocation(500, 200);
			jf.setSize(300, 300);
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
			
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			JTextField jt_surface=new JTextField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");

			
			jb_submission.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					 Connection conn=null;
					 PreparedStatement ps=null;
					 ResultSet rs=null;
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					System.out.print(ac_address+" "+ac_user+" "+ac_password);
					 conn = DBUtil.getConnection();
					 
						 try {
							 String sql1="insert into sqldata (ACADDRESS,ACUSER,ACPASSWORD,ACSURFACE,ACZL) values(?,?,?,?,?)";
					         ps=conn.prepareStatement(sql1);
					         ps.setString(1, ac_address);
					         ps.setString(2,ac_user);
					         ps.setString(3,ac_password);
					         ps.setString(4,ac_surface);
					         ps.setString(5, "1");
					        int s= ps.executeUpdate();
					        if(s>0) {
					        DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address);	
							JOptionPane.showMessageDialog(null, "数据新建成功", "数据新建提交成功", JOptionPane.PLAIN_MESSAGE);

					        } 
					        ps.close();//关闭资源
							conn.close();//关闭资源
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
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
					 DBUtil2.getConnection(ac_user, ac_password, ac_surface, ac_address);
						 
				}
			});
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			jl_surface.setBounds(50, 155, 100, 25);
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			jt_surface.setBounds(100, 150, 150, 25);
			
			jb_submission.setBounds(50, 200, 80, 25);
			jb_test.setBounds(140, 200, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jl_surface);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.add(jt_surface);
			jf.setLocation(500, 200);
			jf.setSize(300, 300);
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
			
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			JTextField jt_surface=new JTextField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");

			
			jb_test.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					System.out.print(ac_address+" "+ac_user+" "+ac_password);
				}
			});
			
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			jl_surface.setBounds(50, 155, 100, 25);
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			jt_surface.setBounds(100, 150, 150, 25);
			
			jb_submission.setBounds(50, 200, 80, 25);
			jb_test.setBounds(140, 200, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jl_surface);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.add(jt_surface);
			jf.setLocation(500, 200);
			jf.setSize(300, 300);
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
			
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			JTextField jt_surface=new JTextField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");

			
			jb_test.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					System.out.print(ac_address+" "+ac_user+" "+ac_password);
				}
			});
			
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			jl_surface.setBounds(50, 155, 100, 25);
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			jt_surface.setBounds(100, 150, 150, 25);
			
			jb_submission.setBounds(50, 200, 80, 25);
			jb_test.setBounds(140, 200, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jl_surface);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.add(jt_surface);
			jf.setLocation(500, 200);
			jf.setSize(300, 300);
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
			
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			JTextField jt_surface=new JTextField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");

			
			jb_test.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					String ac_surface=jt_surface.getText();
					System.out.print(ac_address+" "+ac_user+" "+ac_password);
					System.out.println(ac_surface);
					
				}
			});
			
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			jl_surface.setBounds(50, 155, 100, 25);
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			jt_surface.setBounds(100, 150, 150, 25);
			
			jb_submission.setBounds(50, 200, 80, 25);
			jb_test.setBounds(140, 200, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jl_surface);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.add(jt_surface);
			jf.setLocation(500, 200);
			jf.setSize(300, 300);
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
			
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			JTextField jt_surface=new JTextField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");

			
			jb_test.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String ac_address=jt_addres.getText();
					String ac_user=jt_user.getText();
					String ac_password=jp_password.getText();
					System.out.print(ac_address+" "+ac_user+" "+ac_password);
				}
			});
			
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			jl_surface.setBounds(50, 155, 100, 25);
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			jt_surface.setBounds(100, 150, 150, 25);
			
			jb_submission.setBounds(50, 200, 80, 25);
			jb_test.setBounds(140, 200, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jl_surface);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.add(jt_surface);
			jf.setLocation(500, 200);
			jf.setSize(300, 300);
			jf.setVisible(true);
		}

	}


	
	
}
