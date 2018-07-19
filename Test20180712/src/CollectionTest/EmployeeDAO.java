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
	
	
	// DB�� ����
	public Connection getConnection() {
		 
        try {
            String user = "hr"; 
            String pw = "hr";
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database�� ����Ǿ����ϴ�.\n");       
        } 
        catch (ClassNotFoundException cnfe) {
            System.out.println("DB ����̹� �ε� ���� :"+cnfe.toString());
        } 
        catch (SQLException sqle) {
            System.out.println("DB ���ӽ��� : "+sqle.toString());
        }
        catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        } // DB���ӿ� �ʿ��� ȯ��.
        
		return conn;
	}
	
	// �� ����.
	public void insertEmp(EmployeeDTO dto ) { // �Ű������� ��Ծ����ʱ����ؼ� dto��ü�� �޾ƿͼ� �װ����ִ� �޼ҵ�� ��������� ������ ���� ����.
		
		getConnection();
		
		String sql = "insert into employees (employee_id, first_name, last_name, email, hire_date, job_id)" + 
				     "values(?, ?, ?, ?, sysdate, ?) ";
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployeeId() ); // ù��° ?�� ������
			pstmt.setString(2, dto.getFirstname()); // �ι�° ?�� ������
			pstmt.setString(3, dto.getLast_name()); // ����° ?�� ������
			pstmt.setString(4, dto.getEmail()); // �׹�° ?�� ������
			pstmt.setString(5, dto.getJob_id() ); // �ټ���° ?�� ������
			
			int cnt = pstmt.executeUpdate(); // ����
			System.out.print(cnt + " ���� �ԷµǾ����ϴ�.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	// ���� ���ν��� �ҷ���.
	public void insertEmpProc(EmployeeDTO dto) {
		
		getConnection();
		
		try {
			CallableStatement cstmt = conn.prepareCall("{call insert_emp_proc(?,?,?,?)}");
			cstmt.setString(1, dto.getFirstname());
			cstmt.setString(2, dto.getLast_name());
			cstmt.setString(3, dto.getEmail());
			cstmt.setString(4, dto.getJob_id());
			int r = cstmt.executeUpdate();
			System.out.println( r + "�� �ԷµǾ����ϴ�.(Proc)" );		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// ���ν����� �̿��� ������Ʈ.
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
			System.out.println( r + "���� �����Ǿ����ϴ�.(Proc)" );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateEmp(EmployeeDTO dto) {
		getConnection();
		int c = 0; // ���ڷνᵵ������ ������ġ�� �ٲ����� �����ϱ������. ���� ī��Ʈ ���.
		String sql = "update employees set first_name =?, last_name =?, email =?, job_id =?"
				  +  "where employee_id = ? ";  
			     
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(++c, dto.getFirstname()); // ù��° ?�� ������
			pstmt.setString(++c, dto.getLast_name()); // �ι�° ?�� ������
			pstmt.setString(++c, dto.getEmail()); // ����° ?�� ������
			pstmt.setString(++c, dto.getJob_id() ); // �׹�° ?�� ������
			pstmt.setString(++c, dto.getEmployeeId() ); // �ټ���° ?�� ������
			
			int cnt = pstmt.executeUpdate(); // ����,����,������Ʈ
			
			System.out.print(cnt + " ���� �����Ǿ����ϴ�..");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					conn.close();	// �����ϸ� ���� ���� ���־����.
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		
	}
	
	
	// 1���ڷḮ��
	public EmployeeDTO getEmpDTO(String emp_id) {
		
        getConnection();
        
        EmployeeDTO dto = null; // <- ����� ������ ����
            
        String sql = "select employee_id, first_name, last_name, email, job_id from employees " 
        		+ "where employee_id = ?";
        
        try {
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql��ɹ� ��Ƶ�
			pstmt.setString( 1, emp_id);
			ResultSet rs = pstmt.executeQuery(); // ResultSet�� ������ ������¸� ����ټ��ִ� ��ü 
			// �μ�Ʈ�� ������Ʈ�� executeupdate ���, ����� �������°��� executeQuery ���
			
			if(rs.next()) { // ���������� ���.�� ����Ʈ�� ��ȯ.
			//	System.out.println(rs.getString("first_name")+ " "+rs.getInt("employee_id")); // ���ϵǴ� ���� Ÿ�Կ����� String,Int �����. ���α׷����� ������ְ� ����. ���α׷����� DB�� ��� �ְ�ް��ϱ����� �ٸ�������� ����
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
	
	// ��ü �ڷ� ����
	public List<EmployeeDTO> getEmpList(SearchVO vo) { 
		
		getConnection();

        // �ʱ�ȭ�۾�
        EmployeeDTO dto = null;
        List<EmployeeDTO> list = new ArrayList<>();
         
        //first name�� ��ȸ�ϰ�ʹ�.
        String whereClause = "Where 1 = 1 ";
        
        
           if(vo.getSearchCondition().equals("first_name")) { // SearchVO�� �۽�Ʈ������ ��������,
        	whereClause += " and first_name like '%"+vo.getSearchKeyword()+"%'"; // VO�� ������ִ� ��ġŰ���带 �����ϴ°��� �˻��ϰڴ�.
        	// || ��������ʰ� ó���Ѱ�. || ����ѰͰ� ��� ����
           }    
        /*
         * if(vo.getSearchCondition().equals("first_name")) { // SearchVO�� �۽�Ʈ������ ��������,
        	whereClause += " and first_name like '%'||'"+vo.getSearchKeyword()+"'||'%'"; // VO�� ������ִ� ��ġŰ���带 �����ϴ°��� �˻��ϰڴ�.
        	// || �ڹٿ����� '%'�� �������ֱ����ؼ� || ����ؾ���. ( vo.getSearchKeyword() �� ���ڷ� ó�����ֱ����ؼ� )
        }
        */
        
        
           else if(vo.getSearchCondition().equals("hire_date")) {	//SearchVO�� hire_date�� ��������,
           	whereClause += " and hire_date > to_date("+vo.getSearchKeyword()+" , 'rrrrmmdd')"; 
           }
           
           else { // vo.getSearchCondition()�� ���� "���Ǿ�����ü��ȸ" �� ������� �׳� �����
        	 	 
           }
           
        /*  // �Էµ� �Ի��ϰ� �������� �Ի��� ������� ���.
         *  if(vo.getSearchCondition().equals("hire_date")) {
        	whereClause += " and hire_date like to_date("+vo.getSearchKeyword()+" , 'rrrrmmdd')";        	
        }
        */
          
        
        
           String sql = "select employee_id, first_name, last_name, email, job_id, hire_date from employees "
        		   		+ whereClause + " and rownum < 10 order by 1 desc"; // �� 10���������� ���
           
           System.out.println(sql);
        	
        	
        // String sql = "select employee_id, first_name, last_name, email from employees " + "where employee_id = ? "; 
        // String sql = "select employee_id, first_name, last_name, email, job_id from employees order by 1 desc ";
        			
        try {
			PreparedStatement pstmt = conn.prepareStatement(sql); // sql��ɹ� ��Ƶ�
			ResultSet rs = pstmt.executeQuery(); // ResultSet�� ������ ������¸� ����ټ��ִ� ��ü 
			// �μ�Ʈ�� ������Ʈ�� executeupdate ���, ����� �������°��� executeQuery ���
			
			while(rs.next()) { // ���������� ���.�� ����Ʈ�� ��ȯ. rs.next() : ���������� ���� ������ null�� ��ȯ
				
			//	System.out.println(rs.getString("first_name")+ " "+rs.getInt("employee_id")); // ���ϵǴ� ���� Ÿ�Կ����� String,Int �����. ���α׷����� ������ְ� ����. ���α׷����� DB�� ��� �ְ�ް��ϱ����� �ٸ�������� ����
				dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setFirstname(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setJob_id(rs.getString("job_id"));
				dto.setHire_date(rs.getString("hire_date"));

				list.add(dto); // dtoŸ���� ù��° �迭�� emp,first,last,email ������ ���.
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
        
	}
	
	
	
	
	// xml, jason ���� map�� �־ �����ϴ� �ڷ����¸� ���
	public List<Map<String, Object>> getEmpListMap() {
		getConnection();
		
		String sql = "select employee_id, first_name from employees";
		
		Map<String, Object> map = null;
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				map = new HashMap<>(); //���� ���������� ���ο� �� �����Ͽ� �־���
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
	public List<EmployeeDTO> getEmpListCursor() { // ���ν��� ����ؼ� �����
		
		getConnection();
		List<EmployeeDTO> list = new ArrayList<>();
		EmployeeDTO dto = null;
		
		try {
			CallableStatement cstmt = conn.prepareCall("{call get_emplist_proc(?,?,?)}");
			cstmt.setInt(1, 500);
			cstmt.setDate(2, new Date(100,0,1)); // �⺻���� 1900��1��1��. 100�� ���ָ�  2000��
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