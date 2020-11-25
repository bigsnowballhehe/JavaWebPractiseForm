package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ROOTselect {



	public ArrayList<HashMap<String, String>> Roselect() {
	
		ArrayList<HashMap<String, String>> ary = new ArrayList<HashMap<String, String>>();
		Connection conn = null;
		try {
			// 动态导入数据库的驱动
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 获取数据库链接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ailitest?useSSL=false&serverTimezone=UTC",
					"root", "12345");

			String sql1 = "select * from contact";

			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			ResultSet rest = pstmt1.executeQuery();
			while (rest.next()) {
				String lz1 = rest.getString(1);
				String lz2 = rest.getString(2);
				String lz3 = rest.getString(3);
				String lz4 = rest.getString(4);
			
				HashMap<String, String> hsm = new HashMap<String, String>();

				hsm.put("name", lz1);
				hsm.put("email", lz2);
				hsm.put("website", lz3);
				hsm.put("message", lz4);



					ary.add(hsm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ary;

	}
}
