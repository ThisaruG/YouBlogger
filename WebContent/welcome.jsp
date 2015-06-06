<html>
    <head>
        <title>You Blogger</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <script = "text/javascript" src = "welcome.js"></script>
    </head>
    <body onload = "hidePosts();">
        <div id = "Header">       	
            <h1>You Blogger</h1>
        </div>        
        <div id = "buttons">
        	<table>
        		<tr>
        		<td>
        			<c:if test="${pageContext.request.userPrincipal == null}">
        				<input type = "submit" form = "login" value = "Sign In" ></input>
        			</c:if>
        			<c:if test="${pageContext.request.userPrincipal != null}">
        				<input type = "submit" form = "logout"value = "Sign Out"></input>
	        		</c:if>
        		</td>
            	<td><input type = "submit" form = "newPost" value = "Add A New Post" ></input></td>
        		</tr>
        	</table>        	
        </div>
        <div id = "recent_posts">
        	<h2>Posts:</h2>
        	<c:if test="${fn:length(map) eq 0}">No Posts To Show</c:if>
        	<c:if test="${fn:length(map) gt 0}">
	            <c:forEach var="map" items="${map}" begin = "0" end = "9">
	            	<a href = "show_post?file=${map.key}"><h3> ${map.value} </h3></a>
	            </c:forEach>
	    	</c:if>
        </div>
        <c:if test="${fn:length(map) gt 10}">
	        <div id = "see_more" onClick = "showPosts();"><a href = "#" onClick = "">Show More...</a></div>
	        <div id = "other_posts">
	            <c:forEach var="map" items="${map}" begin = "10">
	            	<a href = "show_post?file=${map.key}"><h3> ${map.value} </h3></a>
	            </c:forEach>
	        </div>
	    </c:if>        
        <div id = "forms"></div>          
	            <form action = "new_post" method = "post" id = "newPost">
	            	<input type = "hidden" form = "newPost" name = "direct" value = "new_post.jsp"></input>
	            </form>
	    	
	            <form action="login" method = "post" id = "login">            	
	            	<input type = "hidden" form = "login" name = "direct" value = "Index"></input>
	            </form>
	        
	            <form action="logout.jsp" method = "post" id = "logout"></form>
        </div>
    </body>
</html>