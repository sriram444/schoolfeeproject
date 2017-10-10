package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import beans.StudentBeans;
import beans.AccountantBeans;
public class StudentDeo {
	
	public static int save(StudentBeans beans){
		int status =0;
		try{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("insert into studentfee values(?,?,?,?,?,?)");
			ps.setString(1,beans.getRollno());
			ps.setString(2, beans.getName());
			ps.setString(3, beans.getCourse());
			ps.setInt(4, beans.getFee());
			ps.setInt(5, beans.getPaid());
			ps.setInt(6, beans.getDue());
			status = ps.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	
}
