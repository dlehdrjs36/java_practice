package CollectionTest;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CollectionTest.SearchVO;
//import jxl.Workbook;
//import jxl.format.Alignment;
//import jxl.write.WritableCellFormat;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;

public class EmployeeDAO {
	
	Connection conn = null;
	
	
	// DB와 연결
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
	
	// 행 삽입.
	public void insertEmp(EmployeeDTO dto ) { // 매개변수를 길게쓰지않기위해서 dto객체를 받아와서 그곳에있는 메소드로 멤버변수를 꺼내서 값을 얻어옴.
		
		getConnection();
		
		String sql = "insert into employees (employee_id, first_name, last_name, email, hire_date, job_id)" + 
				     "values(?, ?, ?, ?, sysdate, ?) ";
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployeeId() ); // 첫번째 ?에 넣을값
			pstmt.setString(2, dto.getFirstname()); // 두번째 ?에 넣을값
			pstmt.setString(3, dto.getLast_name()); // 세번째 ?에 넣을값
			pstmt.setString(4, dto.getEmail()); // 네번째 ?에 넣을값
			pstmt.setString(5, dto.getJob_id() ); // 다섯번째 ?에 넣을값
			
			int cnt = pstmt.executeUpdate(); // 삽입
			System.out.print(cnt + " 건이 입력되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	// 삽입 프로시저 불러옴.
	public void insertEmpProc(EmployeeDTO dto) {
		
		getConnection();
		
		try {
			CallableStatement cstmt = conn.prepareCall("{call insert_emp_proc(?,?,?,?)}");
			cstmt.setString(1, dto.getFirstname());
			cstmt.setString(2, dto.getLast_name());
			cstmt.setString(3, dto.getEmail());
			cstmt.setString(4, dto.getJob_id());
			int r = cstmt.executeUpdate();
			System.out.println( r + "건 입력되었습니다.(Proc)" );		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// 프로시저를 이용한 업데이트.
	public void UpdateEmpProc (EmployeeDTO dto) {
		getConnection();
		
		try {
			CallableStatement cstmt = conn.prepareCall("{ call update_emp_proc(?,?,?,?,?) }");
			cstmt.setString(1, dto.getFirstname());
			cstmt.setString(2, dto.getLast_name());
			cstmt.setString(3, dto.getEmail());
			cstmt.setString(4, dto.getJob_id());
			cstmt.setString(5, dto.getEmployeeId());
			
			int r = cstmt.executeUpdate();
			System.out.println( r + "건이 수정되었습니다.(Proc)" );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateEmp(EmployeeDTO dto) {
		getConnection();
		int c = 0; // 숫자로써도되지만 변수위치가 바꼇을때 수정하기귀찮음. 따로 카운트 사용.
		String sql = "update employees set first_name =?, last_name =?, email =?, job_id =?"
				  +  "where employee_id = ? ";  
			     
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(++c, dto.getFirstname()); // 첫번째 ?에 넣을값
			pstmt.setString(++c, dto.getLast_name()); // 두번째 ?에 넣을값
			pstmt.setString(++c, dto.getEmail()); // 세번째 ?에 넣을값
			pstmt.setString(++c, dto.getJob_id() ); // 네번째 ?에 넣을값
			pstmt.setString(++c, dto.getEmployeeId() ); // 다섯번째 ?에 넣을값
			
			int cnt = pstmt.executeUpdate(); // 삽입,삭제,업데이트
			
			System.out.print(cnt + " 건이 수정되었습니다..");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					conn.close();	// 사용다하면 연결 종료 해주어야함.
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		
	}
	
	
	// 1개자료리턴
	public EmployeeDTO getEmpDTO(String emp_id) {
		
        getConnection();
        
        EmployeeDTO dto = null; // <- 여기다 정보를 담음
            
        String sql = "select employee_id, first_name, last_name, email, job_id from employees " 
        		+ "where employee_id = ?";
        
        try {
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql명령문 담아둠
			pstmt.setString( 1, emp_id);
			ResultSet rs = pstmt.executeQuery(); // ResultSet은 쿼리문 결과형태를 담아줄수있는 객체 
			// 인서트나 업데이트는 executeupdate 사용, 결과를 가져오는것은 executeQuery 사용
			
			if(rs.next()) { // 쿼리수행한 결과.를 리스트로 반환.
			//	System.out.println(rs.getString("first_name")+ " "+rs.getInt("employee_id")); // 리턴되는 값의 타입에따라서 String,Int 사용함. 프로그램에서 출력해주고 끝남. 프로그램에서 DB와 계속 주고받고하기위해 다른방식으로 구현
				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstname(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setJob_id(rs.getString("job_id"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
        
	}
	
	// 전체 자료 리턴
	public List<EmployeeDTO> getEmpList(SearchVO vo) { 
		
		getConnection();

        // 초기화작업
        EmployeeDTO dto = null;
        List<EmployeeDTO> list = new ArrayList<>();
         
        //first name을 조회하고싶다.
        String whereClause = "Where 1 = 1 ";
        
        
           if(vo.getSearchCondition().equals("first_name")) { // SearchVO에 퍼스트네임이 들어왔을때,
        	whereClause += " and first_name like '%"+vo.getSearchKeyword()+"%'"; // VO에 담겨져있는 서치키워드를 포함하는것을 검색하겠다.
        	// || 사용하지않고 처리한것. || 사용한것과 결과 동인
           }    
        /*
         * if(vo.getSearchCondition().equals("first_name")) { // SearchVO에 퍼스트네임이 들어왔을떄,
        	whereClause += " and first_name like '%'||'"+vo.getSearchKeyword()+"'||'%'"; // VO에 담겨져있는 서치키워드를 포함하는것을 검색하겠다.
        	// || 자바에서는 '%'를 연결해주기위해서 || 사용해야함. ( vo.getSearchKeyword() 를 문자로 처리해주기위해서 )
        }
        */
        
        
           else if(vo.getSearchCondition().equals("hire_date")) {	//SearchVO에 hire_date가 들어왔을때,
           	whereClause += " and hire_date > to_date("+vo.getSearchKeyword()+" , 'rrrrmmdd')"; 
           }
           
           else { // vo.getSearchCondition()의 값이 "조건없이전체조회" 가 왔을경우 그냥 통과함
        	 	 
           }
           
        /*  // 입력된 입사일과 같은날에 입사한 사원정보 출력.
         *  if(vo.getSearchCondition().equals("hire_date")) {
        	whereClause += " and hire_date like to_date("+vo.getSearchKeyword()+" , 'rrrrmmdd')";        	
        }
        */
          
        
        
           String sql = "select employee_id, first_name, last_name, email, job_id, hire_date from employees "
        		   		+ whereClause + " and rownum < 10 order by 1 desc"; // 행 10개보다적게 출력
           
           System.out.println(sql);
        	
        	
        // String sql = "select employee_id, first_name, last_name, email from employees " + "where employee_id = ? "; 
        // String sql = "select employee_id, first_name, last_name, email, job_id from employees order by 1 desc ";
        			
        try {
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql명령문 담아둠
			ResultSet rs = pstmt.executeQuery(); // ResultSet은 쿼리문 결과형태를 담아줄수있는 객체 
			// 인서트나 업데이트는 executeupdate 사용, 결과를 가져오는것은 executeQuery 사용
			
			while(rs.next()) { // 쿼리수행한 결과.를 리스트로 반환. rs.next() : 값이있으면 수행 없으면 null값 반환
				
			//	System.out.println(rs.getString("first_name")+ " "+rs.getInt("employee_id")); // 리턴되는 값의 타입에따라서 String,Int 사용함. 프로그램에서 출력해주고 끝남. 프로그램에서 DB와 계속 주고받고하기위해 다른방식으로 구현
				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstname(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setJob_id(rs.getString("job_id"));
				dto.setHire_date(rs.getString("hire_date"));

				list.add(dto); // dto타입의 첫번째 배열에 emp,first,last,email 정보가 담김.
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
        
	}
	
	
	
	
	// xml, jason 에서 map을 넣어서 전달하는 자료형태를 사용
	public List<Map<String, Object>> getEmpListMap() {
		getConnection();
		
		String sql = "select employee_id, first_name from employees";
		
		Map<String, Object> map = null;
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				map = new HashMap<>(); //값이 있을때마다 새로운 맵 생성하여 넣어줌
				map.put("employee_id", rs.getString("employee_id"));
				map.put("first_name", rs.getString("first_name"));
				list.add(map);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	
	}
	
	//
	public List<EmployeeDTO> getEmpListCursor() { // 프로시저 사용해서 만든것
		
		getConnection();
		List<EmployeeDTO> list = new ArrayList<>();
		EmployeeDTO dto = null;
		
		try {
			CallableStatement cstmt = conn.prepareCall("{call get_emplist_proc(?,?,?)}");
			cstmt.setInt(1, 500);
			cstmt.setDate(2, new Date(100,0,1)); // 기본설정 1900년1월1일. 100을 써주면  2000년
			cstmt.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.executeQuery();
			ResultSet rs = (ResultSet)cstmt.getObject(3);
			while(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstname(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setJob_id(rs.getString("job_id"));
				dto.setHire_date(rs.getString("hire_date"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;		
	}
	

}