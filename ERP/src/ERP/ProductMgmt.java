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
	// mgmt의 insert를 호출하면 productdto객체에 넣을 값을 입력한 후에 실제 동작부분(dao의 insert메소드를) 호출한다. 
	
	public void insertProduct() {
			System.out.println("상품 이름을 입력하세요.");
			Scanner sc = new Scanner(System.in);
			String ProductName = sc.nextLine();
			
			System.out.println("상품 설명을 입력하세요.");
			String explain = sc.nextLine();
			
			Scanner sc2 = new Scanner(System.in);
			System.out.println("기초재고를 입력하세요.");
			int stock = sc2.nextInt();
			
			dao = new ProductDAO();
			ProductDTO dto = new ProductDTO();
			
			dto.setPname(ProductName);
			dto.setExplanation(explain);
			dto.setB_stock(stock);
			
			dao.insertProduct(dto);
		}
}
