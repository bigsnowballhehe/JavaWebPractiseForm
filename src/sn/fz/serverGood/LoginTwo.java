package sn.fz.serverGood;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.selectfromroot;

@WebServlet("/LoginTwo")




public class LoginTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
    	response.setContentType("text/html");
        
       // PrintWriter out = response.getWriter();
    	String userid = request.getParameter("userid");
		String passwd = request.getParameter("password");
		
		//获取数值
		
		selectfromroot ss = new selectfromroot();
		boolean zz = ss.login2(userid, passwd);
		if(zz) {
			response.sendRedirect("/MyFirstEcl/RootHtml.html");
		}
		
	
		

	
    }

	
	
	
	

}
