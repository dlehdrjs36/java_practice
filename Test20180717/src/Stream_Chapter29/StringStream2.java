package Stream_Chapter29;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringStream2 {

	public static void main(String[] args) {
		// StringStream의 또다른 사용법
		
		String[] names2 = { "YOON", "LEE", "PARK"};
		
		Arrays.stream(names2) //스트림 생성
			  .forEach(s -> System.out.println(s)); //최종연산 진행
	}
}
