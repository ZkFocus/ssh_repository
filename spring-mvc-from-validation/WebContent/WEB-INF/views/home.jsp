<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Chatter</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
          <script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function(){
		alert("a");
	})
</script>
  </head>
  <body>
    <h1>Welcome to Chatter</h1>

    <a href="<c:url value="/user/register" />">Register</a>
  </body>
</html>
