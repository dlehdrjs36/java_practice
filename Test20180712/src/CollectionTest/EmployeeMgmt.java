package CollectionTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeMgmt {
	EmployeeDAO dao = new EmployeeDAO();
	Scanner sc = new Scanner(System.in);
	//전체조회
	public void empListProc() {
		SearchVO vo = new SearchVO();
		System.out.println("조회조건을 입력하세요. ( 1:first_name , 2:hire_date, 3:조건없이 조회  )");
		String empcondition = sc.nextLine();
		
		
		if ( empcondition.equals("1")) 
		{
			vo.setSearchCondition("first_name");
			System.out.println("단어을 입력하세요. ( 입력한 단어를 가지고 있는 first_name 행들이 출력됩니다. )");
			String empfname = sc.nextLine();
			vo.setSearchKeyword(empfname); // 검색할 단어는 e가 포함되어야 한다.
		}
		
		else if ( empcondition.equals("2")) 
		{
			vo.setSearchCondition("hire_date");
			System.out.println("날짜를 입력하세요.(rrrrmmdd) ");
			String empDate = sc.nextLine();
			vo.setSearchKeyword(empDate); // 검색할 단어는 e가 포함되어야 한다.
		}
		else {
			vo.setSearchCondition("조건없이전체조회");
		}
		
		
		
		List<EmployeeDTO> list = dao.getEmpList(vo);
		System.out.println("                                        <전체리스트> ");
		System.out.println("==============================================================================================");
		System.out.println("= EmpID | firstname |     last_name     |    email    |    job_id    |       hire_date       =");
		System.out.println("==============================================================================================");
		// 출력
		for(EmployeeDTO dto : list) {
			System.out.println(dto); 
		}
		System.out.println("==============================================================================================");
	}
		
	
		
		// 단건조회
	public void empDTOProc() {
		System.out.println("조회할 사원번호를 입력하세요.");
		String empNo = sc.nextLine();	// 사용자가 입력한게 nextLine()을 이용해서 담음
		
		EmployeeDTO dto = dao.getEmpDTO(empNo);
		System.out.println(dto);
	}
	// 입력
	public void insertEmpProc() {
	//	System.out.println("사원번호를 입력하세요.");
	//	String empNo = sc.nextLine();
		System.out.println("이름을 입력하세요.");
		String firstName = sc.nextLine();
		System.out.println("성을 입력하세요.");
		String lastName = sc.nextLine();
		System.out.println("이메일을 입력하세요.");
		String email = sc.nextLine();
		System.out.println("직무를 입력하세요.");
		String job = sc.nextLine();
		
		EmployeeDTO dto = new EmployeeDTO();
		
	//	dto.setEmployeeId(empNo);
		dto.setFirstname(firstName);
		dto.setLast_name(lastName);
		dto.setEmail(email);
		dto.setJob_id(job);	
		
		// dao.insertEmp(dto);
		dao.insertEmpProc(dto);
	}
	// update
	public void updateEmpProc() {
		System.out.println("수정할 사원번호를 입력하세요.");
		String empNo = sc.nextLine();
		System.out.println("수정할 이름을 입력하세요.");
		String firstName = sc.nextLine();
		System.out.println("수정할 성을 입력하세요.");
		String lastName = sc.nextLine();
		System.out.println("수정할 이메일을 입력하세요.");
		String email = sc.nextLine();
		System.out.println("수정할 직무를 입력하세요.");
		String job = sc.nextLine();
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployeeId(empNo);
		dto.setFirstname(firstName);
		dto.setLast_name(lastName);
		dto.setEmail(email);
		dto.setJob_id(job);	
		//dao.UpdateEmp(dto);
		dao.UpdateEmpProc(dto);
	}
	// 전체조회(Map)
	public void empListMap() {	
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = dao.getEmpListMap();
		for(Map<String, Object> map : list) 
		{
			System.out.println(map);
		}			
	}
	// 커서에받은내용을 얻어옴.
	public void empListCursor() {
		List<EmployeeDTO> list = dao.getEmpListCursor();
		for ( EmployeeDTO d : list) {
			System.out.println(d);
		}
	}
	
}
