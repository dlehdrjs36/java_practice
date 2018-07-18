package Test2;

class EmployeeData {

	String first_name;
	String last_name;
	String d_name;
	int salary;
	String salary2;
	
	public String getSalary2() {
		return salary2;
	}
	public void setSalary2(String salary2) {
		this.salary2 = salary2;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "EmployeeData [first_name=" + first_name + ", last_name=" + last_name + ", salary=" + salary + "]";
	}




}
