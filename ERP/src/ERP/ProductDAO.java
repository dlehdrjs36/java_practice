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
	// ProductDTO��ü �ʱ�ȭ.
	ProductDTO dto = null;

	// db ����, Connection���·� ��ȯ.
	public Connection getConnection() {
		try {
			String user = "java";
			String pw = "java";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("Database�� ����Ǿ����ϴ�.\n");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB ����̹� �ε� ���� :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB ���ӽ��� : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		} // DB���ӿ� �ʿ��� ȯ��.
		return conn;
	}

	// ��ǰ��� ���.
	public List<ProductDTO> getProductList() {
		getConnection();
		// ProductDTO ������ ������ ���� List ����
		List<ProductDTO> list = new ArrayList<>();
		// sql�� ����
		String sql = "select p_key, p_name, explanation, b_stock, price from product";
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		System.out.println("    P_KEY    " + "   P_NAME   " + "   EXPLANATION   " + "   B_STOCK   " + "   PRICE   ");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");

		try {
			// PreparedStatement : sql��ɹ� ��Ƶδ°� , conn : DB�� ���������� ������ ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ResultSet�� ������ ����� ����ټ��ִ� ��ü. sql���� ����� rs�� ����Ǿ�����.
			ResultSet rs = pstmt.executeQuery();
			// ������� �ִٸ�(true) ��� dto�� ���� �־��ش�.
			while (rs.next()) {
				dto = new ProductDTO();
				dto.setPkey(rs.getInt("p_key"));
				dto.setPname(rs.getString("p_name"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setB_stock(rs.getInt("b_stock"));
				dto.setPrice(rs.getInt("price"));
				// dto�� ���� �������Ŀ� ����Ʈ�� �߰�(���).
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; // ��ȯ.
	}

	// ��ǰ �߰�
	public void insertProduct(ProductDTO dto) {

		getConnection();

		String sql = "insert into product (p_key, p_name, explanation, b_stock, price)"
				+ "values(product_p_key_seq.nextval, ?, ?, ?, ? )";

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getPname()); // ù��° ?�� ������
			pstmt.setString(2, dto.getExplanation()); // �ι�° ?�� ������
			pstmt.setInt(3, dto.getB_stock()); // ����° ?�� ������
			pstmt.setInt(4, dto.getPrice()); // �׹�° ?�� ������

			int cnt = pstmt.executeUpdate(); // ����

			System.out.println("��ǰ�̸� = \"" + dto.getPname() + "\"" + "�� " + cnt + "��" + " �߰��Ǿ����ϴ�.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ��ǰ����
	public void updateProduct(ProductDTO dto) {
		getConnection();
		
		int c = 0; // ���ڷνᵵ������ ������ġ�� �ٲ����� �����ϱ������. ���� ī��Ʈ ���.
		String sql = "update product set p_name = ?, explanation = ? , b_stock = ? , price = ? where p_key = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(++c, dto.getPname()); // ù��° ?�� ������
			pstmt.setString(++c, dto.getExplanation()); // �ι�° ?�� ������
			pstmt.setInt(++c, dto.getB_stock()); // ����° ?�� ������
			pstmt.setInt(++c, dto.getPrice()); // �׹�° ?�� ������
			pstmt.setInt(++c, dto.getPkey()); // �ټ���° ?�� ������

			int cnt = pstmt.executeUpdate(); // ����,����,������Ʈ
			
			System.out.println("��ǰŰ = \"" + dto.getPkey() + "\"" + "�� " + cnt + "��" + " �����Ǿ����ϴ�.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // �����ϸ� ���� ���� ���־����.
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ��ǰ����
	public void deleteProduct(ProductDTO dto) {
		getConnection();
		int c = 0; // ���ڷνᵵ������ ������ġ�� �ٲ����� �����ϱ������. ���� ī��Ʈ ���.
		String sql = "delete from product where p_key = ? ";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(++c, dto.getPkey()); // ù��° ?�� ������

			int cnt = pstmt.executeUpdate(); // ����,����,������Ʈ

			System.out.println("��ǰŰ \'" + dto.getPkey() + "\'��  ���ŵǾ����ϴ�..");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // �����ϸ� ���� ���� ���־����.
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ��������� ���
	public List<ProductDTO> getSRList() {
		getConnection();
		// ProductDTO ������ ������ ���� List ����
		List<ProductDTO> list = new ArrayList<>();
		// sql�� ����
		String sql = "select sr_key, p_key, stored, released, storage_name, sr_date from store_release";
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		System.out.println("    SR_KEY    " + "   P_KEY   " + "   STORED   " + "   RELEASED   " + "   STORAGE_NAME   "
				+ "       SR_DATE   ");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		try {
			// PreparedStatement : sql��ɹ� ��Ƶδ°� , conn : DB�� ���������� ������ ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ResultSet�� ������ ����� ����ټ��ִ� ��ü. sql���� ����� rs�� ����Ǿ�����.
			ResultSet rs = pstmt.executeQuery();
			// ������� �ִٸ�(true) ��� dto�� ���� �־��ش�.
			while (rs.next()) {
				dto = new ProductDTO();
				dto.setSRkey(rs.getInt("sr_key"));
				dto.setPkey(rs.getInt("p_key"));
				dto.setStore(rs.getInt("stored"));
				dto.setRelease(rs.getInt("released"));
				dto.setStoragename(rs.getString("storage_name"));
				dto.setSR_date(rs.getString("sr_date"));
				// dto�� ���� �������Ŀ� ����Ʈ�� �߰�(���).
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; // ��ȯ.
	}
	// ��������� �߰�
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
			System.out.println( "��������� " + r + "���� �߰��Ǿ����ϴ�.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public List<ProductDTO> getStockList() {
		getConnection();
		// ProductDTO ������ ������ ���� List ����
		List<ProductDTO> list = new ArrayList<>();
		// sql�� ����
		String sql = "select p_key, storage_name, c_stock from stock_info";
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		System.out.println("    P_KEY    " + "   STORAGE_NAME   " + "    C_STOCK    ");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		try {
			// PreparedStatement : sql��ɹ� ��Ƶδ°� , conn : DB�� ���������� ������ ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ResultSet�� ������ ����� ����ټ��ִ� ��ü. sql���� ����� rs�� ����Ǿ�����.
			ResultSet rs = pstmt.executeQuery();
			// ������� �ִٸ�(true) ��� dto�� ���� �־��ش�.
			while (rs.next()) {
				dto = new ProductDTO();
				dto.setPkey(rs.getInt("p_key"));
				dto.setStoragename(rs.getString("storage_name"));
				dto.setC_stock(rs.getInt("c_stock"));
				// dto�� ���� �������Ŀ� ����Ʈ�� �߰�(���).
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; // ��ȯ.
	}

	public List<ProductDTO> getStorageList() {
		getConnection();
		// ProductDTO ������ ������ ���� List ����
		List<ProductDTO> list = new ArrayList<>();
		// sql�� ����
		String sql = "select storage_name, explanation from storage_info";
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		System.out.println("   STORAGE_NAME   " + "    EXPLANATION    ");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");
		try {
			// PreparedStatement : sql��ɹ� ��Ƶδ°� , conn : DB�� ���������� ������ ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ResultSet�� ������ ����� ����ټ��ִ� ��ü. sql���� ����� rs�� ����Ǿ�����.
			ResultSet rs = pstmt.executeQuery();
			// ������� �ִٸ�(true) ��� dto�� ���� �־��ش�.
			while (rs.next()) {
				dto = new ProductDTO();
				dto.setStoragename(rs.getString("storage_name"));
				dto.setExplanation(rs.getString("explanation"));
				// dto�� ���� �������Ŀ� ����Ʈ�� �߰�(���).
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; // ��ȯ.
	}

}
