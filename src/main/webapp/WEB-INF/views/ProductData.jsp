<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Curd Operation</title>
<style>
#heading{
color: blue;
font-size: 20px;
text-align: center;
}
#table{
background-color: yellow;
text-shadow: blue;
font-style: italic;
text-align: center;
color:red;

}
body{
background-color:gray;
}
#tr{
background-color: red;
}


</style>
</head>
<body>
<table align="center" >
	<tr>
		<td> <a href="register">REGISTER</a> </td>
		<td> <a href="all">VIEW ALL</a> </td>
	</tr>
</table>
<hr/>
<H3 id="heading">WELCOME TO PRODUCT DATA PAGE</H3>
<table align="center" border="1" id="table">
	<tr>
		<th>ID</th>
		<th>CODE</th>
		<th>MODLE</th>
		<th>NOTE</th>
		<th>VENDOR</th>
		<th colspan="2">OPERATION</th>
	</tr>
	<c:forEach items="${page.getContent()}" var="ob">
		<tr bgcolor="pink">
			<td>${ob.prodId}</td>
			<td>${ob.prodCode}</td>
			<td>${ob.prodModel}</td>
			<td>${ob.prodNote}</td>
			<td>${ob.prodVendor}</td>
			<td ><a href="delete?pid=${ob.prodId}">DELETE</a></td>
			<td><a href="edit?pid=${ob.prodId}">EDIT</a></td>
		</tr>
	</c:forEach>
</table>
${message}<br/>

 <c:if test="${!page.isFirst() }">
	<a href="?page=0">First</a>
</c:if>
<c:if test="${page.hasPrevious() }">
	<a href="?page=${page.getNumber()-1}">Previous</a>
</c:if>
<!-- for(int=0;i<totalPages;i++)-->
<c:forEach begin="0" end="${page.getTotalPages()-1}" var="i">
	<a href="?page=${i}">${i+1}</a> &nbsp;&nbsp;
</c:forEach>
<c:if test="${page.hasNext() }">
	<a href="?page=${page.getNumber()+1}">Next</a>
</c:if>
<c:if test="${!page.isLast() }">
	<a href="?page=${page.getTotalPages()-1}">Last</a>
</c:if> 
</body>
</html>