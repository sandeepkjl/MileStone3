<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Details</title>
</head>
<body>

<h3>Account Details for Account Id : ${account.getAccountID()} </h3></br>
</br>

AccountId : ${account.getAccountID()} </br>
CustomerId : ${account.getCustomer().getCustomerID()} </br>
CustomerName : ${account.getCustomer().getName()} </br>
Balance : ${account.getBalance()} </br>


</body>
</html>