package sn.fz.serverGood;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import dataBase.ROOTselect;

@WebServlet("/rootguanliyuan")

public class rootguanliyuan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("json");
		PrintWriter out = response.getWriter();
		
		JSONArray jso = new JSONArray();
		ROOTselect rse = new ROOTselect();
		ArrayList<HashMap<String, String>> jij = rse.Roselect();

		for (int i = 0; i < jij.size(); i++) {

			HashMap<String, String> hsmm = jij.get(i);
			jso.put(hsmm);

		}
		
		out.println(jso.toString());
	
		out.flush();
		out.close();
	
	}

}
