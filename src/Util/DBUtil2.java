package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class DBUtil2 {
	public static Connection   getConnection(String ac_user,String ac_password,String ac_surface,String ac_address) {
		 String driver = "oracle.jdbc.driver.OracleDriver";//oracle����
		 String url = "jdbc:oracle:thin:@"+ ac_address+":1521:"+ac_surface;//ip:1521:xe
		 String username = ac_user +" as "+ "SYSDBA";//���ݿ��û��� as ����Ϊ����Normal,SYSDBA,SYSOPER��
		 String password =ac_password ;//����
		Connection connection=null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,username,password);
			JOptionPane.showMessageDialog(null, "���ݿ����ӳɹ�", "���ݿ����ӳɹ�", JOptionPane.PLAIN_MESSAGE);

		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			throw new RuntimeException("class not find!",e);

		}catch(SQLException e2) {
			//e.printStackTrace();
			throw new RuntimeException("get connection error!",e2);
		}
		
		return connection;
	}
}
