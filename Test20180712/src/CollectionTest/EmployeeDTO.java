package CollectionTest;

import java.util.Formatter;

class EmployeeDTO {
	private String employeeId; // 자바에서는 두단어를붙일때 그냥 붙여쓴다.두번째문자의 첫글자는 대문자로 씀. 오라클의 두단어 붙일때 : employee_id
	private String firstname;
	private String last_name;
	private String email;
	private String job_id;
	private String hire_date;
	
	
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		Formatter fm = new Formatter(); // 코멘트 사용,%-10 (왼쪽정렬하기위해서 -사용, 사용하지않으면 우측정렬함)
		String result = fm.format("%6s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s" ,
				   employeeId, firstname, last_name, email, job_id, hire_date).toString();
		
		return result;
		
		//return "EmployeeDTO [employeeId=" + employeeId + ", firstname=" + firstname + ", last_name=" + last_name	+ ", email=" + email + ", jop_id=" + job_id + "]";
	}
	
	
	
	
	
}
