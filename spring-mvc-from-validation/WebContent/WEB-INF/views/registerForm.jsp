<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> 
<%@ page session="false" %>
<html>
  <head>
    <title>Spitter</title>
    <%-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" > --%>
  </head>
  <body>
    <h1>Register</h1>

	<sf:form method="post" commandName="user" >
		username:<sf:input path="username"/><sf:errors path="username"/>
		<br>
		email:<sf:input path="email"/><sf:errors path="email"/>
		<br>
		password:<sf:password path="password"/><sf:errors path="password"/>
		<br>
		<input type="submit" value="submit">
	</sf:form>

   <!--  <form method="POST">
      Username: <input type="text" name="username" /><br/>
      Email: <input type="email" name="email" /><br/>
      Password: <input type="password" name="password" /><br/>
      <input type="submit" value="Register" />
    </form> -->
  </body>
</html>
