<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td> <a href="register">REGISTER</a> </td>
		<td> <a href="all">VIEW ALL</a> </td>
	</tr>
</table>
<hr/>
<H3>WELCOME TO PRODUCT EDIT PAGE</H3>
<form:form action="update" method="POST" modelAttribute="product">
<pre>
 ID     : <form:input path="prodId" readonly="true"/>
 CODE   : <form:input path="prodCode"/>
 MODEL  : 
          <form:radiobutton path="prodModel" value="MEDIUM"/> MEDIUM
          <form:radiobutton path="prodModel" value="SMALL"/> SMALL
          <form:radiobutton path="prodModel" value="HIGH"/> HIGH
 NOTE : <form:textarea path="prodNote"/>
 VENDOR: <form:select path="prodVendor">
 			<form:option value="">-SELECT-</form:option>
 			<form:option value="NIT">NIT</form:option>
 			<form:option value="SAMSUNG">SAMSUNG</form:option>
 			<form:option value="HERO">HERO</form:option>
 		</form:select>
 OPTIONS: 
      <form:checkbox path="prodOption" value="GRADE-A"/>GRADE-A
      <form:checkbox path="prodOption" value="GRADE-B"/>GRADE-B
      <form:checkbox path="prodOption" value="GRADE-C"/>GRADE-C
 KEY CODE: <form:password path="prodKeyCode"/>
 	<input type="submit" value="Update Product" />
</pre>
</form:form>
</body>
</html>