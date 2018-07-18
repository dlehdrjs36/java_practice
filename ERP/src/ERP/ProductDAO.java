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
    // ProductDTO��ü �ʱ�ȭ.
    ProductDTO dto = null;
    
	//db ����, Connection���·� ��ȯ.
	public Connection getConnection() {
        try {
            String user = "java"; 
            String pw = "java";
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
	
	public List<ProductDTO> getProductList() {		
		getConnection();		
        // ProductDTO ������ ������ ���� List ����
        List<ProductDTO> list = new ArrayList<>();
        // sql�� ����
        String sql = "select p_key, p_name, explanation, b_stock from product"; 
        // sql�� ���
        System.out.println(sql);
        try {
        	// PreparedStatement : sql��ɹ� ��Ƶδ°� , conn : DB�� ���������� ������ ����
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			// ResultSet�� ������ ����� ����ټ��ִ� ��ü. sql���� ����� rs�� ����Ǿ�����. 
			ResultSet rs = pstmt.executeQuery();			
			// ������� �ִٸ�(true) ��� dto�� ���� �־��ش�.
		while(rs.next()) { 
				dto = new ProductDTO();
				dto.setPkey(rs.getInt("p_key"));
				dto.setPname(rs.getString("p_name"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setB_stock(rs.getInt("b_stock"));	
				//  dto�� ���� �������Ŀ� ����Ʈ�� �߰�(���).
				list.add(dto); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; // ��ȯ.
	}
	// ��ǰ �߰�
	public void insertProduct (ProductDTO dto) {
		
		getConnection();
		
		String sql = "insert into product (p_key, p_name, explanation, b_stock)"
					+ "values(product_p_key_seq.nextval, ?, ?, ? )";
				 
				     
		// sql�� ���
	    System.out.println(sql);
			
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPname() ); // ù��° ?�� ������
			pstmt.setString(2, dto.getExplanation()); // �ι�° ?�� ������
			pstmt.setInt(3, dto.getB_stock()); // ����° ?�� ������
			
			
			int cnt = pstmt.executeUpdate(); // ����
			System.out.print(cnt + " ��ǰ�� �߰��Ǿ����ϴ�.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
