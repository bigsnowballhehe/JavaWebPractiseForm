package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Login {
	


	public boolean login(String userid,String passwd){
		Boolean flag = false;
		Connection conn = null;	
		ResultSet rest = null;
		try{
			// ��̬�������ݿ������
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ��ȡ���ݿ�����
			conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/ailitest?useSSL=false&serverTimezone=UTC", "root", "12345");

			
			String sql = "select * from user";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			 rest = pstmt.executeQuery(); 
			 while(rest.next()) {
				 String zz = rest.getString(1);
				 String xx = rest.getString(2);
				

				 
				 if(userid.equals(zz) & passwd.equals(xx)){
					 System.out.println("congratulation!");
					 flag = true;
					 
				 }
				 
				 
			return flag;					 
			 }		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
				try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
