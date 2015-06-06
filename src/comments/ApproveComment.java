package comments;

import java.io.*;
//import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApproveComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	private void doService(HttpServletRequest request, HttpServletResponse response) throws IOException {
		File readFile = new File (getServletContext().getRealPath("/Comments/PendingComments/" + request.getParameter("file") + ".ybcm")); // Pending Comment Saved Here.
		BufferedReader reader;

		File originFile = new File (getServletContext().getRealPath("/Comments/PendingComments/" + request.getParameter("file") + ".ybcm")); // Pending Comment Saved Here.
		
		File writeFile = new File (getServletContext().getRealPath("/Comments/ApprovedComments/" + request.getParameter("file") + ".ybcm")); // Approved Comments Goes Here.
		BufferedWriter writer;
		
		String comments = "";
		String line = "";
		try {
			reader = new BufferedReader(new FileReader(readFile));
			while ((line = reader.readLine()) != null) {
				comments += line;
			}
			reader.close();
			String [] tokens = comments.split("<br><br>");
			
			if (request.getParameter("do").equalsIgnoreCase("approve")) {
				writer = new BufferedWriter(new FileWriter(writeFile, true));
				writer.write(tokens[0]);
				writer.close();
				writer = new BufferedWriter(new FileWriter(originFile, false));
				for (int i = 1; i < tokens.length; i++) {
					writer.write(tokens[i]);
					writer.write("<br><br>");
				}
				writer.close();
			} else if (request.getParameter("do").equalsIgnoreCase("reject")) {
				writer = new BufferedWriter(new FileWriter(originFile, false));
				for (int i = 1; i < tokens.length; i++) {
					writer.write(tokens[i]);
					writer.write("<br><br>");
				}
				writer.close();
			}
			
		} finally {
			response.sendRedirect(request.getHeader("referer")); // Redirect to the page.
		}
	}
}
