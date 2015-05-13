package posts;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
        BufferedReader bufferRd = null;
		String title = null,line = null;
		ArrayList<String> content = new ArrayList<String>();
		
		try {
            bufferRd = new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream("/Posts" + request.getParameter("file") + "/post")));
            title = bufferRd.readLine();
            int i = 0;
            while((line = bufferRd.readLine()) != null) {
                content.add(i, line + "\n");
                i++;
            }
            
        } catch (FileNotFoundException x) {
        	x.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/showPost.jsp");
		dispatcher.forward(request, response);
	}	
}
