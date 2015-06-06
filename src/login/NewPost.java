package login;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
    }
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService (request, response);
	}
	
	public void doService (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String user = request.getRemoteUser();
        request.setAttribute("user", user);
        request.getRequestDispatcher("/new_post.jsp").forward(request, response);
	}
}
