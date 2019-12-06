package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String driver = "oracle.jdbc.driver.OracleDriver";//oracle����
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";//ip:1521:xe
	private static String username = "sys as sysdba";//���ݿ��û��� as ����Ϊ����Normal,SYSDBA,SYSOPER��
	private static String password = "oracle";//����
	
	public static Connection getConnection() {
		Connection connection=null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,username,password);
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
