<html>
    <head>
        <title>You Blogger</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <div id = "Header">       	
            <h1>You Blogger</h1>
            <h2>Your post "<%= request.getAttribute("title")%>" have been edited</h2>
             <form action="new_post" id = "new_post" method = "POST"></form>
             <form action = "logout.jsp" id = "logout" method = "post"></form>
             <form action = "/YouBlogger" id = "home" method = "get"></form>
            <table>
            	<tr>          
	                <td><input type = "submit" form = "new_post" value = "Add A New Post" ></input></td>
	            	<td><input type = "submit" form = "logout" value= "Sign Out"></td>
					<td><input type = "submit" form = "home" value= "Home"></td>
				</tr>
            </table>
        </div>
    </body>
</html>