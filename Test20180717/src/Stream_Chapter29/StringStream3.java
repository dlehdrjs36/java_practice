package Stream_Chapter29;

import java.util.Arrays;
import java.util.List;

public class StringStream3 {

	public static void main(String[] args) {
		// 리스트기반으로 스트림 생성하기.
		
		List<String> list = Arrays.asList("YOON", "LEE", "PARK");
		
		list.stream() //스트림 생성
			  .forEach(s -> System.out.print(s + "\t")); //최종연산 진행
	}
}
