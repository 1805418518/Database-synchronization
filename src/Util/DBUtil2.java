package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class DBUtil2 {
	public static int   getConnection(String ac_user,String ac_password,String ac_surface,String ac_address) {
		 String driver = "oracle.jdbc.driver.OracleDriver";//oracle����
		 String url = "jdbc:oracle:thin:@"+ ac_address+":1521:"+ac_surface;//ip:1521:xe
		 String username = ac_user;//���ݿ��û��� as ����Ϊ����Normal,SYSDBA,SYSOPER��
		 String password =ac_password ;//����
		Connection connection=null;
		int a ;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,username,password);
			a=0;
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
				a=1;
		}catch(SQLException e2) {
			//e.printStackTrace();
			a=2;
			}
		
		return a;
	}
}
