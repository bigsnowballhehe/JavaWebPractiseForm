package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactInsert {

	
		
//		public static void main(String[] args) {
//			 ContactInsert ss =new ContactInsert();
//			//ss.contact("11", "22");
//			boolean zzs = ss.contact("13","22","33","ss");
//			System.out.println(zzs);
//		}

		@SuppressWarnings("null")
		public boolean contact(String Name,String Email,String Website,String Message){
			
			boolean flag = true;
			Connection conn = null;	
			try{
				// 动态导入数据库的驱动
				Class.forName("com.mysql.cj.jdbc.Driver");

				// 获取数据库链接
				conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/ailitest?useSSL=false&serverTimezone=UTC", "root", "12345");

				String sql1 = "select name from contact";
				String sql = "INSERT INTO contact ( name, email, website, message ) VALUES ('"+Name+"','"+Email+"','"+Website+"','"+Message+"')";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				ResultSet rest = pstmt1.executeQuery();
				while(rest.next()) {
					
					String name = rest.getString(1);
					System.out.println(name);
					if(name.equals(Name)) {
						return flag = false;
					}
				}
				pstmt.executeUpdate(); 
				return flag;
					 
					 
								 
				 	
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


