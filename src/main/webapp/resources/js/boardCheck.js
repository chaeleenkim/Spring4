/**
 * 
 */
 
const btn = document.getElementById("btn");

btn.addEventListener("click", function(){
	const title = document.getElementById("title");
	const writer = document.getElementById("writer");
	
	let t = title.value;
	let w = writer.getAttribute("value");
	
	alert(t);
	alert(w);
	
});

