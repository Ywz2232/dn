(()=>{
    //1.定义一个构造函数
    var ajax=function(){}//函数表达式(可以将其理解为构造函数)
    //2.在构造函数内部的原型对象(Prototype)上添加ajax函数
     ajax.prototype={
         doAjaxGet:function(url,params,callback){
            //1.创建XHR对象
             const xhr=new XMLHttpRequest();
            //2.设置状态监听
             xhr.onreadystatechange=function(){
    		   if(xhr.readyState==4){//服务端响应结束,客户端接收完成
    		     if(xhr.status==200){//200表示正常响应结束
    		       callback(xhr.responseText);//回调函数
    		     }else{//表示出现了异常
    		       callback(xhr.status);
    		     }
    		   }
    	     }
            //3.建立连接
            xhr.open("GET",`${url}?${params}`,true)
            //4.发送请求
            xhr.send(null);
         },
         doAjaxPost:function(url,params,callback){
            //1.创建XHR对象
             const xhr=new XMLHttpRequest();
            //2.设置状态监听
             xhr.onreadystatechange=function(){
    		   if(xhr.readyState==4){//服务端响应结束,客户端接收完成
    		     if(xhr.status==200){//200表示正常响应结束
    		       callback(xhr.responseText);//回调函数
    		     }else{//表示出现了异常
    		       callback(xhr.status);
    		     }
    		   }
    	     }
            //3.建立连接
            xhr.open("POST",url,true);
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            //4.发送请求
            xhr.send(params);
         }
    }
    //3.基于ajax构造函数构建ajax对象,并将对象赋值给全局变量Ajax
    window.$$=new ajax();
})()