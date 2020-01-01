package View;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Model.Database;
import Util.DBUtil3;
import Util.UseXML;

public class DatabaseEdit extends JDialog{
	public static final String EDIT_ITEM = "编辑";
	public static final String NEW_ITEM = "新建";
	public static final String SRC_DB = "源数据库";
	public static final String DEST_DB = "目标数据库";
	public static final String CTRL_DB = "控制数据库";
	
	public static String xmlFileName = "database_save.xml";
	
	private String item_type="";
	private String db_type="";
	private JTextField addressText;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JTextField databaseNameText;
	private JButton commitBtn;
	private JButton testBtn;
	
	public DatabaseEdit(Frame owner, String item_type, String db_type) {
		super(owner, true);
		this.item_type = item_type;
		this.db_type = db_type;
		init();
		initListen();
		add(getMainJPanel());
		pack();
		setLocationRelativeTo(getParent());
		setTitle(item_type+db_type);
		setVisible(true);
	}
	
	private void initListen(){
		commitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Database db = getDatabase();
				switch(db_type) {
				case SRC_DB:
					if(item_type.equals(EDIT_ITEM)) {
						UseXML.removeDatabase(new File(xmlFileName), db_type, MainWindow.getOriginDB());
						UseXML.addDatabase(new File(xmlFileName), db_type, db);
						MainWindow.editOriginDB(db);
					}else if(item_type.equals(NEW_ITEM)) {
						if(MainWindow.addOriginDB(db)) {
							UseXML.addDatabase(new File(xmlFileName), db_type, db);
						}
					}
					break;
				case DEST_DB:
					if(item_type.equals(EDIT_ITEM)) {
						UseXML.removeDatabase(new File(xmlFileName), db_type, MainWindow.getTargetDB());
						UseXML.addDatabase(new File(xmlFileName), db_type, db);
						MainWindow.editTargetDB(db);
					}else if(item_type.equals(NEW_ITEM)) {
						if(MainWindow.addTargetDB(db)) {
							UseXML.addDatabase(new File(xmlFileName), db_type, db);
						}
					}
					break;
				case CTRL_DB:
					if(item_type.equals(EDIT_ITEM)) {
						UseXML.removeDatabase(new File(xmlFileName), db_type, MainWindow.getControlDB());
						UseXML.addDatabase(new File(xmlFileName), db_type, db);
						MainWindow.editControlDB(db);
					}else if(item_type.equals(NEW_ITEM)) {
						if(MainWindow.addControlDB(db)) {
							UseXML.addDatabase(new File(xmlFileName), db_type, db);
						}
					}
					break;
				}
			}
		});
		testBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Database db = getDatabase();
				switch(db_type) {
				case SRC_DB:
					DBUtil3.testConnection(db);
					System.out.println("add="+db.getAddress());
					System.out.println("db="+db.getDatabaseName());
					System.out.println("user="+db.getUsername());
					System.out.println("pass="+db.getPassword());
					break;
				case DEST_DB:
					DBUtil3.testConnection(db);
					break;
				case CTRL_DB:
					DBUtil3.testConnection(db);
					break;
				}
				
			}
		});
	}
	
	private void init() {
		final int columns = 12;
		addressText = new JTextField("127.0.0.1", columns);
		usernameText = new JTextField(columns);
		passwordText = new JPasswordField(columns);
		databaseNameText = new JTextField(columns);
		commitBtn = new JButton("提交");
		testBtn = new JButton("测试");
		
		if(item_type.equals(EDIT_ITEM)) {
			Database db = MainWindow.getOriginDB();
			addressText.setText(db.getAddress());
			usernameText.setText(db.getUsername());
			passwordText.setText(db.getPassword());
			databaseNameText.setText(db.getDatabaseName());
		}
	}
	
	private JPanel getMainJPanel(){
		JPanel jpanel = new JPanel();
				
		jpanel.setBorder(new EmptyBorder(25, 25, 25, 25));
		jpanel.setLayout(new BorderLayout(10, 10));
		
		//jpanel.add(getNorthPanel(), BorderLayout.NORTH);
		jpanel.add(getCenter(), BorderLayout.CENTER);
		jpanel.add(getSouth(), BorderLayout.SOUTH);
		
		return jpanel;
	}
	
	private JPanel getCenter(){
		JPanel box = new JPanel();
		List<JLabel> labelList = new ArrayList<>();
		labelList.add(new JLabel("地址"));
		labelList.add(new JLabel("帐号"));
		labelList.add(new JLabel("密码"));
		labelList.add(new JLabel("库名"));
		int SPACE = 5;
		
		//网格布局
		GridBagLayout layout = new GridBagLayout();
		box.setLayout(layout);
		
		box.add(labelList.get(0));
		box.add(addressText);
		box.add(labelList.get(1));
		box.add(usernameText);
		box.add(labelList.get(2));
		box.add(passwordText);
		box.add(labelList.get(3));
		box.add(databaseNameText);

		
		GridBagConstraints s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		
		s.gridwidth = 2;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
		layout.setConstraints(labelList.get(0), s);
		s.gridwidth = 0;s.weightx = 1;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(addressText, s);
		s.gridwidth = 2;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(labelList.get(1), s);
		s.gridwidth = 0;s.weightx = 1;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(usernameText, s);
		s.gridwidth = 2;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(labelList.get(2), s);
		s.gridwidth = 0;s.weightx = 1;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(passwordText, s);
		s.gridwidth = 2;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(labelList.get(3), s);
		s.gridwidth = 0;s.weightx = 1;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(databaseNameText, s);
		
		return box;
	}
	
	private Database getDatabase(){
		return new Database(addressText.getText(), usernameText.getText(), passwordText.getText(), databaseNameText.getText());
	}
	
	private Box getSouth(){
		Box box = Box.createVerticalBox();
		Box btnBox = Box.createHorizontalBox();
		btnBox.add(commitBtn);
		btnBox.add(Box.createHorizontalStrut(20));
		btnBox.add(testBtn);
		box.add(btnBox);
		return box;
	}
}
