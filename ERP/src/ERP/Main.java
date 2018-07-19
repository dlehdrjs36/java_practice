package ERP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu;
		Scanner sc = new Scanner(System.in);
		ProductMgmt mgmt = new ProductMgmt();
		int value;

		while (true) {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println(" 1: 상품정보, 2: 입출고정보관리, 4: 재고정보조회, -5: 창고정보조회, 6: 종료, 7:리스트(커서)");
			System.out.println("---------------------------------------------------------------------------");
			menu = sc.nextInt();
			switch (menu) {

			case 1: // 상품목록조회
				while (true) {
					System.out.println("--------------------------------------------------------------");
					System.out.println("0: 상품조회, 1: 상품추가, 2: 상품수정, 3: 상품삭제, 4: 상위메뉴로 나가기 ");
					System.out.println("--------------------------------------------------------------");
					value = sc.nextInt();

					if (value == 0)
						mgmt.getProductList();
					else if (value == 1)
						mgmt.insertProduct();
					else if (value == 2)
						mgmt.updateProduct();
					else if (value == 3)
						mgmt.deleteProduct();
					else if (value == 4)
						break;
				}
				break;
				
			case 2: // 입출고정보관리
				while (true) {
					System.out.println("0: 입출고정보조회, 1: 입출고추가 , 4: 상위메뉴로 나가기 ");
					value = sc.nextInt();

					if (value == 0)
						mgmt.getSRList();
					else if (value == 1)
						mgmt.insertSR();
					else if (value == 2)
						mgmt.updateProduct();
					else if (value == 3)
						mgmt.deleteProduct();
					else if (value == 4)
						break;
				}
			case 3: // 입출고정보조회
				mgmt.getSRList();
				break;
			case 4: // 재고정보조회
				mgmt.getStockList();
				break;
			case 5: // 창고정보조회
				mgmt.getStorageList();
				break;
			case 6: // 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			case 7:

				break;
			case 8:
				break;
			}
		}
	}

}
