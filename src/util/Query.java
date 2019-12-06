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
	    	//1����ȡ���Ӷ���
	    	conn=DBUtil.getConnection();
	    	
	    	//2������statement���������ִ��SQL��䣡��
	    	st=conn.createStatement();
	    	
	    	//���������sql���
	        String sql1="insert into ct values(1002,'����')";
	        //����һ�����д˲����Ľ����Ҫô�ɹ���Ҫôʧ�ܣ�������صĽ��>0���ǳɹ�����֮ʧ��
	        int result=st.executeUpdate(sql1);
	        if(result>0) {
	            System.out.println("��ӳɹ�");
	        }
	        else {
	            System.out.println("���ʧ��");
	        }
	        st.close();
	        conn.close();
	    	
	    	//3������sql��ѯ���
	    	String sql2="select * from ct";
	    	//4��ִ��sql��䲢�һ���һ����ѯ�Ľ����
	    	rs=st.executeQuery(sql2);
	    	System.out.println("��ʼ��");
	    	while(rs.next()) {  //ѭ�����������
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
			 //����sql��� ���Ȳ�����Ҫ��ѯ�ļ�¼��id
			 String sql = "select * from ct where id=?";
			 //����Ԥ������󣬶�sql����Ƚ���Ԥ����
			 ps = conn.prepareStatement(sql);
			 //֮�������ò���id
			 ps.setInt(1, 1);
			 //����ڰ�Ԥ����sql������ִ�У����ؽ����
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

