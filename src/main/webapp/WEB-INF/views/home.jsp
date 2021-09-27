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
	
	<button id="btn">CLICK</button>
	<div>
		<h3 id="title"></h3>
	</div>
	
	<div>
		<table id="r" class="table table-hover">
			<tr>
				<td>ID</td>
				<td>TITLE</td>
				<td>USERID</td>
			</tr>
			
			
			
		</table>
	</div>
	
	
	<script type="text/javascript">
		$("#btn").click(function() {
			$.ajax({
				type:"GET",
				url:"http://jsonplaceholder.typicode.com/posts",
				
				success:function(result){
					alert(result);
					console.log(result);
					console.log(result[0]);
					console.log(result[0].title);
					
					for(v1 of result){
						let v = "<tr>";
						v= v+ "<td>";
						v= v+ v1.id;
						v= v+"</td>";
						v= v+"<td>";
						v= v+v1.title;
						v= v+"</td>";
						v= v+"<td>";
						v= v+v1.userId;
						v= v+"</td>";
						v= v+"</tr>";
						$("#r").append(v);
					}
					
					
					
				}
				
			});
		});
	</script>
	
	
	
	
</body>
</html>
