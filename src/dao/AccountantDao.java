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
		int status = 0;
		try{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("delete from accountant where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	
	public static AccountantBeans getRecordsById(int id){
		AccountantBeans bean = new AccountantBeans();
		try{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("select * from accountant where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				bean.setId(rs.getInt(4));
				bean.setName(rs.getString(1));
				bean.setContact(rs.getString(3));
				bean.setPassword(rs.getString(2));
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return bean;
	}
	
	public static int update(AccountantBeans beans){
		int status = 0;
		try{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("update accountant set name=?,password=?,contact=? where id=?");
			ps.setString(1, beans.getName());
			ps.setString(2, beans.getPassword());
			ps.setString(3, beans.getContact());
			ps.setInt(4, beans.getId());
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	
	
}
