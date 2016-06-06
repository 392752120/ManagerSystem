package com.jishan.dbUtils;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBUtils {
	private static Connection conn = null;
	private static String url = "jdbc:mysql://localhost:3306/datagird_user?useUnicode=true&characterEncoding=utf-8";
	private static String username = "root";
	private static String password = "3972";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("找不到驱动程序类，驱动程序加载失败！");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			if(conn == null){
				conn = (Connection) DriverManager.getConnection(url, username, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){
		
			try {
				if (rs!= null){
					rs.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(ps!=null){
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						if(conn!=null){
							try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	
}
