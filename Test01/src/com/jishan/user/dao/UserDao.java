package com.jishan.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.jishan.dbUtils.DBUtils;
import com.jishan.user.bean.UserBean;

public class UserDao {
	public List<UserBean> findByPage(int start,int pageNumber){
		List<UserBean> list = new ArrayList<UserBean>();
		Connection conn ;
		PreparedStatement ps;
		ResultSet rs;
		String sql = "select * from user_info limit "+start+","+pageNumber+"";
		try{
		conn = DBUtils.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()){
			UserBean userBean = new UserBean();
			userBean.setName(rs.getString("name"));
			userBean.setAge(rs.getString("age"));
			userBean.setSex(rs.getString("sex"));
			list.add(userBean);
		}
		System.out.println(list);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public int findAllCount() {
		// TODO Auto-generated method stub
		int rowcount = 0 ;
		Connection conn ;
		PreparedStatement ps;
		ResultSet rs;
		String sql = "select count(*) record from user_info";
		try{
		conn = DBUtils.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()){
			rowcount = rs.getInt("record");
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rowcount;
	}
	
}
