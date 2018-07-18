package Stream_Chapter29;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MyFirstStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 1, 2, 3, 4, 5 };
		IntStream stm1 = Arrays.stream(ar); //배열 ar로 부터 스트림 생성
		IntStream stm2 = stm1.filter(n -> n%2 == 1); //중간 연산 진행, 홀수만 남음
		int sum = stm2.sum(); //최종 연산 진행 (홀수들의 합)
		System.out.println(sum);
		
		// 위의 내용과 동일한 사용방법
		int sum2 = Arrays.stream(ar) // 스트림 생성하고,
						.filter(n -> n % 2 == 1) // filter 통과시키고,
						.sum(); // sum을 통과시켜 그 결과 반환
		System.out.println(sum2);
	}
}
