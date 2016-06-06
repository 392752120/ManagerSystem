package com.jishan.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jishan.user.bean.UserBean;
import com.jishan.user.dao.UserDao;

@WebServlet(asyncSupported=true,urlPatterns={"/user/datagrid"})
public class UserServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8482697844065272794L;
	private UserDao userDao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//获取前台页面传过来的第几页
		String page = req.getParameter("page");
		int pageIndex = Integer.parseInt((page==null || page=="0")? "1":page);

		//获取前台传过来的一页显示的记录数
		String rows = (String)req.getParameter("rows");
		int pageSize = Integer.parseInt((rows == null || rows.equals("NaN"))? "10":rows);


		//获取查询的记录数
		List<UserBean> list = userDao.findByPage((pageIndex-1)*pageSize,pageSize);
		
//		req.setAttribute("resultList", list);
		
//		req.getRequestDispatcher("/htmls/dataGrid2.jsp").forward(req, resp);
		Map<String,Object> map = new HashMap<String,Object>();
		int total ;
		if(list.size()==10 || list.size()==5 || list.size()==15){
			//表示还有下一页
			if(userDao.findByPage(pageIndex+1, pageSize).size()>0){
				total = pageSize*(pageIndex)+1;
			}
			else{
				total = pageSize*(pageIndex);
			}
		}
		else{
			total=pageSize*(pageIndex-1)+list.size();
		}
		
		map.put("total",total );
		map.put("rows", list);
		JSONObject result = new JSONObject(map);
		
		System.out.println(result);
		
		
		PrintWriter out = resp.getWriter();
		out.write(result.toString());
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
		
	}
}
