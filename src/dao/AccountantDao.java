package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.AccountantBeans;
public class AccountantDao {
	public static int save(AccountantBeans beans){
		int status = 0;
		try{
			Connection con = DB.getCon();
			PreparedStatement p = con.prepareStatement("insert into accoutant(name,password,contact) values(?,?,?)");
			p.setString(1, beans.getName());
			p.setString(2,beans.getPassword());
			p.setString(3,beans.getContact());
			status = p.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
	return status;	
	}
}
