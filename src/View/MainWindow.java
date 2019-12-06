package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

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

import Controller.DatabaseController;

public class MainWindow extends JFrame {
	private String[] typeName= {"��", "��ͼ", "����", "��", "�洢����", "����", "ͬ���", "������", "DB Link", "�ﻯ��ͼ"};
	private JTextField stepText;
	//����<E>����ʱ��<String>���ʹ��棬������ܸ�Ϊ�������
	private JComboBox<String> originBox;
	private JButton originEditBtn;
	private JButton originNewBtn;
	private JComboBox<String> targetBox;
	private JButton targetEditBtn;
	private JButton targetNewBtn;
	private JComboBox<String> controlBox;
	private JButton controlEditBtn;
	private JButton controlNewBtn;
	private JCheckBox[] typeDatabase;
	
	private JButton yes;
	private JButton cancel;
	
	public MainWindow() {
		Init();	//�ؼ���ʼ����new ʵ���ࣩ
		add(getMainJPanel());
		
		pack();
		setTitle("���ݿ�ͬ��");
		//setSize(500, 700);
		setMinimumSize(new Dimension(500, 0));	//�߶���pack����Ӧ�����ʹ�䲻С��500
		setLocationRelativeTo(null);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void Init() {		
		stepText = new JTextField(15);
		originBox = new JComboBox<>();
		targetBox = new JComboBox<>();
		controlBox = new JComboBox<>();
		originEditBtn = new JButton("�༭...");
		originNewBtn = new JButton("�½�...");
		targetEditBtn = new JButton("�༭...");
		targetNewBtn = new JButton("�½�...");
		controlEditBtn = new JButton("�༭...");
		controlNewBtn = new JButton("�½�...");
		typeDatabase = new JCheckBox[typeName.length];
		Font font = new Font("����", Font.PLAIN, 18);
		for (int i=0; i<typeDatabase.length; i++) {
			typeDatabase[i] = new JCheckBox(typeName[i], true);
			//typeDatabase[i].setSize(new Dimension(50, 50));
			typeDatabase[i].setFont(font);
		}
		yes = new JButton("ȷ��");
		cancel = new JButton("ȡ��");
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
		centerPanel.addTab("���ݿ��������", box);
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
		
		JLabel label1 = new JLabel("��������", SwingConstants.RIGHT);
		JLabel label2 = new JLabel("Դ���ݿ�����", SwingConstants.CENTER);
		JLabel label3 = new JLabel("Ŀ�����ݿ�����", SwingConstants.RIGHT);
		JLabel label4 = new JLabel("�������ݿ�����", SwingConstants.RIGHT);
		
		
		//���񲼾�
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
		js.setBorder(BorderFactory.createTitledBorder("ָ����ͬ����SQL"));
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
	
	
}
