package sn.fz.serverGood;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestServlet")
	

	

	public class TestServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       

	    
	    
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	
	    	
	    	response.setContentType("text/html");
	         
	        PrintWriter out = response.getWriter();
	       
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        //成功输出success 失败输出fail
	        if ("haha".equals(username) && "123".equals(password)) {
	            out.println("success");
	        } else {
	            out.println("fail");
	        }
	        out.flush();
	        out.close();
		
		
		
		
	    }
}
	




		


