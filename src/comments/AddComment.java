package comments;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = getServletContext().getRealPath("/Comments/PendingComments/" + request.getParameter("file") + ".ybcm");
		BufferedWriter writer = null;
		System.out.println(getServletContext().getRealPath("/Comments/PendingComments/" + request.getParameter("file") + ".ybcm"));
		
		try {
			writer = new BufferedWriter(new FileWriter(fileName, true));
			writer.write(request.getParameter("comment_body") + "<br><br>");
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		finally {
			if (writer != null) {
				try {
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/commented.jsp");
	    dispatcher.forward(request, response);
	}
}
