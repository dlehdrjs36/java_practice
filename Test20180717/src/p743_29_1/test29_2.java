package p743_29_1;

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
			.filter( p -> p.getModel().length() > 10 )	// 문자열길이 10이상넘으면 통과
			.map( t -> t.getModel() )		// 문자열길이 10넘는것들은 모델명과 맵핑
			.forEach(t -> System.out.println(t)); // 최종연산 : 모델명길이가 10을 넘는 ToyPriceInfo인스턴스만 출력
		
		
	}

}
