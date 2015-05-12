<html>
    <head>
        <title>You Blogger</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <div id = "Header">
            <h1>You Blogger</h1>
        </div>
        <div id = "postBody">   
            <h2> <%= request.getAttribute("title") %></h2>
            <c:forEach items="${content}" var="line">
            	<h4>${line}</h4>
            </c:forEach>
        </div>
        <div id = "comments">
        	<form id = "comment" action = "add_comment" method = "post">
        	<table>
        	<tr>
        		<td><textarea name = "comment_body" rows = "10" cols = " 60"></textarea></td>
        	</tr>
        	<tr>
        		<td><input type = "submit" form = "comment" value = "Post Comment"></td>
        	</tr>
        	</table>
        	</form>
        </div>
    </body>
</html>