package ERP;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
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

	// db 연결, Connection형태로 반환.
	public Connection getConnection() {
		try {
			String user = "java";
			String pw = "java";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("Database에 연결되었습니다.\n");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		} // DB접속에 필요한 환경.
		return conn;
	}

	// 상품목록 출력.
	public List<ProductDTO> getProductList() {
		getConnection();
		// ProductDTO 형태의 구조를 갖는 List 생성
		List<ProductDTO> list = new ArrayList<>();
		// sql문 저장
		String sql = "select p_key, p_name, explanation, b_stock, price from product";
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		System.out.println("    P_KEY    " + "   P_NAME   " + "   EXPLANATION   " + "   B_STOCK   " + "   PRICE   ");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");

		try {
			// PreparedStatement : sql명령문 담아두는곳 , conn : DB의 연결정보를 가지고 있음
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ResultSet은 쿼리문 결과를 담아줄수있는 객체. sql문의 결과가 rs에 저장되어있음.
			ResultSet rs = pstmt.executeQuery();
			// 결과문이 있다면(true) 계속 dto에 값을 넣어준다.
			while (rs.next()) {
				dto = new ProductDTO();
				dto.setPkey(rs.getInt("p_key"));
				dto.setPname(rs.getString("p_name"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setB_stock(rs.getInt("b_stock"));
				dto.setPrice(rs.getInt("price"));
				// dto에 값을 저장한후에 리스트에 추가(등록).
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; // 반환.
	}

	// 상품 추가
	public void insertProduct(ProductDTO dto) {

		getConnection();

		String sql = "insert into product (p_key, p_name, explanation, b_stock, price)"
				+ "values(product_p_key_seq.nextval, ?, ?, ?, ? )";

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getPname()); // 첫번째 ?에 넣을값
			pstmt.setString(2, dto.getExplanation()); // 두번째 ?에 넣을값
			pstmt.setInt(3, dto.getB_stock()); // 세번째 ?에 넣을값
			pstmt.setInt(4, dto.getPrice()); // 네번째 ?에 넣을값

			int cnt = pstmt.executeUpdate(); // 삽입

			System.out.println("상품이름 = \"" + dto.getPname() + "\"" + "가 " + cnt + "건" + " 추가되었습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 상품수정
	public void updateProduct(ProductDTO dto) {
		getConnection();
		
		int c = 0; // 숫자로써도되지만 변수위치가 바꼇을때 수정하기귀찮음. 따로 카운트 사용.
		String sql = "update product set p_name = ?, explanation = ? , b_stock = ? , price = ? where p_key = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(++c, dto.getPname()); // 첫번째 ?에 넣을값
			pstmt.setString(++c, dto.getExplanation()); // 두번째 ?에 넣을값
			pstmt.setInt(++c, dto.getB_stock()); // 세번째 ?에 넣을값
			pstmt.setInt(++c, dto.getPrice()); // 네번째 ?에 넣을값
			pstmt.setInt(++c, dto.getPkey()); // 다섯번째 ?에 넣을값

			int cnt = pstmt.executeUpdate(); // 삽입,삭제,업데이트
			
			System.out.println("상품키 = \"" + dto.getPkey() + "\"" + "가 " + cnt + "건" + " 수정되었습니다.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 사용다하면 연결 종료 해주어야함.
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 상품제거
	public void deleteProduct(ProductDTO dto) {
		getConnection();
		int c = 0; // 숫자로써도되지만 변수위치가 바꼇을때 수정하기귀찮음. 따로 카운트 사용.
		String sql = "delete from product where p_key = ? ";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(++c, dto.getPkey()); // 첫번째 ?에 넣을값

			int cnt = pstmt.executeUpdate(); // 삽입,삭제,업데이트

			System.out.println("상품키 \'" + dto.getPkey() + "\'가  제거되었습니다..");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 사용다하면 연결 종료 해주어야함.
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 입출고정보 출력
	public List<ProductDTO> getSRList() {
		getConnection();
		// ProductDTO 형태의 구조를 갖는 List 생성
		List<ProductDTO> list = new ArrayList<>();
		// sql문 저장
		String sql = "select sr_key, p_key, stored, released, storage_name, sr_date from store_release";
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		System.out.println("    SR_KEY    " + "   P_KEY   " + "   STORED   " + "   RELEASED   " + "   STORAGE_NAME   "
				+ "       SR_DATE   ");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		try {
			// PreparedStatement : sql명령문 담아두는곳 , conn : DB의 연결정보를 가지고 있음
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ResultSet은 쿼리문 결과를 담아줄수있는 객체. sql문의 결과가 rs에 저장되어있음.
			ResultSet rs = pstmt.executeQuery();
			// 결과문이 있다면(true) 계속 dto에 값을 넣어준다.
			while (rs.next()) {
				dto = new ProductDTO();
				dto.setSRkey(rs.getInt("sr_key"));
				dto.setPkey(rs.getInt("p_key"));
				dto.setStore(rs.getInt("stored"));
				dto.setRelease(rs.getInt("released"));
				dto.setStoragename(rs.getString("storage_name"));
				dto.setSR_date(rs.getString("sr_date"));
				// dto에 값을 저장한후에 리스트에 추가(등록).
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; // 반환.
	}
	// 입출고정보 추가
		public void insertSR(ProductDTO dto) { 
		
		getConnection();
		List<ProductDTO> list = new ArrayList<>();
		
		try {
			CallableStatement cstmt = conn.prepareCall("{call insert_stock_info(?,?,?,?)}");
			
			cstmt.setInt(1, dto.getPkey());
			cstmt.setInt(2, dto.getStore());
			cstmt.setInt(3, dto.getRelease());
			cstmt.setString(4, dto.getStoragename());
			
			int r = cstmt.executeUpdate();
			System.out.println( "입출고정보 " + r + "건이 추가되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public List<ProductDTO> getStockList() {
		getConnection();
		// ProductDTO 형태의 구조를 갖는 List 생성
		List<ProductDTO> list = new ArrayList<>();
		// sql문 저장
		String sql = "select p_key, storage_name, c_stock from stock_info";
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		System.out.println("    P_KEY    " + "   STORAGE_NAME   " + "    C_STOCK    ");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		try {
			// PreparedStatement : sql명령문 담아두는곳 , conn : DB의 연결정보를 가지고 있음
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ResultSet은 쿼리문 결과를 담아줄수있는 객체. sql문의 결과가 rs에 저장되어있음.
			ResultSet rs = pstmt.executeQuery();
			// 결과문이 있다면(true) 계속 dto에 값을 넣어준다.
			while (rs.next()) {
				dto = new ProductDTO();
				dto.setPkey(rs.getInt("p_key"));
				dto.setStoragename(rs.getString("storage_name"));
				dto.setC_stock(rs.getInt("c_stock"));
				// dto에 값을 저장한후에 리스트에 추가(등록).
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; // 반환.
	}

	public List<ProductDTO> getStorageList() {
		getConnection();
		// ProductDTO 형태의 구조를 갖는 List 생성
		List<ProductDTO> list = new ArrayList<>();
		// sql문 저장
		String sql = "select storage_name, explanation from storage_info";
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		System.out.println("   STORAGE_NAME   " + "    EXPLANATION    ");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		try {
			// PreparedStatement : sql명령문 담아두는곳 , conn : DB의 연결정보를 가지고 있음
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ResultSet은 쿼리문 결과를 담아줄수있는 객체. sql문의 결과가 rs에 저장되어있음.
			ResultSet rs = pstmt.executeQuery();
			// 결과문이 있다면(true) 계속 dto에 값을 넣어준다.
			while (rs.next()) {
				dto = new ProductDTO();
				dto.setStoragename(rs.getString("storage_name"));
				dto.setExplanation(rs.getString("explanation"));
				// dto에 값을 저장한후에 리스트에 추가(등록).
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; // 반환.
	}

}
