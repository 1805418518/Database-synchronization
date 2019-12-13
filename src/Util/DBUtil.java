package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import sqltongbu.button;

public class DBUtil {
	
	
	public static Connection   getConnection() {
		 String driver = "oracle.jdbc.driver.OracleDriver";//oracle����
		 String url = "jdbc:oracle:thin:@ 127.0.0.1:1521:HR";//ip:1521:xe
		 String username = "hr";//���ݿ��û��� as ����Ϊ����Normal,SYSDBA,SYSOPER��
		 String password ="hr" ;//����
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
