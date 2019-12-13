package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import sqltongbu.button;

public class DBUtil {
	
	
	public static Connection   getConnection() {
		 String driver = "oracle.jdbc.driver.OracleDriver";//oracle驱动
		 String url = "jdbc:oracle:thin:@ 127.0.0.1:1521:HR";//ip:1521:xe
		 String username = "hr";//数据库用户名 as 连接为（有Normal,SYSDBA,SYSOPER）
		 String password ="hr" ;//密码
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
