<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.xjtu.crm.vo.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <%
     Customer customer = (Customer)request.getAttribute("customer");
  	 java.util.Date birthday = customer.getBirthday();
     Calendar c = Calendar.getInstance();
     //java.util.Date转为java.util.Calendar
     c.setTime(birthday);
     //分别取得年/月/日
     String strY = c.get(Calendar.YEAR) + "";
     String strM = c.get(Calendar.MONTH) + 1 + "";
     String strD = c.get(Calendar.DATE) + "";
	
	 int y = Integer.parseInt(strY);
	 int m = Integer.parseInt(strM);
	 int d = Integer.parseInt(strD);
	 //放到域对象
	 pageContext.setAttribute("y",y);
	 pageContext.setAttribute("m",m);
	 pageContext.setAttribute("d",d);
	 
  %>
  

  <body>
  	<table border="1" align="center" width="60%">
  		<caption><h1>更新客户信息</h1></caption>
  		<tr>
  			<th>姓名</th>
  			<td><input type="text" name="name" value="${customer.name}"/></td>
  		</tr>
  		<tr>
  			<th>性别</th>
  			<td>
  				<input ${customer.gender=='男'?'checked':''} type="radio" name="gender" value="男"/>男
  				<input ${customer.gender=='女'?'checked':''} type="radio" name="gender" value="女"/>女
  			</td>
  		</tr>
  		<tr>
  			<th>地址</th>
  			<td><input type="text" name="address" value="${customer.address}"/></td>
  		</tr>
  		<tr>
  			<th>电话</th>
  			<td><input type="text" name="tel" value="${customer.tel}"/></td>
  		</tr>
  		<tr>
  			<th>邮箱</th>
  			<td><input type="text" name="email" value="${customer.email}"/></td>
  		</tr>
  		<tr>
  			<th>生日</th>
  			<td>
  				<select>
  					<c:forEach var="year" begin="1990" end="2001">
  						<option ${y==year?'selected':''}>${year}</option>
   					</c:forEach>
  				</select>年
  				<select>
  					<c:forEach var="month" begin="1" end="12">
  						<option ${m==month?'selected':''}>${month}</option>
  					</c:forEach>
   				</select>月
  				<select>
  					<c:forEach var="date" begin="1" end="31">
  						<option ${d==date?'selected':''}>${date}</option>
  					</c:forEach>
  				</select>日
  			</td>
  		</tr>
  	</table>
  </body>
</html>
