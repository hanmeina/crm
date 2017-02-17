package com.xjtu.crm.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.xjtu.crm.service.CrmService;
import com.xjtu.crm.vo.Customer;
import com.xjtu.crm.vo.Page;

/**
 * Servlet implementation class CrmServlet
 */
public class CrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   CrmService crmService = new CrmService();
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
	    System.out.println(method);
		if(method!=null){
			if(method.equals("findAllCustomer")){
				
				this.findAllCustomer(request, response); 
			}else if(method.equals("findCustomerById")){
				//System.out.println("findCustomerById");
				this.findCustomerById(request, response);
			}else if(method.equals("deleteCustomerById")){
				this.deleteCustomerById(request, response);
				
			}
		}
	} 

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public void deleteCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("deleteCustomerById");
		String ids = request.getParameter("ids");
		String[] idStrings = ids.split("_");
		try {
			crmService.deleteCustomerById(idStrings);
			request.setAttribute("message", "批量删除成功"); 
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "批量删除出错"); 
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}
		
	}
	public void findCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println("进来了");
		Customer customer =null;
		try {
			customer = crmService.findCustomerById(id);
			//System.out.println(customer.getName());
			if(customer!=null){
				request.setAttribute("customer", customer); 
				request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "编辑用户信息失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);;
		}
		
	}
    private void findAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("jianle ");
    	int currPageNO = Integer.parseInt(request.getParameter("currPageNO"));
		try {
			Page  page = crmService.findAllCustomer(currPageNO);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "查询用户所有信息失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}
		
	}
}
