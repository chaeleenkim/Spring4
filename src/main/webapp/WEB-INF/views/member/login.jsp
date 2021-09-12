<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>Login Page</h1>
	
	<!-- form -->
	<div class="container-fluid">
		
		
			<form id="frm" class="col-md-6 mx-auto" action="login" method="post">
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Id</label>
			    <input type="text" name="id" class="form-control put" id="id">
			  </div>
			  
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Password</label>
			    <input type="password" name="pw" class="form-control put pw" id="pw1">
			  </div>
			  
			  <button type="submit" id="btn" class="btn btn-primary">Log in</button>
			</form>
	
	</div>

<!-- end form -->


</body>
</html>