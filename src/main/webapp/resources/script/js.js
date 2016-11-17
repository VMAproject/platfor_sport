function Add(){


 	var name= prompt("write tittle of group" ,"write here");
	console.log(name);

	$.post(  {
		url:"/group/saveGroup",data:{
			name: name
		}
		}

	)
		.done(function(data) {
			console.log(data);
		})
		.fail(function() {
			alert( "error polomka" );
		});
// 	//alert("you name "+ name);
// 	var newGroup = document.getElementsByTagName("ul")[1]
// 	// var newUl = document.createElement("ui");
// 	var newLi = document.createElement("li");
// 	var a = document.createElement("a");
// 	a.setAttribute('href', "http://facebook.com");
// 	a.setAttribute('id', name);
// //	a.appendChild(document.setProperty("in",name)).href="http://localhost:8080/registerPerson//showFormForAdd";
// 	a.appendChild(document.createTextNode(name));
// 	newLi.appendChild(a);
// 	newGroup.appendChild(newLi)


// Входной массив данных:





}