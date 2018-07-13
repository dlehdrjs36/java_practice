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
		return "Num�� ����ִ� �� : " + num + " ";
	}
	
}

public class TestGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
				List<Num> nlist = new ArrayList<>();   // == new ArrayList<Num>(), List<Num>�� target type�̱⶧���� <> ���ᵵ Ÿ���νĵ�.
				Num<Integer> num1 = new Num<>(1);
				Num<String> num2 = new Num<>("����");
				Num<Double> num3 = new Num<>(5.55);
				
				nlist.add(num1);
				nlist.add(num2);
				nlist.add(num3);
				
				for ( Num k : nlist) {
					System.out.println(k.toString());
				}
				
				
		
	}

}
