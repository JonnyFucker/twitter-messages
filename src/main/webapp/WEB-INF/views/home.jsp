<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>This is the homepage!</p>
        <ul>
            <c:forEach items="${tweets}" var="tweet">
                <li><img src="${tweet.profileImageUrl}" align="middle"/><c:out value="${tweet.createdAt}"/><br/><c:out value="${tweet.text}" escapeXml="false"/></li>
            </c:forEach>
        </ul>
    </body>
</html>
