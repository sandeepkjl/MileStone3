<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Account Details</h2>
	<table border="2px">
	<tr><td>AccountId</td> <td>CustomerID</td> <td>CustomerName</td> <td>Balance</td></tr>
	   <c:forEach var="account" items="${accounts}">
		 <tr>
            <td>${account.getAccountID()}</td>
            <td>${account.getCustomer().getCustomerID()}</td>
            <td>${account.getCustomer().getName()}</td>
            <td>${account.getBalance()}</td>
          </tr> 
	   </c:forEach>
	 </table>
		
</body>
</html>