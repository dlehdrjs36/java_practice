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

			System.out.println("Database�� ����Ǿ����ϴ�.\n");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB ����̹� �ε� ���� :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB ���ӽ��� : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		} // DB���ӿ� �ʿ��� ȯ��.

		return conn;
	}

	// ����� ����Ʈ�� ��ȯ, ��ü��ȸ
	public List<EmployeeDTO> getEmpList() {
		getConnection();

		// �ʱ�ȭ�۾�
		EmployeeDTO dto = null;
		// EmployeeDate�� ������ �ִ� List ����
		List<EmployeeDTO> list = new ArrayList<>();
		// sql�� ����
		String sql = "select * from employees";
		// sql�� ���
		System.out.println(sql);

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ResultSet�� ������ ����� ����ټ��ִ� ��ü
			ResultSet rs = pstmt.executeQuery();

			// ������� �ִٸ� ��� dto�� ���� �־��ش�.
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

				// EmployeeDate������ ����Ʈ�� �߰�. ���Ǽ���ŭ ����Ʈ�ǹ迭 �þ
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
		// 3�� employee ���̺��� ��ü����Ʈ���
		System.out.println("===========================================================================================================================================");
		System.out.println("3��. Employee ���̺��� ��ü����Ʈ ���");
		System.out.println("------------------------------------------");
		for (EmployeeDTO i : list)
			System.out.println(i);
		System.out.println("===========================================================================================================================================");
		System.out.println("4��. first_name�� Alexander�� ����� ���");
		System.out.println("------------------------------------------");
		// 4�� ��ȸ�� ������ �߿��� first_name�� Alexander�� ���»���� ���
		list.stream()
			.filter(firstName -> firstName.getFirstName().equals("Alexander"))
			.forEach(System.out::println);

	}
}
