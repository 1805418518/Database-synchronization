package sqltongbu;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class button {
	static class source_edit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFrame jf=new JFrame("源数据库编辑连接");
			jf.setLayout(null);
			
			JLabel jl_address=new JLabel("地址");
			JLabel jl_user=new JLabel("账号");
			JLabel jl_password=new  JLabel("密码");
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			
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
			
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			
			jb_submission.setBounds(50, 200, 80, 25);
			jb_test.setBounds(140, 200, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
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
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			
			jb_submission.setBounds(50, 200, 80, 25);
			jb_test.setBounds(140, 200, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
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
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			
			jb_submission.setBounds(50, 200, 80, 25);
			jb_test.setBounds(140, 200, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
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
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			
			jb_submission.setBounds(50, 200, 80, 25);
			jb_test.setBounds(140, 200, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
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
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			
			jb_submission.setBounds(50, 200, 80, 25);
			jb_test.setBounds(140, 200, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
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
			
			JTextField jt_addres=new JTextField();
			JTextField jt_user=new JTextField();
			JPasswordField jp_password=new JPasswordField();
			
			JButton jb_submission=new JButton("提交");
			JButton jb_test=new JButton("测试");
			
			jl_address.setBounds(50, 50, 100, 25);
			jl_user.setBounds(50, 85, 100, 25);
			jl_password.setBounds(50, 120, 100, 25);
			
			
			jt_addres.setBounds(100, 50, 150, 25);
			jt_user.setBounds(100, 85, 150, 25);
			jp_password.setBounds(100, 120, 150, 25);
			
			jb_submission.setBounds(50, 200, 80, 25);
			jb_test.setBounds(140, 200, 80, 25);
			
			
			jf.add(jl_address);
			jf.add(jl_user);
			jf.add(jl_password);
			jf.add(jt_addres);
			jf.add(jt_user);
			jf.add(jp_password);
			jf.add(jb_submission);
			jf.add(jb_test);
			jf.setLocation(500, 200);
			jf.setSize(300, 300);
			jf.setVisible(true);
		}

	}


	
	
}
