/**
 * 
 */
 
const btn = document.getElementById("btn");
const c1 = document.getElementsByClassName('c1');
const id1 = document.getElementById('id1');

let ar = ['a','b','c'];

for(let s of c1){
	//span 태그를 하나씩 꺼냄
	s.addEventListener('click',function(){
		//data-writer-num
		//dataset.writerNum
		let num = s.dataset.writerNum;
		
		num = document.getElementById('w'+num);
		alert(num.innerHTML);
	});
}

/*
for(let i in c1){
	let id = document.getElementById('id'+i);
	let writer = document.getElementById('w'+i);
	id.addEventListener('click',function(){
		alert(writer.innerHTML);
	});
}
*/



/*for(let i in c1){
	let id = document.getElementById('id'+i);
	id.addEventListener('click',function(){
		alert('id'+i);
	});
}*/



btn.addEventListener('click',function(){
	
	for(let i of c1){
		console.log(i.innerHTML);
	}
	
/*	
	ar.forEach(function(v, i, ar){
		console.log(v, i, ar);
	});
	
	
	for(let i of ar) {
		//i에 배열의 값이 들어감
		console.log(i);
	}
	
	for(let i=0;i<ar.length;i++){
		console.log(ar[i]);
	}
	
	for(let i in ar){
		//i에 인덱스 번호가 들어감
		console.log(ar[i]);
	}
*/
	
});