package sn.fz.serverGood;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.Login;


@WebServlet("/LoginOne")
	

	

	public class LoginOne extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       

	    
	    
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    	String userid = request.getParameter("userid");
			String passwd = request.getParameter("password");
			
			//��ȡ��ֵ
			
			Login ss = new Login();
			boolean jj = ss.login(userid,passwd);
			//����login  ����һ��flag
			
			if(jj == true) {
				response.sendRedirect("/MyFirstEcl/index.html");
			}
			//response.sendRedirect("/MyFirstEcl/response.html");
	    
			
	    }

		
		
		
		

	}


