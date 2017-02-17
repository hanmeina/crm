package com.xjtu.crm.dao;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xjtu.crm.vo.Customer;
import com.xjtu.crm.vo.Page;
import com.xjtu.util.JdbcUtil;

public class CrmDao {
	QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
  /**
   * 分页查询所有客户信息
   * @param start
   * @param size
   * @return
   */
	
   public List<Customer> findAllCustomer(int start,int size) throws SQLException{	  
	  List<Customer> customerList = null;
	  String sql = "select * from customer limit ?,?";
	  customerList = (List<Customer>) queryRunner.query(sql, new BeanListHandler(Customer.class), new Object[]{start,size});
      return customerList;
   }
   
   /**
    * 通过id删除用户
    * @param id
    * @return
    * @throws SQLException
    */
   public void deleteCustomerById(int id) throws SQLException{
	   String sql = "delete from customer where id=?";
	   queryRunner.update(sql,id);
	 
   }
   /**
    * 通过id查找某个客户
    * @param id
    * @return
    * @throws SQLException
    */
   public Customer findCustomerById(int id) throws SQLException{
	   String sql = "select * from customer where id=?";
	   Customer customer = (Customer) queryRunner.query(sql, new BeanHandler(Customer.class),id);
	   return customer;
   }
   
   
   //得到总客户数
   public int findAllRecordNO() throws SQLException{
	   int sum = 0;
	   String sql = "select count(*) from customer";
	   Object[] objects =  queryRunner.query(sql, new ArrayHandler());
	   Long temp = (Long)objects[0];
	   sum = temp.intValue();
	   return sum;
   }
}
