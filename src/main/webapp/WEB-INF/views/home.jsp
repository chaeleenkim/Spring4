<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<c:import url="./temp/boot_head.jsp"></c:import>
</head>
<body>
<c:import url="./temp/boot_nav.jsp"></c:import>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	
	<c:if test="${not empty member}">
		<h3>Login이 성공했을 때 보이는 문장</h3>
	</c:if>
	
	<c:if test="${empty member}">
		<h3>Login을 하기 전 보이는 문장</h3>
	</c:if>
	
	<h1 id="ar"></h1>
	
	<button id="btn">CLICK</button>
		
	<script type="text/javascript">
		
		//jQuery로 단축
		/* const btn = document.getElementById("btn");
		btn.addEvenetListener(); */
		
		$("#btn").click(function(){
			$.get("./ajax/t1?num=1", function (result) {
				console.log(result.trim());
				$('#ar').html(result.trim());
			});
		});
	</script>
</body>
</html>
