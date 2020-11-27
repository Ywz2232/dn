(()=>{
    //1.定义一个构造函数
     var ajax=function(){}//函数表达式(可以将其理解为构造函数)
     var JsonObj=function(type,url,data,contentType="application/x-www-form-urlencoded",async=true){//es6 中允许参数有默认值
        this.type=type;
        this.url=url;
        this.data=data;
        this.contentType=contentType;
        this.async=async;
     }
    //2.在构造函数内部的原型对象(Prototype)上添加ajax函数
     ajax.prototype={
         doAjax:function(obj){
             //1.创建XHR对象
             const xhr=new XMLHttpRequest();
             //2.设置状态监听
             xhr.onreadystatechange=function(){
    		   if(xhr.readyState==4){//服务端响应结束,客户端接收完成
    		     if(xhr.status==200){//200表示正常响应结束
    		       obj.success(xhr.responseText);//回调函数
    		     }else{//表示出现了异常
    		       obj.error(xhr.status);
    		     }
    		   }
    	     }
            //3.建立连接
            let type=obj.type?obj.type:"GET";
            xhr.open(type,type=="GET"?`${obj.url}?${obj.data}`:obj.url,obj.async)
            //4.发送请求
            if(type!="GET"){
              xhr.setRequestHeader("Content-Type",obj.contentType);
            }
            xhr.send(type=="GET"?null:obj.data);
         },
         doAjaxGet:function(url,params,callback){
            var jsonObj=new JsonObj("GET",url,params);
            jsonObj.success=callback;
            jsonObj.error=callback;
            this.doAjax(jsonObj);
         },
         doAjaxPost:function(url,params,callback){
            var jsonObj=new JsonObj("POST",url,params);
            jsonObj.success=callback;
            jsonObj.error=callback;
            this.doAjax(jsonObj);
         }
    }
    //3.基于ajax构造函数构建ajax对象,并将对象赋值给全局变量Ajax
     window.$$=new ajax();
})()