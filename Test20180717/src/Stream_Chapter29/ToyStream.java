package Stream_Chapter29;

import java.util.ArrayList;
import java.util.List;

class ToyPriceInfo { // 장난감 모델 별 가격 정보
	
	private String model; //모델 명
	private int price; // 가격
	
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
					.filter( p -> p.getPrice() < 500 )	// 500원 미만인 장난감 가격의 총합
					.mapToInt( t -> t.getPrice() )		// 인스턴스에 저장되어있는 가격정보를 꺼내서 int형 스트림을 생성
					.sum();						// 최종연산 : int형 스트림에 저장된 값의 총합을 계산하여 반환.
		
		System.out.println( "sum = " + sum ); 
	}

}
