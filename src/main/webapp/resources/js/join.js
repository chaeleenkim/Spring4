/**
 * 
 */
 
//전역 변수
const put = document.getElementsByClassName('put');
const btn = document.getElementById('btn');
const pws = document.getElementsByClassName('pw');
const frm = document.getElementById('frm');
const id = document.getElementById('id');
const idResult = document.getElementById('idResult');
const idCheck = document.getElementById('idCheck');




//id--------------------------------------------

//id 중복 체크
idCheck.addEventListener('click', function(){
	//location.href="./idCheck?id="+id.value;
	
	//새 창 띄우기
	open("./idCheck?id="+id.value, "", "width=400,height=200 top=200, left=300");
		
});

/*
id.addEventListener('change', function(){
	alert('change');
});

id.addEventListener('blur', function(){
	//id 6글자 미만이면 focus 안 빠져나옴
	if(id.value.trim().length <6){
		id.focus();
	}
})

*/

/*id.addEventListener('keyup', function(){
	
	if(id.value.trim().length>=6){
		idResult.innerHTML = '올바른 아이디';
	}else{
		idResult.innerHTML = 'ID는 6글자 이상';
	}
	//console.log('press')
});

id.addEventListener('blur', function(){
	id.value="";
})*/


//join폼 전체-------------------------------------- 
btn.addEventListener('click', function(){
	//비어있는 것들 검사
	let ce = checkEmpty(put);
	//pw값 두 개 같은지 검사
	let ce2 = checkEqual(pws[0], pws[1]);
	//pw 글자수 검사
	let cl = checkLength();
	
	
	if(ce&&ce2&&cl){
		frm.submit();
	}else {
		alert("필수 입력");
	}
	
});

//pw 길이 검사----------------------------------------
function checkLength(){
	let l = pws[0].value.trim().length;
	if(l>=6){
		return true;
	}else{
		return false;
	}
}


//pw 같은지 검사---------------------------------------
function checkEqual(check1, check2){
	return check1.value == check2.value;
}


////비어있는 것들 검사-----------------------------------
function checkEmpty(puts){
	let result = true;
	
	for(r of puts){
		if(r.value.trim() ==""){
			result = false;
			break;
		}
	}
	
	return result;
	
}
