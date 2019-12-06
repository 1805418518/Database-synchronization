package Test;

import javax.swing.JFrame;

import Controller.DatabaseController;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame();
		
		jf.add(new DatabaseController());
		//jf.pack();
		jf.setSize(500, 700);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
