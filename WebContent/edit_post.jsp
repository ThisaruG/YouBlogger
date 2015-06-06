<html>
	<head>
		<title>Add New Post</title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
		<%@ page session="true"%>
		<h1>Edit Post</h1>
		<% String u = request.getRemoteUser().toString(); %>
		<% String file = request.getParameter("file"); %>
		<% String title = request.getParameter("title"); %>
		<% String content = request.getParameter("content"); %>
		<h3>Hello,  <%=u%></h3>
		<table>
			<form action="edited" id = "edit_post" method = "post">
			<tr>
				<td>Title: </td>
				<td>
					<textarea name = "Post_Title" rows = "1" cols = "50" /><%=title %></textarea>
				</td>
			</tr>
			<tr><td colspan = "3"></td>&nbsp;</tr>
			<tr>
				<td rowspan = "1"> Content: </td>
				<td><textarea name = "content" rows = "20" cols= "50"><%=content %></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td colspan = "2">
					<input type = "hidden" form = "edit_post" name = "file" value = "<%=file%>"></input>
					<input type = "submit" form = "edit_post" value = "Submit"></input>
				</td>
				<td colspan = "2">
					<input type= "submit" form = "logout" value= "Sign Out" height = "20"></input>
				</td>
			</tr>
			</form>
			<form action = "logout.jsp" id = "logout" method = "post"></form>
		</table>
	</body>
</html>