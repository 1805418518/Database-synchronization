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
		
			 //����sql��� ���Ȳ�����Ҫ��ѯ�ļ�¼��id
	         String sql = "select * from users";
			 //String sql = "select * from ct where id=?";
			 //����Ԥ������󣬶�sql����Ƚ���Ԥ����
			 ps = conn.prepareStatement(sql);
			 //֮�������ò���id
			 //ps.setInt(1, 1);
			 //����ڰ�Ԥ����sql������ִ�У����ؽ����
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

