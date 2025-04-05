package code;

import java.sql.SQLException;
import java.util.List;

public interface Empinterface {

	//this is interface that will make a method for implement class.
	
	void addEmployee(Employee employee) throws SQLException;
	
	boolean removeEmployee(int EmployeeId) ;

	double calculateTotalEmployee();
	
	List<Employee> getEmployee() throws SQLException;
	
	void closeConnection() throws SQLException;
	
	
	
}
