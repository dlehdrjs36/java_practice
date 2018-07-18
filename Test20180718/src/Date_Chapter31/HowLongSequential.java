package Date_Chapter31;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class HowLongSequential {
	public static long fibonacci(long n) {
		if( n == 1 || n == 2) 
			return 1;
		return fibonacci( n - 1 ) + fibonacci( n - 2 );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> nums = Arrays.asList(40, 41, 42, 43, 44, 45);
		
		Instant start = Instant.now(); // 스톱워치 시작
		nums.stream()	// 순차 스트림 생성
		    .map(n -> fibonacci(n))
		    .forEach(r -> System.out.println(r));
		
		Instant end = Instant.now(); // 스톱워치 멈춤
		
		System.out.println("Sequential Processing: " + 
				Duration.between(start, end).toMillis()); // 스톱워치 시작하고 끝날때 까지의 시간을 계산
		
		System.out.println("======================================================================= ");
		Instant start2 = Instant.now(); // 스톱워치 시작
		nums.parallelStream()	// 병렬 스트림 생성
		    .map(n -> fibonacci(n))
		    .forEach(r -> System.out.println(r));
		
		Instant end2 = Instant.now(); // 스톱워치 멈춤
		System.out.println("Parallel Processing: " + 
				Duration.between(start2, end2).toMillis()); // 스톱워치 시작하고 끝날때 까지의 시간을 계산
	}
}
