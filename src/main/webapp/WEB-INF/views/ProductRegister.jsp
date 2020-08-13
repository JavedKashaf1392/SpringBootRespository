<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Curd Operation</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style type="text/css">
.errorTxt{
	color: red;
}
</style>

</head>
<body>
<table>
       <tr> 
               <td><a href="register">Register</a></td>
               <td><a href="all">VIEW ALL</a></td>
       </tr>
</table>
<H3>WELCOME TO PRODUCT REGISTER PAGE</H3>
<form:form action="save" method="POST" modelAttribute="product">
<pre>
CODE  : <form:input path="prodCode" placeholder="12345KK"/><span id="prodCodeErr"></span>
        <form:errors path="prodCode" cssClass="errorTxt"/>
MODEL : 
        <form:radiobutton path="prodModel" value="MEDIUM" placeholder="MEDIUM"/>MEDIUM
        <form:radiobutton path="prodModel" value="SMALL"/>SMALL
        <form:radiobutton path="prodModel" value="HIGH"/>HIGH
        <%-- <form:errors path="prodModel" cssClass="errorTxt"/> --%>
        
NOTE  : <form:textarea path="prodNote" placeholder="AFGHANISTAN"/> 
<%-- <form:errors path="prodNote" cssClass="errorTxt"/> --%>
VENDOR: <form:checkbox path="prodOption" value="GRADE-A"/>GRADE-A  
        <form:checkbox path="prodOption" value="GRADE-B"/>GRADE-B   
        <form:checkbox path="prodOption" value="GRADE-C"/>GRADE-C 
        <form:errors path="prodOption" cssClass="errorTxt"/> 
        
KEY CODE: <form:password path="prodKeyCode"/>
<%-- <form:errors path="prodKeyCode" cssClass="errorTxt"/> --%>
          <input type="submit" value="Add Product">             
</pre>

</form:form>
<br>
${message}<br>

<script type="text/javascript">
$(document).ready(function(){
	$("#prodCode").change(function()){
		$.ajax({
			url : 'checkCode',
			data: { "prodCode": $("#prodCode").val()},
			success:function(resTxt){
				if(resTxt!=""){
					$("#prodCodeErr").show();
					$("#prodCodeErr").html(resTxt);
					$("#prodCodeErr").css("color","red");
					$("#prodCode").val('');
				}else{
					$("#prodCodeErr").hide();
					$("#prodCodeErr").html('');
				}
			}
		});
	}
});

</script>



</body>
</html>