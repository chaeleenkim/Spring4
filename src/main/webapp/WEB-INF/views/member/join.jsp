<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Page</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
<h1>Join Page</h1>

<!-- form -->
<div class="container-fluid">
	
	
		<form id="frm" class="col-md-6 mx-auto" action="join" method="post">
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Id</label>
		    <input type="text" class="form-control put" id="id">
		    <button id="idCheck" type="button">ID중복확인</button>
		  	<div id="idResult"></div>
		  </div>
		  
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Password</label>
		    <input type="password" class="form-control put pw" id="pw1">
		  </div>
		    <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Confirm Password</label>
		    <input type="password" class="form-control put pw" id="pw2">
		  </div>
		  <div id="pwResult"></div>
		  
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Name</label>
		    <input type="text" class="form-control put" id="name">
		  </div>
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Phone</label>
		    <input type="tel" class="form-control put" id="phone">
		  </div>
		  
		  <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Email address</label>
		    <input type="email" class="form-control put" id="email" aria-describedby="emailHelp">
		    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
		  </div>
		 
		  <button type="button" id="btn" class="btn btn-primary">Join</button>
		</form>

</div>

<!-- end form -->

<script type="text/javascript" src="../resources/js/join.js"></script>
</body>
</html>