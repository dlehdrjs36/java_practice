package ERP;

import java.util.List;
import java.util.Scanner;

public class ProductMgmt {

	ProductDAO dao = null;
	

	// 상품목록 출력
	public void getProductList() {
		dao = new ProductDAO();
		List<ProductDTO> list = dao.getProductList();

		for (ProductDTO d : list) {
			System.out.println("      " + d.getPkey() + "           " + d.getPname() + "           "
					+ d.getExplanation() + "             " + d.getB_stock() + "        " + d.getPrice() + " ");

		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");

	}

	// 상품목록 추가
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

		System.out.println("가격을 입력하세요.");
		int price = sc2.nextInt();

		dao = new ProductDAO();
		ProductDTO dto = new ProductDTO();

		dto.setPname(ProductName);
		dto.setExplanation(explain);
		dto.setB_stock(stock);
		dto.setPrice(price);

		dao.insertProduct(dto);
	}

	// 상품수정
	public void updateProduct() {
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		
		System.out.println("수정할 상품키를 입력하세요.");
		int ProductKey = sc3.nextInt();

		System.out.println("상품 이름을 입력하세요.");
		String ProductName = sc4.nextLine();

		System.out.println("상품 설명을 입력하세요.");
		String explain = sc4.nextLine();

		System.out.println("기초재고를 입력하세요.");
		int stock = sc3.nextInt();

		System.out.println("가격을 입력하세요.");
		int price = sc3.nextInt();

		dao = new ProductDAO();
		ProductDTO dto = new ProductDTO();
		dto.setPname(ProductName);
		dto.setExplanation(explain);
		dto.setB_stock(stock);
		dto.setPrice(price);
		dto.setPkey(ProductKey);

		dao.updateProduct(dto);
	}
	// 상품제거 
	public void deleteProduct() {
		Scanner sc3 = new Scanner(System.in);
		
		System.out.println("제거할 상품키를 입력하세요.");
		int ProductKey = sc3.nextInt();
	
		dao = new ProductDAO();
		ProductDTO dto = new ProductDTO();
		dto.setPkey(ProductKey);

		dao.deleteProduct(dto);
	}
	public void insertSR() {
		System.out.println("상품키를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int Productkey = sc.nextInt();

		System.out.println("입고개수를 입력하세요.");
		int store = sc.nextInt();

		
		System.out.println("출고개수를 입력하세요.");
		int release = sc.nextInt();
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("창고이름을 입력하세요.");
		String storagename = sc2.nextLine();

		dao = new ProductDAO();
		ProductDTO dto = new ProductDTO();

		dto.setPkey(Productkey);
		dto.setStore(store);
		dto.setRelease(release);
		dto.setStoragename(storagename);

		dao.insertSR(dto);
		
	}
	// 입출고정보 조회
	public void getSRList() {
		dao = new ProductDAO();
		List<ProductDTO> list = dao.getSRList();

		for (ProductDTO d : list) {
			System.out.println("      " + d.getSRkey() + "           " + d.getPkey() + "             " + d.getStore()
					+ "           " + d.getRelease() + "             " + d.getStoragename() + "        "
					+ d.getSR_date() + " ");

		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");

	}

	public void getStockList() {
		dao = new ProductDAO();
		List<ProductDTO> list = dao.getStockList();

		for (ProductDTO d : list) {
			System.out.println(
					"      " + d.getPkey() + "           " + d.getStoragename() + "             " + d.getC_stock());

		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");

	}

	public void getStorageList() {
		dao = new ProductDAO();
		List<ProductDTO> list = dao.getStorageList();

		for (ProductDTO d : list) {
			System.out.println("      " + d.getStoragename() + "                   " + d.getExplanation());

		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");

	}
}
