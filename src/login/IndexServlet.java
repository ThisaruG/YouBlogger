package login;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doService(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doService(request, response);
	}
	
	public void doService (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = getServletContext().getRealPath("/Posts");
		String fileName, title;
		File dir = new File(path);
        File [] files  = dir.listFiles();
        FileReader fileRd;
        BufferedReader bufferRd = null;
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        
       if (files != null && files.length != 0) {
	        
	        Arrays.sort(files, new Comparator<Object>() {
	            public int compare(Object o1, Object o2) {
	            	if (o1 == null && o2 == null) {
	            		return 0;
	            	}
	            	if (o1 == null) {
	            		return 1;
	            	}
	            	if (o2 == null) {
	            		return -1;
	            	}
	            	else {
	            		return compare((File)o1, (File)o2);
	            	}
	            }
	            private int compare( File f1, File f2){
	                long result = f2.lastModified() - f1.lastModified();
	                if( result > 0 ){
	                    return 1;
	                } else if( result < 0 ){
	                    return -1;
	                } else {
	                    return 0;
	                }
	            }
	        });
	        
	        for(int i = 0; i < files.length; i++) {
	            fileName = files[i].getName();
	            try {
	            	fileRd = new FileReader(files[i].getAbsolutePath());
	                bufferRd = new BufferedReader(fileRd);
	                title = bufferRd.readLine();
	                map.put(fileName, title);              
	            } catch (FileNotFoundException x) {
	            	x.printStackTrace();
	            } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
       }
       request.setAttribute("map", map);
       RequestDispatcher dispatcher = request.getRequestDispatcher("/welcome.jsp");
       dispatcher.forward(request, response);
	}
}