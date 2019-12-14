package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class DBUtil2 {
	public static int   getConnection(String ac_user,String ac_password,String ac_surface,String ac_address) {
		 String driver = "oracle.jdbc.driver.OracleDriver";//oracle驱动
		 String url = "jdbc:oracle:thin:@"+ ac_address+":1521:"+ac_surface;//ip:1521:xe
		 String username = ac_user;//数据库用户名 as 连接为（有Normal,SYSDBA,SYSOPER）
		 String password =ac_password ;//密码
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
