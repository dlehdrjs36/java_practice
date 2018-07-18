package CollectionTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jxl.write.WriteException;

public class Employee {

	public static void main(String[] args) throws WriteException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		EmployeeMgmt mgmt = new EmployeeMgmt();
		EmployeeDAO dao = new EmployeeDAO();
		//EmployeeDTO dto = dao.getEmpDTO("113");
		//System.out.println(dto);
		 
		 Scanner sc = new Scanner(System.in); // �ܼ��� ���� Ű����� �ԷµȰ��� �о��.		 
	
		 int menu = 0;
		
		 while(true) { 
			System.out.println("menu �����ϼ���. 1: ��ü ��ȸ(����), 2: 1����ȸ, 3: �Է�, 4: ����, 5: ��ü��ȸ(map), 6: ����, 7:����Ʈ(Ŀ��)");  
			menu = sc.nextInt();
			switch (menu) {
			case 1: //��ü����Ʈ
				mgmt.empListProc();
				break;
			case 2: //�ܰ���ȸ
				mgmt.empDTOProc();
				break;
			case 3: // �Է�
				mgmt.insertEmpProc();
				break;
			case 4: // update
				mgmt.updateEmpProc();
				break;
			case 5: // ��ü����Ʈ(map)
				mgmt.empListMap();
				break;		
			case 6: // ����
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);	
			case 7:
				mgmt.empListCursor();
				break;
			case 8:
				break;
			}
		}
	} // end of main
}
