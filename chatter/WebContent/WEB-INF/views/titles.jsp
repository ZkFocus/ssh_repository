<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <div class="spittleForm">
      <h1>Spit it out...</h1>
      <form method="POST" name="titleForm">
        <input type="hidden" name="latitude">
        <input type="hidden" name="longitude">
        <textarea name="message" cols="80" rows="5"></textarea><br/>
        <input type="submit" value="Add" />
      </form>
    </div>
    <div class="listTitle">
      <h1>Recent Titles</h1>
      <ul class="spittleList">
        <c:forEach items="${titleList}" var="title" >
          <li id="spittle_<c:out value="title.id"/>">
            <div class="spittleMessage"><c:out value="${title.message}" /></div>
            <div>
              <span class="spittleTime"><c:out value="${title.time}" /></span>
              <span class="spittleLocation">(<c:out value="${title.latitude}" />, <c:out value="${spittle.longitude}" />)</span>
            </div>
          </li>
        </c:forEach>
      </ul>
      <c:if test="${fn:length(spittleList) gt 20}">
        <hr />
        <s:url value="/titles?count=${nextCount}" var="more_url" />
        <a href="${more_url}">Show more</a>
      </c:if>
    </div>
  </body>
</html>