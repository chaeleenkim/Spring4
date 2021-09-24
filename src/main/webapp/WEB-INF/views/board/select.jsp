<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
<style type="text/css">
	.more {
		cursor: pointer;
	}
</style>
</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	
	<div class="container-fluid col-md-8">
		<h1>${board} Select Page</h1>
		
		<h3>NUM:${dto.num}</h3>
		<h3>Title:${dto.title}</h3>
		
		<div>
		
			${dto.contents}
		
		</div>
		
		<h3>Writer:${dto.writer}</h3>
		<h3>DATE:${dto.regDate}</h3>
		<h3>HITS:${dto.hits}</h3>
	
	<c:forEach items="${dto.files}" var="f">
		<div>
			<a href="./down?fileName=${f.fileName}">${f.oriName}</a>
		</div>
	</c:forEach>	
	
	<hr>
	<!-- comment list  -->
	<div id="commentList" data-board-num="${dto.num}">
		
	</div>
	
	<!-- 댓글 폼 -->
	<div>
		  <div class="mb-3">
		    <label for="writer" class="form-label">Writer</label>
		    <input type="text" class="form-control" readonly="readonly" value="${member.id}" name="writer" id="writer" placeholder="Enter Writer">
		  </div>
		  
		  <div class="mb-3">
		   <label for="contents" class="form-label">Contents</label>
  			<textarea class="form-control" cols=""  name="contents" id="contents" rows="6"></textarea>
		  </div>
		 <!-- button 추가 -->
		   <button type="button" id="comment" class="btn btn-primary">WRITE</button>
		   
	</div>	
	<hr>

	<c:if test="${not empty member and member.id eq dto.writer}">
		<a href="./delete?num=${dto.num}">DELETE</a>
		<a href="./update?num=${dto.num}">UPDATE</a>
	</c:if>
	
	
	<c:if test="${board ne 'notice'}">
		<a href="./reply?num=${dto.num}">REPLY</a>
	</c:if>
	
	
	</div>

<script type="text/javascript">
	
	//처음 호출할 때는 pn 1
	getCommentList(1);
	
	//전역변수 전언
	//let content = '';
	
	//Update click event
	$("#commentList").on("click", ".commentUpdate", function(){
		let num = $(this).attr("data-comment-update")
		let content = $("#content"+num).text().trim();
		$('#content'+num).children().css('display', 'none');
		let ta = '<textarea class="form-control" cols=""  name="contents" id="contents" rows="">';
		ta = ta + content.trim() + '</textarea>';
		ta = ta + '<button type="button" id="" class="btn btn-primary up">update</button>';
		ta = ta + '<button type="button" id="" class="btn btn-danger can">cancel</button>';
		$("#content"+num).append(ta);
	});
	
	//update
	$("#commentList").on('click', '.up', function() {
		//update 버튼의 바로 앞 이웃 contents의 값
		let contents = $(this).prev().val();
		//update 버튼의 부모 contents의 바로 앞 이웃 contentNum의 값
		let cn = $(this).parent().prev().text().trim();
		let selector=$(this);
		$.ajax({
			type:"POST",
			url: "./commentUpdate",
			data:{
				//필요한 정보 : commentNum, contents
				commentNum:cn,
				contents:contents
			},
			success:function(result){
				if(result.trim()>0){
					alert('수정 성공');
					//getCommentList(1);
					
					//div 태그 내에 넣은 ${comment.contents}에 contents 넣고 다시 보이게 함
					selector.parent().children('div').text(contents);
					selector.parent().children('div').css('display', 'block');
					//textarea와 button은 삭제
					selector.parent().children('textarea').remove();
					selector.parent().children('button').remove();
				}else {
					alert('수정 실패');
				}
			},
			error:function(){
				alert('수정 실패');
			}
			
		});
		
	});
	
	//cancel
	$("#commentList").on("click", ".can", function() {
		$(this).parent().children('div').css('display', 'block');
		$(this).parent().children('textarea').remove();
		$(this).parent().children('button').remove();
	})
	
	//Del click event
	$("#commentList").on("click", ".commentDel", function(){
		let commentNum = $(this).attr("data-comment-del") 
		console.log(commentNum);
		//url ./commentDel
		$.ajax({
			type: "POST",
			url: "./commentDel",
			data: {
				commentNum:commentNum
			},
			success:function(result){
				result=result.trim();
				if(result>0){
					alert("삭제 성공");
					getCommentList(1);
				}else {
					alert("삭제 실패");
				}
				
			},
			error:function(){
				alert('삭제에 실패');
			}
		});
		
	});
	
	$("#commentList").on("click",".more",function(){
		//data-comment-pn 값을 출력
		let pn = $(this).attr("data-comment-pn");
		getCommentList(pn);
	});
	
	
	function getCommentList(pageNumber) {
		let num = $("#commentList").attr("data-board-num")
		$.ajax({
			type: "GET",
			url: "./getCommentList",
			data: {
				num: num,
				pn : pageNumber
			},
			success: function(result){
				result = result.trim();
				$("#commentList").html(result);
				
			},
			error: function(xhr, status, error){
				console.log(error);
			}
			
		});
	
	}
	
	
	$('#comment').click(function(){
		//작성자, 내용을 콘솔에 출력
		let writer = $('#writer').val();
		let contents = $('#contents').val();
		$.post('./comment', {num:'${dto.num}',writer:writer, contents:contents}, function(result){
			console.log(result.trim());
			
			$("#contents").val('');
			getCommentList();
		});	
	});

</script>
	

</body>
</html>