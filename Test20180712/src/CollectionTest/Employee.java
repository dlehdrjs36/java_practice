package CollectionTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeMgmt mgmt = new EmployeeMgmt();
		
		//EmployeeDTO dto = dao.getEmpDTO("113");
		//System.out.println(dto);
		 
		 Scanner sc = new Scanner(System.in); // 콘솔을 통해 키보드로 입력된값을 읽어옴.		 
	
		 int menu = 0;
		
		 while(true) { 
			System.out.println("menu 선택하세요. 1: 전체 조회(조건), 2: 1건조회, 3: 입력, 4: 수정, 5: 전체조회(map), 6: 종료, 7:리스트(커서)");  
			menu = sc.nextInt();
			switch (menu) {
			case 1: //전체리스트
				mgmt.empListProc();
				break;
			case 2: //단건조회
				mgmt.empDTOProc();
				break;
			case 3: // 입력
				mgmt.insertEmpProc();
				break;
			case 4: // update
				mgmt.updateEmpProc();
				break;
			case 5: // 전체리스트(map)
				mgmt.empListMap();
				break;		
			case 6: // 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);	
			case 7:
				mgmt.empListCursor();
				break;
			}
		}
	} // end of main
}
