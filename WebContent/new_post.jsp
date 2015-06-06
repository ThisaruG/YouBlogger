<html>
	<head>
		<title>Add New Post</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	</head>
	<body>
		<%@ page session="true"%>
		<h1>Add A New Post</h1>
		<% String u = request.getRemoteUser().toString(); %>
		<h3>Hello,  <%=u%></h3>
		<table>
			<form action = "posted" id = "add_post" method = "post">
			<tr>
				<td>Title: </td>
				<td>
					<textarea name = "Post_Title" rows = "1" cols = "50" /></textarea>
				</td>
			</tr>
			<tr><td colspan = "3"></td>&nbsp;</tr>
			<tr>
				<td rowspan = "1"> Content: </td>
				<td><textarea name = "content" rows = "20" cols= "50"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td colspan = "2">
					<input type= "submit" form = "add_post" value= "Submit">
				</td>
				<td colspan = "2">
					<input type= "submit" form = "logout" value= "Sign Out" height = "20">
				</td>
			</tr>
			</form>
			<form action = "logout.jsp" id = "logout" method = "post"></form>
		</table>
	</body>
</html>