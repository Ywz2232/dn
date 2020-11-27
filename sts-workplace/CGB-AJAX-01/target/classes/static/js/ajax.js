function doAjaxGet(url,params,callback){
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
		callback(xhr.responseText);
		}
	};
	xhr.open("GET",url+"?"+params,true);
	xhr.send(null);
}
	
function doAjaxPost(url,params,callback){
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4&&xhr.status==200){
		callback(xhr.responseText);
		}
	};
	xhr.open("POST",url,true);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send(params);
}