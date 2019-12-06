package Controller;

import java.awt.BorderLayout;import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class DatabaseController extends JPanel {
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
	
	public DatabaseController() {
		Init();
		
		//����
		
		
		//�в�
		JTabbedPane centerPanel = new JTabbedPane();
		JPanel tabPanel = new JPanel();
		centerPanel.addTab("���ݿ��������", tabPanel);
		
		
		//centerPanel.setLayout(new GridLayout(1, 10));
		//centerPanel.setBorder(BorderFactory.createTitledBorder("���ݿ��������"));
		
		
		//�ײ�
		JTextArea sqlText = new JTextArea();
		sqlText.setBorder(BorderFactory.createTitledBorder("ָ����ͬ����SQL"));
		sqlText.setPreferredSize(new Dimension(0, 100));
		
		setBorder(new EmptyBorder(5, 10, 5, 5));
		setLayout(new BorderLayout());
		add(getNorthPanel(), BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(sqlText, BorderLayout.SOUTH);

		//setSize(500, 700);
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
		
	}
	
	private JPanel getNorthPanel(){
		JPanel box = new JPanel();
		
		/*
		box.setLayout(new BoxLayout(box,BoxLayout.X_AXIS));
		
		JPanel leftBox = new JPanel();
		leftBox.setLayout(new BoxLayout(leftBox,BoxLayout.Y_AXIS));
		leftBox.add(new JLabel("��������", SwingConstants.RIGHT));
		leftBox.add(new JLabel("Դ���ݿ�����", SwingConstants.RIGHT));
		leftBox.add(new JLabel("Ŀ�����ݿ�����", SwingConstants.RIGHT));
		leftBox.add(new JLabel("�������ݿ�����", SwingConstants.RIGHT));
		
		JPanel rightBox = new JPanel();
		rightBox.setLayout(new BoxLayout(rightBox,BoxLayout.Y_AXIS));
		JPanel r1 = new JPanel(new FlowLayout());
		r1.add(originBox);
		r1.add(originEditBtn);
		r1.add(originNewBtn);
		JPanel r2 = new JPanel(new FlowLayout());
		r2.add(targetBox);
		r2.add(targetEditBtn);
		r2.add(targetNewBtn);
		JPanel r3 = new JPanel(new FlowLayout());
		r3.add(controlBox);
		r3.add(controlEditBtn);
		r3.add(controlNewBtn);
		
		rightBox.add(stepText);
		rightBox.add(r1);
		rightBox.add(r2);
		rightBox.add(r3);
		
		
		box.add(leftBox);
		box.add(rightBox);
		
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
		*/
		int SPACE = 5;
		
		JLabel label1 = new JLabel("��������", SwingConstants.RIGHT);
		JLabel label2 = new JLabel("Դ���ݿ�����", SwingConstants.CENTER);
		JLabel label3 = new JLabel("Ŀ�����ݿ�����", SwingConstants.RIGHT);
		JLabel label4 = new JLabel("�������ݿ�����", SwingConstants.RIGHT);
		
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
		//GridBagConstraints s = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,  new Insets(5, 5, 5, 5), 10, 10);
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
}
