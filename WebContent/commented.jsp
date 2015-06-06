<html>
    <head>
        <title>You Blogger</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <div id = "Header">       	
            <h1>You Blogger</h1>
            <h2>Your comment have been submitted. It will be shown after the Administrator reviewed.</h2>
             <form action = "/YouBlogger" id = "home" method = "get"></form>
            <table>
            	<tr>
					<td><input type = "submit" form = "home" value= "Home"></td>
				</tr>
            </table>
        </div>
    </body>
</html>