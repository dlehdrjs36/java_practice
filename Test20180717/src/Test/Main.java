package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class EmployeeDAO {
	Connection conn = null;

	//db 연결
	public Connection getConnection() {
		 
        try {
            String user = "hr"; 
            String pw = "hr";
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database에 연결되었습니다.\n");       
        } 
        catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } 
        catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
        }
        catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        } // DB접속에 필요한 환경.
        
		return conn;
	}
	
	// 결과를 리스트로 반환, 전체조회
	public List<Employee> getEmpList() { 
		
		getConnection();
		
        // 초기화작업
        Employee dto = null;
        List<Employee> list = new ArrayList<>();
       
        String sql = "select first_name, last_name, salary, department_name from employees join departments " + 
        		"USING (department_id) order by 3 desc"; 
           
        System.out.println(sql);

        try {
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql명령문 담아둠
			ResultSet rs = pstmt.executeQuery(); // ResultSet은 쿼리문 결과형태를 담아줄수있는 객체 
		while(rs.next()) { 
					
				dto = new Employee();
				
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setSalary(rs.getDouble("salary"));
				dto.setDepartment(rs.getString("department_name"));

				list.add(dto); 
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
        
	}
}

class Employee {
	private String firstName;
	private String lastName;
	private double salary;
	private String department;
	
	
	public Employee() {

	}
	
	
	
	public Employee(String firstName, String lastName, double salary, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	// return Employee's first and last name combined
	public String getName() {
		return String.format("%s %s", getFirstName(), getLastName());
	}

	@Override
	public String toString() {
		// return "Employee [firstName=" + firstName + ", lastName=" + lastName + ",
		// salary=" + salary + ", department=" + department + "]";
		String str = "==================================================\n";
		str.replace("=", "-");
		return String.format("%30s\n %-8s %-8s %8.2f   %s",str, firstName, lastName, salary, department);
	}

}

public class Main {
// 변경할부분 
	public static void main(String[] args) {
	/*	Employee[] employees = { new Employee("J", "Red", 51000, "IT"), new Employee("A", "Green", 71600, "IT"),
				new Employee("M", "Black", 35187.5, "Sales"), new Employee("K", "Yellow", 47100.77, "Marketing"),
				new Employee("L", "Pink", 62001, "IT"), new Employee("D", "Blue", 32001, "Sales"),
				new Employee("W", "Brown", 42361.4, "Marketing") };  db로 땡겨오는거로 바꾸기 */
//
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> list = new ArrayList<>();
		list = dao.getEmpList();
		
		


		// display all Employees
		System.out.println("Complete Employee list:");

		list.stream().forEach(System.out::println);

		// group Employees by department
		System.out.printf("%nEmployees by department:%n");
		Map<String, List<Employee>> groupedByDepartment = 
		       list.stream()
				   .collect(Collectors.groupingBy(Employee::getDepartment));
	
		groupedByDepartment.forEach((department, employeesInDepartment) -> {
			System.out.println(department);
			employeesInDepartment.forEach(employee -> System.out.printf(" %s%n", employee));
		});
// 수정하기
	}// end of main
}
