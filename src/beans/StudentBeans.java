package beans;

public class StudentBeans {
	private String rollno,name,course;
	private int fee,paid,due;
	public StudentBeans(String rollno,String name,String course,int fee,int paid,int due){
		this.rollno=rollno;
		this.name=name;
		this.course=course;
		this.fee=fee;
		this.paid=paid;
		this.due=due;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public int getDue() {
		return due;
	}
	public void setDue(int due) {
		this.due = due;
	}
	
}
