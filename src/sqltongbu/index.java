package sqltongbu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class index {

	public static void main(String[] args) {
	
		JFrame jframe=new JFrame("数据库同步");
		jframe.setLayout(null);
		JLabel jl_step=new JLabel("步骤名称");
		JLabel jl_source=new JLabel("源数据库连接");
		JLabel jl_target=new JLabel("目标数据库连接");
		JLabel jl_control=new JLabel("控制数据库连接");
		
		JTextField jt_step=new JTextField();
		JComboBox<String> jc_source=new JComboBox<String>();
		JComboBox<String> jc_target=new JComboBox<String>();
		JComboBox<String> jc_control=new JComboBox<String>();
	
		JButton jb_source_edit=new JButton("编辑");
		JButton jb_source_new=new JButton("新建");
		
		JButton jb_target_edit=new JButton("编辑");
		JButton jb_target_new=new JButton("新建");
		
		JButton jb_control_edit=new JButton("编辑");
		JButton jb_control_new=new JButton("新建");
		
		jl_step.setBounds(50, 10, 100, 30);
		jl_source.setBounds(50, 40, 100, 30);
		jl_target.setBounds(50, 70, 100, 30);
		jl_control.setBounds(50, 100, 100, 30);
		
		jt_step.setBounds(150, 10, 300, 25);
		jc_source.setBounds(150, 40, 150, 25);
		jc_target.setBounds(150, 70, 150, 25);
		jc_control.setBounds(150, 100, 150, 25);
		
		jb_source_edit.setBounds(310,40, 80, 25);
		jb_source_new.setBounds(400, 40, 80, 25);
		
		jb_target_edit.setBounds(310, 70, 80, 25);
		jb_target_new.setBounds(400, 70, 80, 25);
		
		jb_control_edit.setBounds(310, 100, 80, 25);
		jb_control_new.setBounds(400, 100, 80, 25);
		jb_source_edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame jf=new JFrame("编辑连接");
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
				
				jf.setSize(300, 300);
				jf.setVisible(true);
			}
		});
		
		
		
		
		jframe.add(jl_step);
		jframe.add(jl_source);
		jframe.add(jl_target);
		jframe.add(jl_control);
		jframe.add(jt_step);
		jframe.add(jc_source);
		jframe.add(jc_target);
		jframe.add(jc_control);
		jframe.add(jb_source_edit);
		jframe.add(jb_source_new);
		jframe.add(jb_target_edit);
		jframe.add(jb_target_new);
		jframe.add(jb_control_edit);
		jframe.add(jb_control_new);
		
		
		jframe.setSize(500, 700);
		jframe.setLocation(500, 200);
		jframe.setVisible(true);
		
		

	}

}
