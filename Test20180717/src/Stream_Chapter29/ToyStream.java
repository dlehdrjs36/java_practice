package Stream_Chapter29;

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
}

public class ToyStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ToyPriceInfo> ls = new ArrayList<>();
		ls.add(new ToyPriceInfo( "GUN_LR_45" , 200 ));
		ls.add(new ToyPriceInfo( "TEDDY_BEAR_S_014" , 350 ));
		ls.add(new ToyPriceInfo( "CAR_TRANSFORM_VER_7719" , 550 ));
		
		int sum = ls.stream()
					.filter( p -> p.getPrice() < 500 )	// 500�� �̸��� �峭�� ������ ����
					.mapToInt( t -> t.getPrice() )		// �ν��Ͻ��� ����Ǿ��ִ� ���������� ������ int�� ��Ʈ���� ����
					.sum();						// �������� : int�� ��Ʈ���� ����� ���� ������ ����Ͽ� ��ȯ.
		
		System.out.println( "sum = " + sum ); 
	}

}
