package com.xjtu.myday12.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xjtu.myday12.vo.Department;
import com.xjtu.myday12.vo.Employee;

public class One2Many {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
         Department department = new Department();
         department.setName("�����");
         
         Employee employee1 = new Employee();
         employee1.setName("С��");
        
         Employee employee2 = new Employee();	 
         employee2.setName("С��");
      
        
         List<Employee> employeeList = new ArrayList<>();
         employeeList.add(employee1);
         employeeList.add(employee2);
         
         department.setEmployeeList(employeeList);
         employee1.setDepartment(department);
         employee2.setDepartment(department);
         //���沿��ʱͬʱ�����Ӧ��Ա����¼
         Dao  dao  = new Dao();
         dao.save(department);
	}

}
