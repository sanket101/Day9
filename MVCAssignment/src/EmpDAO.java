
public interface EmpDAO {
	
	public boolean insertEmployee(Employee e);
	public boolean updateEmployee(int id,Employee e);
	public Employee getEmployee(int id);
	public boolean deleteEmployee(int id);
}
