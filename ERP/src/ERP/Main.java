package ERP;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProductMgmt mgmt = new ProductMgmt();
		mgmt.getProductList();
		System.out.println("==========================");
		mgmt.insertProduct();
	}

}
