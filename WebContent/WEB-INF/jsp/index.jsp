<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
</head>
  <body>
    <script type="text/javascript">
    	function fy(){
    		//定位到inputID所对应的元素
    		var inputElement = document.getElementById("inputID");
    		var currPageNO = inputElement.value;
    		var url = "/myday12/CrmServlet?method=findAllCustomer&currPageNO="+currPageNO;
    		window.location.href = url;
    	}
    	function deleteAll(){
    		//定位到tableID所对应的元素，即<table>标签
    		//var tableElement = document.getElementById("tableID");
    		//var size = tableElement.rows.length;//size=5
    		//装ID号的数组
    		var ids = "";
    		//for(var i=1;i<=size-2;i++){
    			//取得每行的1列中的checkbox元素
    			//var checkboxElement = tableElement.rows(i).cells(0).firstChild;
    			//var checkboxElement = $("input:checkbox");
    			//alert(checkboxElement.checked);
    			//如果该复选框被选中
    			//if(checkboxElement.attr("checked")){
    				//收集该复选框的ID值
    				//ids += checkboxElement.val() + "_";
    			//}
    		//}
    		//Jquery实现
    		var ids = "";
    		$("input[name=checkbox]:checked").each(function(){ 			
    			ids += $(this).val()+"_";
    		});
    
    		 //alert(ids);    		
    		//ids="1_2_3_"
    		var url = "/myday12/CrmServlet?method=deleteCustomerById&ids="+ids;
    		window.location.href = url;
    	}
    	
    </script>
  	<table id="tableID" border="1" align="center" width="80%">
  		<caption><h1>客户信息</h1></caption>
  		<tr>
  			<th>状态</th>
  			<th>姓名</th>
  			<th>性别</th>
  			<th>地址</th>
  			<th>电话</th>
  			<th>邮箱</th>
  			<th>生日</th>
  		</tr>
  		<c:forEach var="customer" items="${page.customerList}">
  			<tr>
  				<td>
  					<input type="checkbox" name ="checkbox" value="${customer.id}"/>
  				</td>
  				<td>${customer.name}</td>
  				<td>${customer.gender}</td>
  				<td>${customer.address}</td>
  				<td>${customer.tel}</td>
  				<td>${customer.email}</td>
  				<td>${customer.birthday}</td>
  				<td>
  					<a href="/myday12/CrmServlet?method=findCustomerById&id=${customer.id}" style="text-decoration:none">[编辑]</a>
  				</td>
  			</tr>
  		</c:forEach>
  		<tr>
  			<td colspan="7" align="center">
  				<input type="button" value="删除" onclick="deleteAll()"/>
  				<input id="inputID" type="text" size="1" name="currPageNO"/>
  				<input type="button" value="GO" onclick="fy()"/>
  			</td>
  		</tr>
  	</table>
  </body>
</html>
