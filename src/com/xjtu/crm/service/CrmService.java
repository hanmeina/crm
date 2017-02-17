package com.xjtu.crm.service;

import java.sql.SQLException;
import java.util.List;

import com.xjtu.crm.dao.CrmDao;
import com.xjtu.crm.vo.Customer;
import com.xjtu.crm.vo.Page;

public class CrmService {
 CrmDao  crmDao = new CrmDao();
 /**
  * 根据id删除客户
  * @param ids
  * @return
  * @throws Exception
  */
 public void  deleteCustomerById(String[] ids) throws Exception{
	
	 try {
		 for(String id:ids){
			 
			 crmDao.deleteCustomerById(Integer.parseInt(id));
		 }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new Exception();
	}
	 
	 
 }
 /**
  * 根据id查询客户
  * @param id
  * @return
  * @throws Exception
  */
 public Customer findCustomerById(int id) throws Exception{
	 try {
		return crmDao.findCustomerById(id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new Exception();
	}
	 
 }
 
 /**
  * 分页显示客户信息
  * @param currPageNO
  * @return
 * @throws Exception 
  * @throws SQLException
  */
 public Page  findAllCustomer(int currPageNO) throws Exception{
	 Page page = new Page();
	  
	try {
		int allRecordNO = crmDao.findAllRecordNO();
		page.setAllRecordNO(allRecordNO);
		page.setCurrPageNO(currPageNO);
		int size = page.getPerPageNO();
		int start = (page.getCurrPageNO()-1) * page.getPerPageNO();
		List<Customer> customerList = crmDao.findAllCustomer(start, size);
	    page.setCustomerList(customerList);
	  } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new Exception();
	 }
   	  return page;
 
 }
 
}
