package p743_29_1;

import java.util.Arrays;
import java.util.List;

class Box<T> {
	private T ob;
	public Box(T o) { ob = o; }
	public T get() { return ob; }
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (String)ob;
	}
	
}

public class test29_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Box<String>> ls = Arrays.asList(new Box<>("Robot"), new Box<>("Simple"));
		// 문자열 출력
		ls.stream()
		  .forEach(s -> System.out.print(s + "\t"));
		
		System.out.println();
		// 문자열 길이 맵핑
		ls.stream()
		  .map( s -> s.get().length())
		  .forEach(n -> System.out.print(n + "\t"));
		
		
	}

}
