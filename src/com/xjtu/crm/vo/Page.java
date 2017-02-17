package com.xjtu.crm.vo;

import java.util.ArrayList;
import java.util.List;

public class Page {
   private int allRecordNO;
   private int currPageNO = 0;
   private int perPageNO = 3;
   private int allPageNO ;
   List<Customer> customerList = new ArrayList<>();
   public Page(){}
   
public List<Customer> getCustomerList() {
	return customerList;
}

public void setCustomerList(List<Customer> customerList) {
	this.customerList = customerList;
}

public int getAllRecordNO() {
	return allRecordNO;
}
public void setAllRecordNO(int allRecordNO) {
	this.allRecordNO = allRecordNO;
	if(this.allRecordNO % this.perPageNO == 0){
		this.allPageNO = this.allRecordNO % this.perPageNO;
	}else{
		this.allPageNO = this.allRecordNO % this.perPageNO + 1;
	}
}
public int getCurrPageNO() {
	return currPageNO;
}
public void setCurrPageNO(int currPageNO) {
	this.currPageNO = currPageNO;
}
public int getPerPageNO() {
	return perPageNO;
}
public void setPerPageNO(int perPageNO) {
	this.perPageNO = perPageNO;
}
public int getAllPageNO() {
	return allPageNO;
}
public void setAllPageNO(int allPageNO) {
	this.allPageNO = allPageNO;
}

   
}
