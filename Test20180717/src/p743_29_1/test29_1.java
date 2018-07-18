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
		// ���ڿ� ���
		ls.stream()
		  .forEach(s -> System.out.print(s + "\t"));
		
		System.out.println();
		// ���ڿ� ���� ����
		ls.stream()
		  .map( s -> s.get().length())
		  .forEach(n -> System.out.print(n + "\t"));
		
		
	}

}
