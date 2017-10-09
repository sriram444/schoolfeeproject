package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.AccountantBeans;
public class AccountantDao {
	public static int save(AccountantBeans beans){
		int status = 0;
		try{
			Connection con = DB.getCon();
			PreparedStatement p = con.prepareStatement("insert into accountant(name,password,contact,id) values(?,?,?,?)");
			p.setString(1, beans.getName());
			p.setString(2,beans.getPassword());
			p.setString(3,beans.getContact());
			p.setInt(4,beans.getId());
			status = p.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
	return status;	
	}
	
	public static List<AccountantBeans> getAllRecords(){
		List<AccountantBeans> list = new ArrayList<AccountantBeans>();
		try{
		Connection con = DB.getCon();
		PreparedStatement ps = con.prepareStatement("select * from accountant");
		ResultSet r = ps.executeQuery();
		while(r.next()){
			AccountantBeans beans = new AccountantBeans();
			beans.setId(r.getInt(4));
			beans.setContact(r.getString(3));
			beans.setName(r.getString(1));
			beans.setPassword(r.getString(2));
			list.add(beans);
		}
		con.close();
		
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	public static int delete(int id){
	int status=0;
	try{
		Connection con = DB.getCon();
		PreparedStatement ps = con.prepareStatement("delete from accountant where id=?");
		ps.setInt(4, id);
		status = ps.executeUpdate();
		con.close();
	}catch(Exception e){
		System.out.println(e);
	}
	return status;
	}
}
