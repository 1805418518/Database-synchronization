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
		
		jb_source_edit.addActionListener(new  button.source_edit());
		jb_source_new.addActionListener(new button.source_new());
		
		jb_target_edit.addActionListener(new button.target_edit());
		jb_target_new.addActionListener(new button.target_new());
		
		jb_control_edit.addActionListener(new button.control_edit());
		jb_control_new.addActionListener(new button.control_new());
		
		
		
		
		
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
