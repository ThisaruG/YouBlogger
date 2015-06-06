package posts;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BufferedReader bufferRd = null;
		String title = null, line = null;
		File postFile = new File (getServletContext().getRealPath("/Posts/" + request.getParameter("file")));
		File approvedCommentFile = new File (getServletContext().getRealPath("/Comments/ApprovedComments/"
        		+ request.getParameter("file").substring(0, request.getParameter("file").length() - 5) + ".ybcm"));
		File pendingCommentFile = new File (getServletContext().getRealPath("/Comments/PendingComments/"
        		+ request.getParameter("file").substring(0, request.getParameter("file").length() - 5) + ".ybcm"));

		String content = "";
		String approvedComments = "";
		String pendingComments = "";
		
		try {
            bufferRd = new BufferedReader(new FileReader(postFile));
            title = bufferRd.readLine(); // First line is the title
            
            while((line = bufferRd.readLine()) != null) { // Adding the content
                content += line + "<br>";
            }
            
            bufferRd = new BufferedReader(new FileReader(approvedCommentFile));

            while((line = bufferRd.readLine()) != null) {
                approvedComments += line;
            }
            
            bufferRd = new BufferedReader(new FileReader(pendingCommentFile));

            while((line = bufferRd.readLine()) != null) {
                pendingComments += line;
            }
        } catch (FileNotFoundException x) {
        	x.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		} finally {
			if ((request.getUserPrincipal() != null)) {
				request.setAttribute("logged", "true");
				request.setAttribute("pendingComments", pendingComments); // Pending Comments
			}
			else {
				request.setAttribute("logged", "false");
			}
			request.setAttribute("file", request.getParameter("file").substring(0, request.getParameter("file").length() - 5)); // Getting the file name of the post without the extension
			request.setAttribute("title", title); // Post title
			request.setAttribute("content", content); // Post content
			request.setAttribute("approvedComments", approvedComments); // Approved Comments
			RequestDispatcher dispatcher = request.getRequestDispatcher("/showPost.jsp");
			dispatcher.forward(request, response);			
		}
	}	
}