package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class selectfromroot {
	
//	public static void main(String[] args) {
//		selectfromroot ss =new selectfromroot();
//		
//		boolean fl = ss.login2("444","444");
//		System.out.println(fl);
//	}

	@SuppressWarnings("null")
	public boolean login2(String userid,String passwd){
		Boolean flag = false;
		Connection conn = null;	
		ResultSet rest = null;
		try{
			// 动态导入数据库的驱动
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 获取数据库链接
			conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/ailitest?useSSL=false&serverTimezone=UTC", "root", "12345");

			
			String sql = "select * from root";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			 rest = pstmt.executeQuery(); 
			 while(rest.next()) {
				 String zz = rest.getString(1);
				 String xx = rest.getString(2);
				
//				 System.out.println(zz);
//				 System.out.println(xx);
				 
				 if(userid.equals(zz) & passwd.equals(xx)){
//					 System.out.println("congratulation!");
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
