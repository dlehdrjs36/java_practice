package practice;

import java.util.ArrayList;
import java.util.List;



class Num<T>  {
	private T num;
	
	public Num(T i) {
		num = i;
	}
	
	@Override
	public String toString() {
		return "Num에 들어있는 값 : " + num + " ";
	}
	
}

public class TestGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
				List<Num> nlist = new ArrayList<>();   // == new ArrayList<Num>(), List<Num>이 target type이기때문에 <> 만써도 타입인식됨.
				Num<Integer> num1 = new Num<>(1);
				Num<String> num2 = new Num<>("오후");
				Num<Double> num3 = new Num<>(5.55);
				
				nlist.add(num1);
				nlist.add(num2);
				nlist.add(num3);
				
				for ( Num k : nlist) {
					System.out.println(k.toString());
				}
				
				
		
	}

}
