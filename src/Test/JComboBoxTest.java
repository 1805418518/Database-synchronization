package Test;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import Model.Database;

public class JComboBoxTest {

	public static void main(String[] args) {
		JFrame jf = new JFrame("");
		JComboBox<Database> comboBox = new JComboBox<Database>();
		comboBox.addItem(new Database("1","2","3","4"));
		
		jf.add(comboBox);
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
