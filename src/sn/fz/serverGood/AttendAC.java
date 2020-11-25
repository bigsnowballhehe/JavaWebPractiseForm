package sn.fz.serverGood;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.ContactInsert;

@WebServlet("/AttendAC")




public class AttendAC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
    	response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
    	String Name = request.getParameter("name");
		String Email = request.getParameter("email");
		String Website = request.getParameter("website");
		String Message = request.getParameter("message");
		//获取数值
		ContactInsert ss = new ContactInsert();
		boolean flag = ss.contact(Name, Email, Website, Message);
		
		if(flag) {
			out.println("successful !");
		}else {
			out.println("Please check your message!");
		}
		out.flush();
        out.close();
		
    }

	
	
	
	

}
