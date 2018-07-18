package ERP;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class ProductDAO {
	
	Connection conn = null;
    // ProductDTO객체 초기화.
    ProductDTO dto = null;
    
	//db 연결, Connection형태로 반환.
	public Connection getConnection() {
        try {
            String user = "java"; 
            String pw = "java";
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
	
	public List<ProductDTO> getProductList() {		
		getConnection();		
        // ProductDTO 형태의 구조를 갖는 List 생성
        List<ProductDTO> list = new ArrayList<>();
        // sql문 저장
        String sql = "select p_key, p_name, explanation, b_stock from product"; 
        // sql문 출력
        System.out.println(sql);
        try {
        	// PreparedStatement : sql명령문 담아두는곳 , conn : DB의 연결정보를 가지고 있음
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			// ResultSet은 쿼리문 결과를 담아줄수있는 객체. sql문의 결과가 rs에 저장되어있음. 
			ResultSet rs = pstmt.executeQuery();			
			// 결과문이 있다면(true) 계속 dto에 값을 넣어준다.
		while(rs.next()) { 
				dto = new ProductDTO();
				dto.setPkey(rs.getInt("p_key"));
				dto.setPname(rs.getString("p_name"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setB_stock(rs.getInt("b_stock"));	
				//  dto에 값을 저장한후에 리스트에 추가(등록).
				list.add(dto); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; // 반환.
	}
	// 상품 추가
	public void insertProduct (ProductDTO dto) {
		
		getConnection();
		
		String sql = "insert into product (p_key, p_name, explanation, b_stock)"
					+ "values(product_p_key_seq.nextval, ?, ?, ? )";
				 
				     
		// sql문 출력
	    System.out.println(sql);
			
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPname() ); // 첫번째 ?에 넣을값
			pstmt.setString(2, dto.getExplanation()); // 두번째 ?에 넣을값
			pstmt.setInt(3, dto.getB_stock()); // 세번째 ?에 넣을값
			
			
			int cnt = pstmt.executeUpdate(); // 삽입
			System.out.print(cnt + " 상품이 추가되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
