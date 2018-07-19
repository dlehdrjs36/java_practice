package test20180719;

import java.util.ArrayList;
import java.util.List;

class Employee {
	private String firstName;
	private String lastName;
	private int salary;
	
	public Employee(String  firstname, String lastname, int salary )
	{
		this.firstName = firstname; 
		this.lastName = lastname;
		this.salary = salary;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return  "\'"+firstName +" "+ lastName +" 의 급여는 " + salary + " 원입니다.\'";
	}
}

public class test1 {public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee("ti", "ta", 30000);
		Employee emp2 = new Employee("tia", "tb", 36000);
		Employee emp3 = new Employee("tias", "tc", 37000);
		
		List<Employee> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		
		for( Employee i : empList ) {
			System.out.println( i );
		}
		
	}

}
