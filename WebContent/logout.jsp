<head>
	<title>Logged Out</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<%@ page session="true"%>
	
	<h3>You have been logged out.</h3>
	
	<% session.invalidate(); %>
	
	<br/>
	<table>
		<tr>
			<td>
				<form action="/YouBlogger">
			    	<input type="submit" value="Back to home">
				</form>
			</td>
			<td>
				<form action="login.html">
				    <input type="submit" value="Sign in again">
				</form>
			</td>
		</tr>
	</table>
</body>