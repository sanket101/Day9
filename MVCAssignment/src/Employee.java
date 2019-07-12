
public class Employee {
	
	private static int id_counter = 10101;
	
	private int emp_id;
	private String name;
	private String number;
	private String role;
	private String password;
	private boolean isAdmin;
	
	public Employee(String name, String number, String role, String password, boolean isAdmin) {
		this.emp_id = ++this.id_counter;
		this.name = name;
		this.number = number;
		this.role = role;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	public int getEmp_id() {
		return emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
