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
		
	    // salary가 6000보다 큰 사람만 출력
		 list.stream()
		 	 .filter( salary -> salary.getSalary() > 6000 )
		 	 .forEach(System.out::println);
 System.out.println("========================================================================");
		// 1번 필터, first_name이 7보다 큰사람만 출력. 2번필터 first_name이 7보다 큰사람중에 Alexander만 출력
//		 list.stream()
//	 	 .filter( first_name -> first_name.getFirst_name().length() > 7)
//	 	 .filter( first_name -> first_name.getFirst_name().equals("Alexander"))
//	 	 .forEach(System.out::println);
		 
 		//위의 내용과 동일. 필터를 하나로 합침
		 list.stream()
	 	 	 .filter( first_name -> first_name.getFirst_name().length() > 7 && first_name.getFirst_name().equals("Alexander"))
		 	 .forEach(System.out::println);
	}
	
	

}

