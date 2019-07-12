import java.sql.*;

public class EmpDAOImpl implements EmpDAO{
	
	public boolean updateEmployee(int id, Employee e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Sapient123");
			PreparedStatement pstmt = con.prepareStatement("update employee_details set Emp_name=?, Emp_number=?, Emp_role=?, Emp_psw=? where Emp_id=?");
			
			pstmt.setString(1, e.getName());
			pstmt.setString(2, e.getNumber());
			pstmt.setString(3, e.getRole());
			pstmt.setString(4, e.getPassword());
			//pstmt.setBoolean(5, e.isAdmin());
			pstmt.setInt(5, e.getEmp_id());
			pstmt.execute();
			
			pstmt.close();
			con.close();
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}
	
	public boolean insertEmployee(Employee e) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Sapient123");
			PreparedStatement pstmt = con.prepareStatement("Insert into employee_details values (?, ?, ?, ?, ?, ?)");
			
			pstmt.setInt(1, e.getEmp_id());
			pstmt.setString(2, e.getName());
			pstmt.setString(3, e.getNumber());
			pstmt.setString(4, e.getRole());
			pstmt.setString(5, e.getPassword());
			pstmt.setBoolean(6, e.isAdmin());
			pstmt.execute();
			pstmt.close();
			con.close();
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}
	
	public Employee getEmployee(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Sapient123");
			PreparedStatement pstmt = con.prepareStatement("select * from employee_details");
			
			ResultSet rs=pstmt.executeQuery();  
			while(rs.next()){  
				//System.out.println(rs.getInt(1)+" "+rs.getString(2));
				if(rs.getInt(1) == id) {
					return new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
				}
				
			}
			return null;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
	
	public boolean deleteEmployee(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Sapient123");
			PreparedStatement pstmt = con.prepareStatement("delete from employee_details where Emp_id=?");
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}
}
