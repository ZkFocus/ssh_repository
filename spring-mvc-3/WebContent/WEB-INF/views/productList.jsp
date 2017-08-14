<%@ page pageEncoding="UTF-8"%>
<html>
  <head>
    <title>@RequestBody Sample</title>
    <style type="text/css">
      textarea {height:65px;width:505px;resize:none;font-family:Consolas}
      button {display:block;margin-left:0;padding:10px 55px;cursor:pointer;font-family:Consolas;width:180px}
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.1.1.js"></script>
  </head>
  <body>
    <h1>Welcome to the product list page!</h1>
    <p>
      <textarea disabled="disabled">{"id":1001,"name":"戴尔-XPS-13(XPS13D-9343-1508)笔记本","price":6999.0}</textarea>
      <button>add</button>
    </p>
    <p>
      <textarea disabled="disabled">[{"id":1001,"name":"戴尔-XPS-13(XPS13D-9343-1508)笔记本","price":6999.0},{"id":1002,"name":"戴尔-XPS-13(XPS13D-9343-1708)笔记本","price":8999.0}]</textarea>
      <button>addSerial</button>
    </p>
    <p>
      <textarea disabled="disabled">{"dell":{"id":1003,"name":"戴尔-XPS-13(XPS13D-9343-1808T)笔记本","price":13000.0}}</textarea>
      <button>addBrand</button>
    </p>
    <script type="text/javascript">
    $(function(){
    	$("button").click(function(){
    		var button = $(this);
    		$.ajax({
    			type : "post",
    			url  : "product/" + button.text(),
    			data : button.parent().find("textarea").val(),
    			contentType : "application/json",
    			success : function() {
    				alert("well, now you can see the execution result on the console");
    			}
    		});
    	});
    });
    </script>
  </body>
</html>