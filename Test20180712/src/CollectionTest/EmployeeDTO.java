package CollectionTest;

import java.util.Formatter;

class EmployeeDTO {
	private String employeeId; // �ڹٿ����� �δܾ���϶� �׳� �ٿ�����.�ι�°������ ù���ڴ� �빮�ڷ� ��. ����Ŭ�� �δܾ� ���϶� : employee_id
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
		Formatter fm = new Formatter(); // �ڸ�Ʈ ���,%-10 (���������ϱ����ؼ� -���, ������������� ����������)
		String result = fm.format("%6s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s" ,
				   employeeId, firstname, last_name, email, job_id, hire_date).toString();
		
		return result;
		
		//return "EmployeeDTO [employeeId=" + employeeId + ", firstname=" + firstname + ", last_name=" + last_name	+ ", email=" + email + ", jop_id=" + job_id + "]";
	}
	
	
	
	
	
}
