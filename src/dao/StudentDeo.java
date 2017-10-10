package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	
	public static List<StudentBeans> getAllStudents(){
		List<StudentBeans> list = new ArrayList<StudentBeans>();
		try{
			Connection con = DB.getCon();
			PreparedStatement ps = con.prepareStatement("select * from studentfee");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				StudentBeans beans = new StudentBeans();
				beans.setRollno(rs.getString(1));
				beans.setName(rs.getString(2));
				beans.setCourse(rs.getString(3));
				beans.setFee(rs.getInt(4));
				beans.setPaid(rs.getInt(5));
				beans.setDue(rs.getInt(6));
				list.add(beans);
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
}
