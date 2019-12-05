package sqltongbu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class index {

	public static void main(String[] args) {
	
		JFrame jframe=new JFrame("数据库同步");
		JPanel jpanel=new JPanel();
		jpanel.setLayout(null);
		jframe.setLayout(null);
		JLabel jl_step=new JLabel("步骤名称");
		JLabel jl_source=new JLabel("源数据库连接");
		JLabel jl_target=new JLabel("目标数据库连接");
		JLabel jl_control=new JLabel("控制数据库连接");
		JLabel jl_appoint=new JLabel("指定需同步表SQL");
		JTabbedPane jtp=new JTabbedPane();
		JTextField jt_step=new JTextField();
		JTextArea jt_appoint=new JTextArea(20,100);
		JScrollPane js_appoint=new JScrollPane(jt_appoint);
				
		JComboBox<String> jc_source=new JComboBox<String>();
		JComboBox<String> jc_target=new JComboBox<String>();
		JComboBox<String> jc_control=new JComboBox<String>();
		
		JButton jb_source_edit=new JButton("编辑");
		JButton jb_source_new=new JButton("新建");
		
		JButton jb_target_edit=new JButton("编辑");
		JButton jb_target_new=new JButton("新建");
		
		JButton jb_control_edit=new JButton("编辑");
		JButton jb_control_new=new JButton("新建");
		JButton jb_determine=new JButton("确定");
		JButton jb_cancel=new JButton("取消");
		
		JLabel  jl_surface=new JLabel("表");
		JLabel  jl_view =new JLabel("视图");
		JLabel  jl_sequence=new JLabel("序列");
		JLabel  jl_package=new JLabel("包");
		JLabel  jl_stored=new JLabel("存储过程");
		JLabel  jl_function=new JLabel("函数");
		JLabel  jl_synonym=new JLabel("同义词");
		JLabel  jl_partition=new JLabel("分区表");
		JLabel  jl_dblink=new JLabel("DB Link");
		JLabel  jl_materialized=new JLabel("物化视图");
				
		
		JCheckBox jcb_surface=new JCheckBox();
		JCheckBox jcb_view=new JCheckBox();
		JCheckBox jcb_sequence=new JCheckBox();
		JCheckBox jcb_package=new JCheckBox();
		JCheckBox jcb_stored=new  JCheckBox();
		JCheckBox jcb_function=new JCheckBox();
		JCheckBox jcb_synonym=new JCheckBox();
		JCheckBox jcb_partition=new JCheckBox();
		JCheckBox jcb_dblink=new JCheckBox();
		JCheckBox jcb_materialized=new JCheckBox();
		
		
		
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
		
		jtp.setBounds(25, 150, 440, 300);
		
		jcb_surface.setBounds(20, 10, 20, 20);
		jcb_view.setBounds(20, 30, 20, 20);
		jcb_sequence.setBounds(20, 50, 20, 20);
		jcb_package.setBounds(20, 70, 20, 20);
		jcb_stored.setBounds(20, 90, 20, 20);
		jcb_function.setBounds(20, 110, 20, 20);
		jcb_synonym.setBounds(20, 130, 20, 20);
		jcb_partition.setBounds(20, 150, 20, 20);
		jcb_dblink.setBounds(20, 170, 20, 20);
		jcb_materialized.setBounds(20, 190, 20, 20);
		
		jl_surface.setBounds(50, 10, 120, 20);
		jl_view.setBounds(50, 30, 120, 20);
		jl_sequence.setBounds(50, 50, 120, 20);
		jl_package.setBounds(50, 70, 120, 20);
		jl_stored.setBounds(50, 90, 120, 20);
		jl_function.setBounds(50, 110, 120, 20);
		jl_synonym.setBounds(50, 130, 120, 20);
		jl_partition.setBounds(50, 150, 120, 20);
		jl_dblink.setBounds(50, 170, 120, 20);
		jl_materialized.setBounds(50, 190, 120, 20);
		jl_appoint.setBounds(40, 460, 200, 30);
		js_appoint.setBounds(40, 500, 400, 100);
		jb_determine.setBounds(80,610 , 100, 30);
		jb_cancel.setBounds(250, 610, 100, 30);
		
		jb_source_edit.addActionListener(new  button.source_edit());
		jb_source_new.addActionListener(new button.source_new());
		
		jb_target_edit.addActionListener(new button.target_edit());
		jb_target_new.addActionListener(new button.target_new());
		
		jb_control_edit.addActionListener(new button.control_edit());
		jb_control_new.addActionListener(new button.control_new());
		jtp.addTab("数据库对象类型", jpanel);
		jpanel.add(jcb_surface);
		jpanel.add(jcb_view);
		jpanel.add(jcb_sequence);
		jpanel.add(jcb_package);
		jpanel.add(jcb_stored);
		jpanel.add(jcb_function);
		jpanel.add(jcb_synonym);
		jpanel.add(jcb_partition);
		jpanel.add(jcb_dblink);
		jpanel.add(jcb_materialized);
		jpanel.add(jl_surface);
		jpanel.add(jl_view);
		jpanel.add(jl_sequence);
		jpanel.add(jl_package);
		jpanel.add(jl_stored);
		jpanel.add(jl_function);
		jpanel.add(jl_synonym);
		jpanel.add(jl_partition);
		jpanel.add(jl_dblink);
		jpanel.add(jl_materialized);
		
		
		
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
		jframe.add(jtp);
		jframe.add(jl_appoint);
		jframe.add(js_appoint);
		jframe.add(jb_determine);
		jframe.add(jb_cancel);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(500, 700);
		jframe.setLocation(500, 200);
		jframe.setVisible(true);
		
		

	}

}
