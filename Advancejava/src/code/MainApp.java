package code;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainApp {
	
	public static void main(String[] args) throws SQLException {
		
		
		Empinterface em=new Impliment();
		Scanner sc=new Scanner(System.in);
		
		//add employee
		try {
			boolean exit = false;
	
		while (!exit) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Remove Employee");
            System.out.println("4. Count Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            
            
           int choice=sc.nextInt();
           
           switch(choice) {
           
           case 1: 
        	   //Add Employee
        	   
        	   //Employee id
        	   System.out.println("Enter Employee id");
        	   int Empid=sc.nextInt();
        	   
        	   //Employee name
        	   System.out.println("Enter Employee name ");
        	   String Empname=sc.next();
        	   
        	   //Salary
        	   System.out.println("Enter Employee salary");
        	   double Empsalary=sc.nextDouble();
        	   
        	   Employee emp=new Employee(Empid,Empname,Empsalary);
        	   em.addEmployee(emp);
        	   break;
        	   
           case 2: 
        	   //View Employee
        	   List<Employee> employees=em.getEmployee();
        	   System.out.println("all Employees");
        	   
        	   for(Employee e: employees) {
        		   System.out.println(e.getEmpid()+" | "+ e.getEmpname()+" | "+ e.getEmpsalary());
        	   }
        	   break;
        		   
           case 3://Remove Employee
        	   
        	   System.out.println("Enter id to remove employee");
        	   int removeid=sc.nextInt();
        	   
        	   boolean isdeleted=em.removeEmployee(removeid);
        	   if(isdeleted) {
        		   System.out.println("employee  is deleted ");
        	   }else {
        		   System.out.println("employee id is not found ");
        	   }
        	   
        	   break;
        	   
           case 4: //Total count of Employee
        	   double TotalEmployee=em.calculateTotalEmployee();
        	   System.out.println(TotalEmployee);
        	   
        	   break;
        	   
        	   
           case 5://exit
        	   System.out.println("exit and closing connection ");
        	   em.closeConnection();
        	   exit=false;
        	   break;
        	   
        	   
        	   default: System.out.println("you enter wrong choice ");
        	   }
        	   
           }
            
            
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		sc.close();
		}
		
		
		
	}
	

}




