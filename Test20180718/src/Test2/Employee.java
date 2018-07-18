package Test2;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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


	
class Employee {
		Connection conn = null;
		
		//db 연결, Connection형태로 반환.
		public Connection getConnection() {
			 
	        try {
	            String user = "hr"; 
	            String pw = "hr";
	            String url = "jdbc:oracle:thin:@localhost:1521:xe";
	            
	            Class.forName("oracle.jdbc.driver.OracleDriver");        
	            conn = DriverManager.getConnection(url, user, pw);
	            
	            System.out.println("Database에 연결되었습니다.\n");       
	        } 
	        catch (ClassNotFoundException cnfe) {
	            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
	        } 
	        catch (SQLException sqle) {
	            System.out.println("DB 접속실패 : "+sqle.toString());
	        }
	        catch (Exception e) {
	            System.out.println("Unkonwn error");
	            e.printStackTrace();
	        } // DB접속에 필요한 환경.
	        
			return conn;
		}
		
		// 결과를 리스트로 반환, 전체조회
		public List<EmployeeData> getEmpList() { 
			// DB연결정보가 들어잇는 conn이 반환됨.
			getConnection();
			
	        // 초기화작업
	        EmployeeData dto = null;
	        // EmployeeDate 형태의 List 생성
	        List<EmployeeData> list = new ArrayList<>();
	        // sql문 저장
	        String sql = "select department_name, first_name, last_name, salary from employees join departments using (department_id)"; 
	        // sql문 출력
	        System.out.println(sql);

	        try {
	        	// PreparedStatement : sql명령문 담아두는곳 , conn : DB의 연결정보를 가지고 있음
				PreparedStatement pstmt = conn.prepareStatement(sql);
				// ResultSet은 쿼리문 결과를 담아줄수있는 객체 
				ResultSet rs = pstmt.executeQuery();
				
				// 결과문이 있다면 계속 dto에 값을 넣어준다.
			while(rs.next()) { 
						
					dto = new EmployeeData();
					
					dto.setFirst_name(rs.getString("first_name"));
					dto.setLast_name(rs.getString("last_name"));
					dto.setD_name(rs.getString("department_name"));
					dto.setSalary2(rs.getString("salary"));
					
					// EmployeeDate형태의 리스트에 추가. 행의수만큼 리스트의배열 늘어남
					list.add(dto); 
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	        
	}
	// DB의 데이터를 엑셀에  삽입
	public void excelExport() throws IOException, WriteException {
	// 워크북만들기 -> Sheet 만들기 -> 셀 만들기.
	WritableWorkbook workbook = Workbook.createWorkbook(new File("new2.xls"));
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
	sheet.setColumnView(3, 20);

	// 셀에 순서대로 Data 삽입
	sheet.addCell(new Label(0, 0, "firstName", wcf));
	sheet.addCell(new Label(1, 0, "lastName", wcf));
	sheet.addCell(new Label(2, 0, "department_name", wcf));
	sheet.addCell(new Label(3, 0, "salary", wcf));
		
	List<EmployeeData> list = getEmpList();
	int j = 1;
	for (EmployeeData emp : list) {
	Label lblFirstName = new Label(0, j, emp.getFirst_name());
	Label lblLastName = new Label(1, j, emp.getLast_name());
	Label lblDName = new Label(2, j, emp.getD_name());
	Label lblSalary = new Label(3, j, emp.getSalary2());

		sheet.addCell(lblFirstName);
		sheet.addCell(lblLastName);
		sheet.addCell(lblDName);
		sheet.addCell(lblSalary);
		j++;
			}
	
			workbook.write();
			workbook.close();
			System.out.println("excel completed.");
		}
	
	public static void main(String[] args) throws WriteException, IOException {
		Employee proc = new Employee();
		int menu = 4;

		switch (menu) {
		case 1:
		
			break;
		case 2:
		
			break;
		case 3:
			System.out.println("�봽濡쒓렇�옩�쓣 醫낅즺�빀�땲�떎.");
			System.exit(0);
		case 4:
			proc.excelExport();
		}

	
	}
}

