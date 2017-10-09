package beans;

public class AccountantBeans {
	private int id;
	private String name,password,contact;
	
	public AccountantBeans(String name,String password,String contact){
		this.name=name;
		this.password=password;
		this.contact=contact;
	}
	
	public AccountantBeans(int id,String name,String password,String contact){
		this.id=id;
		this.name=name;
		this.password=password;
		this.contact=contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
