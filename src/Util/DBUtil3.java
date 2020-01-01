package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Model.Database;
public class DBUtil3 {
	public static Connection getConnection(Database db) {
		String driver = "oracle.jdbc.driver.OracleDriver";//oracle驱动
		String url = "jdbc:oracle:thin:@"+ db.getAddress()+":1521:"+db.getDatabaseName();//ip:1521:xe
		String username = db.getUsername() +" as "+ "SYSDBA";//数据库用户名 as 连接为（有Normal,SYSDBA,SYSOPER）
		String password =db.getPassword() ;//密码
		Connection connection=null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,username,password);
			//JOptionPane.showMessageDialog(null, "数据库连接成功", "数据库连接成功", JOptionPane.PLAIN_MESSAGE);
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			throw new RuntimeException("class not find!",e);

		}catch(SQLException e2) {
			//e.printStackTrace();
			throw new RuntimeException("get connection error!",e2);
		}
		
		return connection;
	}
	
	public static void testConnection(Database db) {
		String driver = "oracle.jdbc.driver.OracleDriver";//oracle驱动
		String url = "jdbc:oracle:thin:@ "+ db.getAddress()+":1521:"+db.getDatabaseName();//ip:1521:xe
		String username = db.getUsername() +" as "+ "SYSDBA";//数据库用户名 as 连接为（有Normal,SYSDBA,SYSOPER）
		String password =db.getPassword() ;//密码
		Connection connection=null;
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,username,password);
			JOptionPane.showMessageDialog(null, "数据库连接成功", "数据库连接成功", JOptionPane.PLAIN_MESSAGE);
			close(connection);
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			throw new RuntimeException("class not find!",e);

		}catch(SQLException e2) {
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库连接失败", "数据库连接失败", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
