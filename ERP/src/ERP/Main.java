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
			System.out.println(" 1: ��ǰ����, 2: �������������, 4: ���������ȸ, -5: â��������ȸ, 6: ����, 7:����Ʈ(Ŀ��)");
			System.out.println("---------------------------------------------------------------------------");
			menu = sc.nextInt();
			switch (menu) {

			case 1: // ��ǰ�����ȸ
				while (true) {
					System.out.println("--------------------------------------------------------------");
					System.out.println("0: ��ǰ��ȸ, 1: ��ǰ�߰�, 2: ��ǰ����, 3: ��ǰ����, 4: �����޴��� ������ ");
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
				
			case 2: // �������������
				while (true) {
					System.out.println("0: �����������ȸ, 1: ������߰� , 4: �����޴��� ������ ");
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
			case 3: // �����������ȸ
				mgmt.getSRList();
				break;
			case 4: // ���������ȸ
				mgmt.getStockList();
				break;
			case 5: // â��������ȸ
				mgmt.getStorageList();
				break;
			case 6: // ����
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			case 7:

				break;
			case 8:
				break;
			}
		}
	}

}
