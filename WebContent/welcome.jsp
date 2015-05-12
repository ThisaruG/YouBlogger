<html>
    <head>
        <title>You Blogger</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <div id = "Header">       	
            <h1>You Blogger</h1>
            
            <c:forEach var="map" items="${map}">
            	<a href = "show_post?file=${map.key}"><h2> ${map.value} </h2></a>
            	<br/>
            </c:forEach>
            <form action="new_post" method = "POST">
                <input type = "submit" value = "Add A New Post" ></input>
            </form>
        </div>
    </body>
</html>