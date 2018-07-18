package Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[] = { 1,2,3,4,5,6,7,8,9 };		
		
		int sum = Arrays.stream(ar).filter(n -> n%2 == 1).sum();
							
		System.out.println(sum);
	}

}
