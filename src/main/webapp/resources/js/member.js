/**
 * member.js
 */

//jQuery

//check ALL----------------------------------------------- 

$("#all").click(function(){
	$(".checks").prop("checked", $(this).prop("checked"));
});


//check 약관 모두 클릭----------------------------------------
$(".checks").click(function(){
	let result = true;
	$(".checks").each(function(v1, v2){
		if(!$(v2).prop("checked")){
			result = false;
			console.log(v1, $(v2).prop("checked"));
			//break; each문 내에서 사용 불가
		}
	});
	
	$("#all").prop("checked", result);
});


//check 모든 약관 동의-----------------------------------------

$("#btn").click(function(){
	if($("#all").prop("checked")){
		location.href="./join";
	}else{
		alert('약관동의 필수');
	}
});


//check 필수 약관 동의----------------------------------------
/*btn.addEventListener('click', function(){
	let result = true;
	
	for(let c of ch){
		if(!c.checked){
			result = false;
			break;
		}
	}
	
	if(result){
		location.href="./join";
	}else{
		alert('필수 약관에 동의 해야 함');
	}
	
	
});
*/



