package Date_Chapter31;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class HowLongParallel {
	public static long fibonacci(long n) {
		if(n == 1 || n == 2) 
			return 1;
		return fibonacci( n - 1 ) + fibonacci( n - 2 );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			List<Integer> nums = Arrays.asList(41, 42, 43, 44, 45, 46);
			
			Instant start = Instant.now();
			nums.parallelStream() //º´·Ä ½ºÆ®¸² »ý¼º
				.map(n -> fibonacci(n))
				.forEach( System.out::println);
			//.forEach( r -> System.out.println(r));
			
			Instant end = Instant.now(); // ½ºÅé¿öÄ¡ ¸ØÃã
			System.out.println("Parallel Processing Time: " + 
				Duration.between(start, end).toMillis());
			
	}
}
