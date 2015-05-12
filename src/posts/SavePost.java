package posts;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SavePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static int RANGE = 10000;
	static ArrayList<String> postList = new ArrayList<String>();
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	public void doService (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random rand = new Random();
		String fileName = null;
		BufferedWriter writer = null;
		String title = request.getParameter("Post_Title");
		String content = request.getParameter("content");
		
		while (true) {
			fileName = "../webapps/YouBlogger/Posts/Post" + rand.nextInt(RANGE) + ".yblg";
			
			if (!(postList.contains(fileName))) {
				synchronized (postList) {
					postList.add(fileName);
				}
				break;
			}
		}
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName))));
			writer.write(title + "\n");
			writer.write(content);
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
	    request.setAttribute("title", title);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/posted.jsp");
	    dispatcher.forward(request, response);
	}
}