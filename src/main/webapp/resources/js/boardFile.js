/**
 * boardFile.js
   최대 5까지만 추가 가능
 */
 
let file = '<div class="input-group mb-3">';
file = file + '<input type="file" class="form-control">';
file = file + '<button class="btn btn-outline-secondary del" type="button">X</button>';
file = file + '</div>';

let count=0;

$('#fileAdd').click(function(){
	if(count<5){
		count++;
		$('#fileAddResult').append(file);		
	}else {
		alert('최대 5개까지만 가능')
	}
});

//삭제 버튼------------------------
$(".del").click(function(){
	alert('test');
});

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
