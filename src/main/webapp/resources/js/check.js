/**
 * check.js
 */

const all = document.getElementById('all');
const c1 = document.getElementsByClassName("c1"); 


//check ALL
all.addEventListener('click',function(){
	for(let ch of c1) {
		if(all.checked){
			ch.checked = true;	
		}else {
			ch.checked = false;
		}
		
	}
});


for(let ch of c1){
	ch.addEventListener('click', function(){
		
		let every = true;
		
		for(let ch of c1){
			if(!ch.checked){
				every = false;
			}
		}
		
		if(every) {
			all.checked;
		}
		
	} );
}





