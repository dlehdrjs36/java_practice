package ERP;

import java.util.List;
import java.util.Scanner;





public class ProductMgmt {
	ProductDAO dao = null;

	
	
	public void getProductList() {
		dao = new ProductDAO();
		List<ProductDTO> list = dao.getProductList();
		
		for ( ProductDTO d : list) {
			System.out.println(d);
		}
		
	}
	// mgmt�� insert�� ȣ���ϸ� productdto��ü�� ���� ���� �Է��� �Ŀ� ���� ���ۺκ�(dao�� insert�޼ҵ带) ȣ���Ѵ�. 
	
	public void insertProduct() {
			System.out.println("��ǰ �̸��� �Է��ϼ���.");
			Scanner sc = new Scanner(System.in);
			String ProductName = sc.nextLine();
			
			System.out.println("��ǰ ������ �Է��ϼ���.");
			String explain = sc.nextLine();
			
			Scanner sc2 = new Scanner(System.in);
			System.out.println("������� �Է��ϼ���.");
			int stock = sc2.nextInt();
			
			dao = new ProductDAO();
			ProductDTO dto = new ProductDTO();
			
			dto.setPname(ProductName);
			dto.setExplanation(explain);
			dto.setB_stock(stock);
			
			dao.insertProduct(dto);
		}
}
