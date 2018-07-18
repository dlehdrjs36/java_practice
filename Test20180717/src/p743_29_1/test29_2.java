package p743_29_1;

import java.util.ArrayList;
import java.util.List;



class ToyPriceInfo { // �峭�� �� �� ���� ����
	
	private String model; //�� ��
	private int price; // ����
	
	public ToyPriceInfo(String m, int p) {
		model = m;
		price = p;
	}
	
	public int getPrice() {
		return price;
	}
	public String getModel() {
		return model;
	}
}

public class test29_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ToyPriceInfo> ls = new ArrayList<>();
		ls.add(new ToyPriceInfo( "GUN_LR_45" , 200 ));
		ls.add(new ToyPriceInfo( "TEDDY_BEAR_S_014" , 350 ));
		ls.add(new ToyPriceInfo( "CAR_TRANSFORM_VER_7719" , 550 ));
		
			ls.stream()
			.filter( p -> p.getModel().length() > 10 )	// ���ڿ����� 10�̻������ ���
			.map( t -> t.getModel() )		// ���ڿ����� 10�Ѵ°͵��� �𵨸�� ����
			.forEach(t -> System.out.println(t)); // �������� : �𵨸���̰� 10�� �Ѵ� ToyPriceInfo�ν��Ͻ��� ���
		
		
	}

}
