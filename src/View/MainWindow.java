package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Model.Database;
import Util.UseXML;

public class MainWindow extends JFrame implements ActionListener, ItemListener {
	private String[] typeName= {"表", "视图", "序列", "包", "存储过程", "函数", "同义词", "分区表", "DB Link", "物化视图"};
	private JTextField stepText;
	//泛型<E>，暂时用<String>类型代替，后面可能改为别的类型
	private static JComboBox<Database> originBox;
	private JButton originEditBtn;
	private JButton originNewBtn;
	private static JComboBox<Database> targetBox;
	private JButton targetEditBtn;
	private JButton targetNewBtn;
	private static JComboBox<Database> controlBox;
	private JButton controlEditBtn;
	private JButton controlNewBtn;
	private JCheckBox[] typeDatabase;
	
	private JButton yes;
	private JButton cancel;
	
	public MainWindow() {
		init();	//控件初始化（new 实体类）
		getDatabases();
		initListen();
		add(getMainJPanel());
		
		pack();
		setTitle("数据库同步");
		//setSize(500, 700);
		setMinimumSize(new Dimension(500, 0));	//高度用pack自适应，宽度使其不小于500
		setLocationRelativeTo(null);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initListen(){
		originEditBtn.addActionListener(this);
		originNewBtn.addActionListener(this);
		
		targetEditBtn.addActionListener(this);
		targetNewBtn.addActionListener(this);
		
		controlEditBtn.addActionListener(this);
		controlNewBtn.addActionListener(this);
		
		yes.addActionListener(this);
		cancel.addActionListener(this);
		
		originBox.addItemListener(this);
		targetBox.addItemListener(this);
		controlBox.addItemListener(this);
	}
	
	private void init() {		
		stepText = new JTextField(15);
		originBox = new JComboBox<>();
		targetBox = new JComboBox<>();
		controlBox = new JComboBox<>();
		
		
		originEditBtn = new JButton("编辑...");
		originNewBtn = new JButton("新建...");
		targetEditBtn = new JButton("编辑...");
		targetNewBtn = new JButton("新建...");
		controlEditBtn = new JButton("编辑...");
		controlNewBtn = new JButton("新建...");
		typeDatabase = new JCheckBox[typeName.length];
		Font font = new Font("黑体", Font.PLAIN, 18);
		for (int i=0; i<typeDatabase.length; i++) {
			typeDatabase[i] = new JCheckBox(typeName[i], true);
			//typeDatabase[i].setSize(new Dimension(50, 50));
			typeDatabase[i].setFont(font);
		}
		yes = new JButton("确定");
		cancel = new JButton("取消");
	}
	
	private JPanel getMainJPanel(){
		JPanel jpanel = new JPanel();
				
		jpanel.setBorder(new EmptyBorder(5, 15, 5, 5));
		jpanel.setLayout(new BorderLayout(10, 10));
		
		jpanel.add(getNorthPanel(), BorderLayout.NORTH);
		jpanel.add(getCenter(), BorderLayout.CENTER);
		jpanel.add(getSouth(), BorderLayout.SOUTH);
		
		return jpanel;
	}

	private JTabbedPane getCenter(){
		JTabbedPane centerPanel = new JTabbedPane();
		Box box = Box.createVerticalBox();
		box.setBorder(new EmptyBorder(0, 20, 0, 0));
		//JPanel box = new JPanel(new GridLayout(typeDatabase.length, 1));
		centerPanel.addTab("数据库对象类型", box);
		for (JCheckBox jCheckBox : typeDatabase) {
			jCheckBox.setOpaque(false);
			box.add(jCheckBox);
		}
		//centerPanel.setPreferredSize(new Dimension(500, 0));
		
		return centerPanel;
	}
	
	private JPanel getNorthPanel(){
		JPanel box = new JPanel();
		
		int SPACE = 5;
		
		JLabel label1 = new JLabel("步骤名称", SwingConstants.RIGHT);
		JLabel label2 = new JLabel("源数据库连接", SwingConstants.CENTER);
		JLabel label3 = new JLabel("目标数据库连接", SwingConstants.RIGHT);
		JLabel label4 = new JLabel("控制数据库连接", SwingConstants.RIGHT);
		
		
		//网格布局
		GridBagLayout layout = new GridBagLayout();
		box.setLayout(layout);
		
		box.add(label1);
		box.add(stepText);
		box.add(label2);
		box.add(originBox);
		box.add(originEditBtn);
		box.add(originNewBtn);
		box.add(label3);
		box.add(targetBox);
		box.add(targetEditBtn);
		box.add(targetNewBtn);
		box.add(label4);
		box.add(controlBox);
		box.add(controlEditBtn);
		box.add(controlNewBtn);
		
		GridBagConstraints s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		
		s.gridwidth = 2;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
		layout.setConstraints(label1, s);
		s.gridwidth = 0;s.weightx = 1;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, 30);
        layout.setConstraints(stepText, s);
		s.gridwidth = 2;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(label2, s);
		s.gridwidth = 2;s.weightx = 1;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(originBox, s);
		s.gridwidth = 1;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(originEditBtn, s);
		s.gridwidth = 0;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(originNewBtn, s);
		s.gridwidth = 2;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(label3, s);
		s.gridwidth = 2;s.weightx = 1;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(targetBox, s);
		s.gridwidth = 1;s.weightx = 0;s.weighty = 0;
        layout.setConstraints(targetEditBtn, s);
		s.gridwidth = 0;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(targetNewBtn, s);
		s.gridwidth = 2;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(label4, s);
		s.gridwidth = 2;s.weightx = 1;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(controlBox, s);
		s.gridwidth = 1;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(controlEditBtn, s);
		s.gridwidth = 0;s.weightx = 0;s.weighty = 0;
        s.insets=new Insets(SPACE, SPACE, SPACE, SPACE);
        layout.setConstraints(controlNewBtn, s);
		
		return box;
	}
	
