package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Impliment implements Empinterface{
	
	//connecting with database 
	static String url="jdbc:mysql://localhost:3306/Mahendra";
	String username= "root";
	String password= "root";
	
	Connection con;
	//constructor 
	Impliment() throws SQLException
	{
			con=DriverManager.getConnection(url,username, password);
			System.out.println("Connection established successfully ");
	}

	//Add Employee
	@Override
	public void addEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		String query="insert into Employee (Empid,  Empname, Empsalary)values (?,?,?)";
		
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement(query);
			stmt.setInt(1, employee.getEmpid());
			stmt.setString(2, employee.getEmpname());
			stmt.setDouble(3, employee.getEmpsalary());
			stmt.executeUpdate();
			System.out.println("Employee added succssfully");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		stmt.close();
		}
	
	
	//Remove Employee
	@Override
	public boolean removeEmployee(int EmployeeId) {
	
		String query ="delete from  employee where Empid =?";
		
		try {
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setInt(1, EmployeeId);
			int roweffected=stmt.executeUpdate();
			return roweffected > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
    //fetch  all Employees
	@Override
	public List<Employee> getEmployee() throws SQLException {
		// TODO Auto-generated method stub
		String query="select * from Employee";
		 Statement stmt=null;
		 ResultSet rs=null;
		 
		 List<Employee> emp=new ArrayList<Employee>();
		 
		 try {
			 stmt=con.createStatement();
			 rs=stmt.executeQuery(query);
			 
			 while(rs.next()) {
				 
				 int id= rs.getInt("Empid");
				 String name=rs.getString("Empname");
				 double salary=rs.getDouble("Empsalary");
				 emp.add(new Employee(id, name, salary));
			 }
		 }catch(Exception e) {
			 
		 }
		 stmt.close();
		return emp;
	}
	
	
	//Calculate Total number of Employees
	@Override
	public double calculateTotalEmployee() {
	
		String query="select count(*) as Empname from employee";
		
		try {
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//close connection method 
public 	void closeConnection() throws SQLException {
		if(con !=null) {
			con.close();
			System.out.println("connection closed successfully!!");
		}
		
	}

}
