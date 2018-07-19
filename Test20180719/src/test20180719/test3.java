package test20180719;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;

class EmployeeDTO {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private String salary;
	private int commissionPct;
	private String managerId;
	private String departmentId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public int getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(int commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "[employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary=" + salary
				+ ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", departmentId=" + departmentId
				+ "]";
	}

}

class EmployeeDAO {
	Connection conn = null;

	public Connection getConnection() {

		try {
			String user = "hr";
			String pw = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database에 연결되었습니다.\n");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		} // DB접속에 필요한 환경.

		return conn;
	}

	// 결과를 리스트로 반환, 전체조회
	public List<EmployeeDTO> getEmpList() {
		getConnection();

		// 초기화작업
		EmployeeDTO dto = null;
		// EmployeeDate를 담을수 있는 List 생성
		List<EmployeeDTO> list = new ArrayList<>();
		// sql문 저장
		String sql = "select * from employees";
		// sql문 출력
		System.out.println(sql);

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ResultSet은 쿼리문 결과를 담아줄수있는 객체
			ResultSet rs = pstmt.executeQuery();

			// 결과문이 있다면 계속 dto에 값을 넣어준다.
			while (rs.next()) {

				dto = new EmployeeDTO();

				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhoneNumber(rs.getString("phone_number"));
				dto.setHireDate(rs.getString("hire_date"));
				dto.setJobId(rs.getString("job_id"));
				dto.setSalary(rs.getString("salary"));
				dto.setCommissionPct(rs.getInt("commission_pct"));
				dto.setManagerId(rs.getString("manager_id"));
				dto.setDepartmentId(rs.getString("department_id"));

				// EmployeeDate형태의 리스트에 추가. 행의수만큼 리스트의배열 늘어남
				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

}

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO dao = new EmployeeDAO();

		List<EmployeeDTO> list = new ArrayList<>();
		list = dao.getEmpList();
		// 3번 employee 테이블의 전체리스트출력
		System.out.println("===========================================================================================================================================");
		System.out.println("3번. Employee 테이블의 전체리스트 출력");
		System.out.println("------------------------------------------");
		for (EmployeeDTO i : list)
			System.out.println(i);
		System.out.println("===========================================================================================================================================");
		System.out.println("4번. first_name이 Alexander인 사람만 출력");
		System.out.println("------------------------------------------");
		// 4번 조회된 데이터 중에서 first_name이 Alexander를 갖는사람을 출력
		list.stream()
			.filter(firstName -> firstName.getFirstName().equals("Alexander"))
			.forEach(System.out::println);

	}
}
