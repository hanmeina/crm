package com.xjtu.myday12.servlet;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;



import com.xjtu.util.JdbcUtil;

import javafx.beans.binding.StringBinding;



//����Ԫ���ݷ���
public class MetaData {
	
	public static void main(String[] args) throws SQLException{
		Connection conn = JdbcUtil.getMySqlConnection();
	
		//3.ResultSetMetaData�������йص�Ԫ����
		String sql = "select * from account";
		PreparedStatement pstmt  = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rSetMetaData = rs.getMetaData();
		int size = rSetMetaData.getColumnCount();
	//	System.out.println(size);
		for(int i = 1;i<=size;i++){
			String columnName = 	  rSetMetaData.getColumnName(i);
			//��jdkApi��Types 
			int columnType = rSetMetaData.getColumnType(i);
			
			System.out.println(columnName +":"+columnType);
				  
				
			}
		//2.parameterMetaData��sql�й�
	/*	String sql = "insert into account(id,name,salary) values(?,?,?)";
		PreparedStatement pstmt  = conn.prepareStatement(sql);
		ParameterMetaData para = pstmt.getParameterMetaData();
		int size = para.getParameterCount();
	   	System.out.println("size:"+size);
		
		*/
		/*//1.DataMetaData
		DatabaseMetaData  data  =  conn.getMetaData();
		String driver = data.getDriverName();
		String url = data.getURL();
		//level�ɲ�JdkApi��Types
		int level = data.getDefaultTransactionIsolation();
		String productName = data.getDatabaseProductName();
		boolean flag = data.isReadOnly();
		System.out.println("driver:"+driver);
		System.out.println("url:"+url);
		System.out.println("level:"+level);
		System.out.println("productName:"+productName);
		System.out.println("isReadOnly:"+flag);
		*/
		
	}


}
