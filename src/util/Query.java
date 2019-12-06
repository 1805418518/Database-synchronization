package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query {
	public static void main(String[] args) {
		/*
		Connection conn=null;
	    Statement st=null;
	    ResultSet rs=null;
	    try {
	    	//1、获取连接对象
	    	conn=DBUtil.getConnection();
	    	
	    	//2、创建statement类对象，用来执行SQL语句！！
	    	st=conn.createStatement();
	    	
	    	//创建插入的sql语句
	        String sql1="insert into ct values(1002,'大佬')";
	        //返回一个进行此操作的结果，要么成功，要么失败，如果返回的结果>0就是成功，反之失败
	        int result=st.executeUpdate(sql1);
	        if(result>0) {
	            System.out.println("添加成功");
	        }
	        else {
	            System.out.println("添加失败");
	        }
	        st.close();
	        conn.close();
	    	
	    	//3、创建sql查询语句
	    	String sql2="select * from ct";
	    	//4、执行sql语句并且换回一个查询的结果集
	    	rs=st.executeQuery(sql2);
	    	System.out.println("开始：");
	    	while(rs.next()) {  //循环遍历结果集
	    		int id=rs.getInt("id");
	    		String name=rs.getString("name");
	    		System.out.println("id=" + id + "--" + "name=" + name);
	    		}
	        } catch (Exception e) {
	            e.printStackTrace();
	        }*/
		
		 Connection conn=null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 try {
			 conn = DBUtil.getConnection();
			 //创建sql语句 但先不给出要查询的记录的id
			 String sql = "select * from ct where id=?";
			 //创建预处理对象，对sql语句先进行预处理
			 ps = conn.prepareStatement(sql);
			 //之后再设置参数id
			 ps.setInt(1, 1);
			 //最后在把预处理sql语句进行执行，返回结果集
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 int id=rs.getInt("id");
				 String name=rs.getString("name");
				 System.out.println("id="+id+"--"+"name="+name);
				 }
			 } catch (Exception e) {
				 e.printStackTrace();
				 }
		 }
	}

