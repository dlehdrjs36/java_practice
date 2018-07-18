package Test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamEx2_DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<EmployeeData> list = new ArrayList<>();
		Employee ep = new Employee();		
	    list = ep.getEmpList();
		
	    // salary�� 6000���� ū ����� ���
		 list.stream()
		 	 .filter( salary -> salary.getSalary() > 6000 )
		 	 .forEach(System.out::println);
 System.out.println("========================================================================");
		// 1�� ����, first_name�� 7���� ū����� ���. 2������ first_name�� 7���� ū����߿� Alexander�� ���
//		 list.stream()
//	 	 .filter( first_name -> first_name.getFirst_name().length() > 7)
//	 	 .filter( first_name -> first_name.getFirst_name().equals("Alexander"))
//	 	 .forEach(System.out::println);
		 
 		//���� ����� ����. ���͸� �ϳ��� ��ħ
		 list.stream()
	 	 	 .filter( first_name -> first_name.getFirst_name().length() > 7 && first_name.getFirst_name().equals("Alexander"))
		 	 .forEach(System.out::println);
	}
	
	

}