	private Box getSouth(){
		//JPanel jpanel = new JPanel();
		Box box = Box.createVerticalBox();
		
		JTextArea sqlText = new JTextArea();
		JScrollPane js=new JScrollPane(sqlText);
		js.setBorder(BorderFactory.createTitledBorder("指定需同步表SQL"));
		js.setPreferredSize(new Dimension(0, 150));
		js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		Box btnBox = Box.createHorizontalBox();
		btnBox.add(yes);
		btnBox.add(Box.createHorizontalStrut(20));
		btnBox.add(cancel);
		
		box.add(js);
		box.add(btnBox);
		return box;
	}
	
	private void getDatabases(){
		List<Database> src = UseXML.getDatabases(new File(DatabaseEdit.xmlFileName), DatabaseEdit.SRC_DB);
		for(Database db : src) {
			originBox.addItem(db);
		}
		List<Database> dest = UseXML.getDatabases(new File(DatabaseEdit.xmlFileName), DatabaseEdit.DEST_DB);
		for(Database db : dest) {
			targetBox.addItem(db);
		}
		List<Database> ctrl = UseXML.getDatabases(new File(DatabaseEdit.xmlFileName), DatabaseEdit.CTRL_DB);
		for(Database db : ctrl) {
			controlBox.addItem(db);
		}
	}
	
	public static Database getOriginDB(){
		return (Database)originBox.getSelectedItem();
	}
	
	public static Database getTargetDB(){
		return (Database)targetBox.getSelectedItem();
	}
	
	public static Database getControlDB(){
		return (Database)controlBox.getSelectedItem();
	}
	
	public static boolean addOriginDB(Database db) {
		Database temp;
		for(int i=0; i<originBox.getItemCount(); i++) {
			temp = originBox.getItemAt(i);
			if(temp.getAddress().equals(db.getAddress()) && temp.getDatabaseName().equals(db.getDatabaseName()) && temp.getUsername().equals(db.getUsername())) {
				return false;
			}
		}
		originBox.addItem(db);
		return true;
	}
	
	public static boolean addTargetDB(Database db) {
		Database temp;
		for(int i=0; i<targetBox.getItemCount(); i++) {
			temp = targetBox.getItemAt(i);
			if(temp.getAddress().equals(db.getAddress()) && temp.getDatabaseName().equals(db.getDatabaseName()) && temp.getUsername().equals(db.getUsername())) {
				return false;
			}
		}
		targetBox.addItem(db);
		return true;
	}
	
	public static boolean addControlDB(Database db) {
		Database temp;
		for(int i=0; i<controlBox.getItemCount(); i++) {
			temp = controlBox.getItemAt(i);
			if(temp.getAddress().equals(db.getAddress()) && temp.getDatabaseName().equals(db.getDatabaseName()) && temp.getUsername().equals(db.getUsername())) {
				return false;
			}
		}
		controlBox.addItem(db);
		return true;
	}
	
	public static void editOriginDB(Database db) {
		originBox.removeItem(originBox.getSelectedItem());
		addOriginDB(db);
	}
	
	public static void editTargetDB(Database db) {
		targetBox.removeItem(targetBox.getSelectedItem());
		addTargetDB(db);
	}
	
	public static void editControlDB(Database db) {
		controlBox.removeItem(controlBox.getSelectedItem());
		addControlDB(db);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(originEditBtn)) {
			new DatabaseEdit(this, DatabaseEdit.EDIT_ITEM, DatabaseEdit.SRC_DB);
		}else if(e.getSource().equals(originNewBtn)) {
			new DatabaseEdit(this, DatabaseEdit.NEW_ITEM, DatabaseEdit.SRC_DB);
		}else if(e.getSource().equals(targetEditBtn)) {
			new DatabaseEdit(this, DatabaseEdit.EDIT_ITEM, DatabaseEdit.DEST_DB);
		}else if(e.getSource().equals(targetNewBtn)) {
			new DatabaseEdit(this, DatabaseEdit.NEW_ITEM, DatabaseEdit.DEST_DB);
		}else if(e.getSource().equals(controlEditBtn)) {
			new DatabaseEdit(this, DatabaseEdit.EDIT_ITEM, DatabaseEdit.CTRL_DB);
		}else if(e.getSource().equals(controlNewBtn)) {
			new DatabaseEdit(this, DatabaseEdit.NEW_ITEM, DatabaseEdit.CTRL_DB);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		//System.out.println("1");
		if(e.getSource().equals(originBox)) {
			if(originBox.getSelectedItem() == null) {
				originEditBtn.setEnabled(false);
			}else {
				originEditBtn.setEnabled(true);
			}
		}else if(e.getSource().equals(targetBox)) {
			if(targetBox.getSelectedItem() == null) {
				targetEditBtn.setEnabled(false);
			}else {
				targetEditBtn.setEnabled(true);
			}
		}else if(e.getSource().equals(controlBox)) {
			if(controlBox.getSelectedItem() == null) {
				controlEditBtn.setEnabled(false);
			}else {
				controlEditBtn.setEnabled(true);
			}
		}
	}
	
	
}
