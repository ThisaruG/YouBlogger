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
            <h2>${title}</h2>
            <h3>${content}</h3>
        </div>
        <div id = "comments">
        	<table>
        	<tr>
        		<td rowspan = "1"><h5>Comments:</h5></td>
        	</tr>
        	<tr>
	        	<td>
	        		<p>${approvedComments}</p>
	        	</td>
	        </tr>
        	</table>
        	<br><br>
        	<c:if test="${logged  == 'true'}">
        		<table>
		        	<tr>
		        		<td rowspan = "1"><h5>Pending Comments:</h5></td>
		        	</tr>
		        	<tr>
			        	<td>
			        		<p>${pendingComments}</p>
			        	</td>
			            <td><form id = "approve" action = "approve_comment" method = "post">
			            	<input type = "hidden" form = "approve" name = "file" value = "${file}"></input>
			            	<input type = "hidden" form = "approve" name = "do" value = "approve"></input>
			            	<input type = "submit" value = "Approve Comment At The Top" form = "approve"></input>
			            </form></td>
			            <td><form id = "reject" action = "reject_comment" method = "post">
			            	<input type = "hidden" form = "reject" name = "file" value = "${file}"></input>
			            	<input type = "hidden" form = "reject" name = "do" value = "reject"></input>
			            	<input type = "submit" value = "Reject Comment At The Top" form = "reject"></input>
			            </form></td>
			            <td><form action = "logout.jsp" id = "logout" method = "post">
							<input type= "submit" form = "logout" value= "Sign Out" height = "20">
			            </form></td>
			            <td><form id = "edit" action = "edit_post.jsp" method = "post">
			            	<input type = "hidden" form = "edit" name = "file" value = "${file}"></input>
			            	<input type = "hidden" form = "edit" name = "title" value = "${title}"></input>
			            	<input type = "hidden" form = "edit" name = "content" value = "${content}"></input>
			            	<input type = "submit" value = "Edit Post" form = "edit"></input>
			            </form></td>
			        </tr>
		        </table>
        	</c:if>
        	
        	<form id = "comment" action = "add_comment" method = "post">
        	<table>
        	<tr>
        		<td><textarea name = "comment_body" rows = "7" cols = "30"></textarea></td>
        	</tr>
        	<tr>
        		<input type = "hidden" form = "comment" name = "file" value = "${file}"></input>
        		<td><input type = "submit" form = "comment" value = "Post Comment"></td>
        	</tr>
        	</table>
        	</form>
        </div>
    </body>
</html>