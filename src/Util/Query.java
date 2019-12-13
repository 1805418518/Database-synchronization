package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query {
	public static void main(String[] args) {
		
		
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 try {
			 conn = DBUtil.getConnection();
			 
			/* String sql1="insert into ct values(?,?)";
	         ps=conn.prepareStatement(sql1);
	         ps.setInt(1, 1);
	         ps.setString(2, "zyy");*/
	         //ps.executeUpdate();
		
			 //创建sql语句 但先不给出要查询的记录的id
	         String sql = "select * from users";
			 //String sql = "select * from ct where id=?";
			 //创建预处理对象，对sql语句先进行预处理
			 ps = conn.prepareStatement(sql);
			 //之后再设置参数id
			 //ps.setInt(1, 1);
			 //最后在把预处理sql语句进行执行，返回结果集
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 int id=rs.getInt("id");
				 String name=rs.getString("username");
				 System.out.println("id="+id+"--"+"name="+name);
				 }
			 } catch (Exception e) {
				 e.printStackTrace();
				 }
		 }
	}

