package Test;

interface Printable3 {
	void print(String s); 
}

class Printer2 implements Printable3 {
	public void print(String s) {
		System.out.println(s);
	}
}

public class test_lambda03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printable3 prn = (String s) -> { System.out.println(s); }; // 람다식으로 표현
		prn.print("Sample test");
		
		//Printable3 prn2 =

	}

}
