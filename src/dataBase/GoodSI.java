package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GoodSI {
	
//	public static void main(String[] args) {
//		GoodSI ss = new GoodSI();
//		ss.insertGoods("2", "2");
//	}
//	
	public void insertGoods(String name,String introduce){
		Connection conn = null;
		Statement stmt = null;
		try{
			// ��̬�������ݿ������
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ��ȡ���ݿ�����
			conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/shop?useSSL=false&serverTimezone=UTC", "root", "12345");

			// ����SQL���
			String sql = "INSERT INTO goods ( name, introduce ) VALUES ( '"+name+"', '"+introduce+"' )";

			// ִ��SQL���
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
