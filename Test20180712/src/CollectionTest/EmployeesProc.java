package CollectionTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class EmployeesProc {
	EmployeeDAO dao = new EmployeeDAO();

	public void getTitleProc() {
		System.out.println("====================================================================================");
		System.out.println("EmpId\t FirstName\t LastName\t Email\t\t Phone\t\t HireDate");
		System.out.println("====================================================================================");

	}

	public void employeesListProc() {
		System.out.println("\t\t\t\t<<�궗�썝紐⑸줉 由ъ뒪�듃>>");
		getTitleProc();
		List<EmployeeDTO> list = dao.getEmpListCursor();
		for (EmployeeDTO dto : list) {
			System.out.println(dto);
		}

	}

	public void employeesDTOProc() {
		System.out.println("\t\t\t\t<<�궗�썝�젙蹂�>>");
		getTitleProc();
		EmployeeDTO dto = dao.getEmpDTO("101");
		System.out.println(dto);

	}
//엑셀로 저장하는부분
	public void excelExport() throws IOException, WriteException {
		// 워크북만들기 -> Sheet 만들기 -> 셀 만들기.
		WritableWorkbook workbook = Workbook.createWorkbook(new File("new.xls"));
		WritableSheet sheet = workbook.createSheet("emp", 0);
		WritableCellFormat wcf = new WritableCellFormat();
		// 셀옵션 설정
		wcf.setAlignment(Alignment.CENTRE);
		wcf.setBackground(Colour.GOLD);
		WritableFont arial10Bold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
		wcf.setFont(arial10Bold);
		// 시트에 셀번호,크기설정
		sheet.setColumnView(0, 20);
		sheet.setColumnView(1, 20);
		sheet.setColumnView(2, 20);

		// 셀에 순서대로 Data 삽입
		sheet.addCell(new Label(0, 0, "firstName", wcf));
		sheet.addCell(new Label(1, 0, "lastName", wcf));
		sheet.addCell(new Label(2, 0, "hireDate", wcf));
		
		List<EmployeeDTO> list = dao.getEmpListCursor();
		int j = 1;
		for (EmployeeDTO emp : list) {
			Label lblFirstName = new Label(0, j, emp.getFirstname());
			Label lblLastName = new Label(1, j, emp.getLast_name());
			Label lblSalary = new Label(2, j, emp.getHire_date());

			sheet.addCell(lblFirstName);
			sheet.addCell(lblLastName);
			sheet.addCell(lblSalary);
			j++;
		}
		workbook.write();
		workbook.close();
		System.out.println("excel completed.");
	}

	public static void main(String[] args) throws WriteException, IOException {
		EmployeesProc eproc = new EmployeesProc();
		int menu = 4;

		switch (menu) {
		case 1:
			eproc.employeesListProc();
			break;
		case 2:
			eproc.employeesDTOProc();
			break;
		case 3:
			System.out.println("�봽濡쒓렇�옩�쓣 醫낅즺�빀�땲�떎.");
			System.exit(0);
		case 4:
			eproc.excelExport();
		}

	}
}
