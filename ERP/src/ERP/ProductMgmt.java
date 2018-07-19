package ERP;

import java.util.List;
import java.util.Scanner;

public class ProductMgmt {

	ProductDAO dao = null;
	

	// ��ǰ��� ���
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

	// ��ǰ��� �߰�
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

		System.out.println("������ �Է��ϼ���.");
		int price = sc2.nextInt();

		dao = new ProductDAO();
		ProductDTO dto = new ProductDTO();

		dto.setPname(ProductName);
		dto.setExplanation(explain);
		dto.setB_stock(stock);
		dto.setPrice(price);

		dao.insertProduct(dto);
	}

	// ��ǰ����
	public void updateProduct() {
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		
		System.out.println("������ ��ǰŰ�� �Է��ϼ���.");
		int ProductKey = sc3.nextInt();

		System.out.println("��ǰ �̸��� �Է��ϼ���.");
		String ProductName = sc4.nextLine();

		System.out.println("��ǰ ������ �Է��ϼ���.");
		String explain = sc4.nextLine();

		System.out.println("������� �Է��ϼ���.");
		int stock = sc3.nextInt();

		System.out.println("������ �Է��ϼ���.");
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
	// ��ǰ���� 
	public void deleteProduct() {
		Scanner sc3 = new Scanner(System.in);
		
		System.out.println("������ ��ǰŰ�� �Է��ϼ���.");
		int ProductKey = sc3.nextInt();
	
		dao = new ProductDAO();
		ProductDTO dto = new ProductDTO();
		dto.setPkey(ProductKey);

		dao.deleteProduct(dto);
	}
	public void insertSR() {
		System.out.println("��ǰŰ�� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		int Productkey = sc.nextInt();

		System.out.println("�԰����� �Է��ϼ���.");
		int store = sc.nextInt();

		
		System.out.println("������� �Է��ϼ���.");
		int release = sc.nextInt();
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("â���̸��� �Է��ϼ���.");
		String storagename = sc2.nextLine();

		dao = new ProductDAO();
		ProductDTO dto = new ProductDTO();

		dto.setPkey(Productkey);
		dto.setStore(store);
		dto.setRelease(release);
		dto.setStoragename(storagename);

		dao.insertSR(dto);
		
	}
	// ��������� ��ȸ
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
