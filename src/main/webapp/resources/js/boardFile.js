/**
 * boardFile.js
   최대 5까지만 추가 가능
 */
 
let file = '<div class="input-group mb-3">';
file = file + '<input type="file" class="form-control">';
file = file + '<button class="btn btn-outline-secondary del" type="button">X</button>';
file = file + '</div>';	

let count=0;
//let index=0;

$('#fileAdd').click(function(){
/*	index++;
let file = '<div class="input-group mb-3" id="del'+index+'">';
file = file + '<input type="file" class="form-control">';
file = file + '<button data-btn-id="'+index+'" class="btn btn-outline-secondary del" type="button">X</button>';
file = file + '</div>';	*/
	
	if(count<5){
		count++;
		$('#fileAddResult').append(file);		
	}else {
		alert('최대 5개까지만 가능')
	}
});

//X 버튼-------------------------
$("#fileAddResult").on('click', '.del' ,function(){
	
/*	//부모에 아이디 부여
	let num = $(this).attr('data-btn-id');
	$("#del"+num).remove();*/
	
	$(this).parent().remove();
	
	count--;
});


//삭제 버튼------------------------
/*$(".del").click(function(){
	alert('test');
});*/

//내 풀이
/* 
let num = 0;
$("#fileAdd").click(function(){
	if(num<5){
		$("#fileAddResult").append(file);
		num = num+1;		
	}else{
		alert('최대 5개까지 추가 가능');
	}
});	

*/
