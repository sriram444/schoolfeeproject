package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection getCon(){
		Connection con = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","4w#w8tRU");
		}catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
}
