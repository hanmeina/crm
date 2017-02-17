package com.xjtu.crm.web.servlet;

import java.util.List;

import com.xjtu.crm.service.CrmService;
import com.xjtu.crm.vo.Customer;
import com.xjtu.crm.vo.Page;

public class CrmServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      CrmService crmService = new CrmService();
      try {
		Page page = crmService.findAllCustomer(2);
	    List<Customer> customers = page.getCustomerList();
	    if(customers!=null){
	    	for(Customer c: customers){
	    		System.out.println("ÓÃ»§Ãû"+c.getName());
	    	}
	    }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
