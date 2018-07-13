package CollectionTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeMgmt {
	EmployeeDAO dao = new EmployeeDAO();
	Scanner sc = new Scanner(System.in);
	//��ü��ȸ
	public void empListProc() {
		SearchVO vo = new SearchVO();
		System.out.println("��ȸ������ �Է��ϼ���. ( 1:first_name , 2:hire_date, 3:���Ǿ��� ��ȸ  )");
		String empcondition = sc.nextLine();
		
		
		if ( empcondition.equals("1")) 
		{
			vo.setSearchCondition("first_name");
			System.out.println("�ܾ��� �Է��ϼ���. ( �Է��� �ܾ ������ �ִ� first_name ����� ��µ˴ϴ�. )");
			String empfname = sc.nextLine();
			vo.setSearchKeyword(empfname); // �˻��� �ܾ�� e�� ���ԵǾ�� �Ѵ�.
		}
		
		else if ( empcondition.equals("2")) 
		{
			vo.setSearchCondition("hire_date");
			System.out.println("��¥�� �Է��ϼ���.(rrrrmmdd) ");
			String empDate = sc.nextLine();
			vo.setSearchKeyword(empDate); // �˻��� �ܾ�� e�� ���ԵǾ�� �Ѵ�.
		}
		else {
			vo.setSearchCondition("���Ǿ�����ü��ȸ");
		}
		
		
		
		List<EmployeeDTO> list = dao.getEmpList(vo);
		System.out.println("                                        <��ü����Ʈ> ");
		System.out.println("==============================================================================================");
		System.out.println("= EmpID | firstname |     last_name     |    email    |    job_id    |       hire_date       =");
		System.out.println("==============================================================================================");
		// ���
		for(EmployeeDTO dto : list) {
			System.out.println(dto); 
		}
		System.out.println("==============================================================================================");
	}
		
	
		
		// �ܰ���ȸ
	public void empDTOProc() {
		System.out.println("��ȸ�� �����ȣ�� �Է��ϼ���.");
		String empNo = sc.nextLine();	// ����ڰ� �Է��Ѱ� nextLine()�� �̿��ؼ� ����
		
		EmployeeDTO dto = dao.getEmpDTO(empNo);
		System.out.println(dto);
	}
	// �Է�
	public void insertEmpProc() {
	//	System.out.println("�����ȣ�� �Է��ϼ���.");
	//	String empNo = sc.nextLine();
		System.out.println("�̸��� �Է��ϼ���.");
		String firstName = sc.nextLine();
		System.out.println("���� �Է��ϼ���.");
		String lastName = sc.nextLine();
		System.out.println("�̸����� �Է��ϼ���.");
		String email = sc.nextLine();
		System.out.println("������ �Է��ϼ���.");
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
		System.out.println("������ �����ȣ�� �Է��ϼ���.");
		String empNo = sc.nextLine();
		System.out.println("������ �̸��� �Է��ϼ���.");
		String firstName = sc.nextLine();
		System.out.println("������ ���� �Է��ϼ���.");
		String lastName = sc.nextLine();
		System.out.println("������ �̸����� �Է��ϼ���.");
		String email = sc.nextLine();
		System.out.println("������ ������ �Է��ϼ���.");
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
	// ��ü��ȸ(Map)
	public void empListMap() {	
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = dao.getEmpListMap();
		for(Map<String, Object> map : list) 
		{
			System.out.println(map);
		}			
	}
	// Ŀ�������������� ����.
	public void empListCursor() {
		List<EmployeeDTO> list = dao.getEmpListCursor();
		for ( EmployeeDTO d : list) {
			System.out.println(d);
		}
	}
	
}
