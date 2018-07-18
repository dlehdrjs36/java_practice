package Test;

interface Printable {
	void print();
}

interface Printable2 {
	void print2();
}

class Paper {
	private String con;
	
	public Paper(String s) {
		con = s;
	}
	// 익명 클래스 형태
	public Printable getPrinter() {
		return new Printable() {
			public void print() {
				System.out.println("종이");
			}
		};
	}
	
	public Printable2 getPrinter2() {
		return new Printable2() {
			public void print2() {
				System.out.println(con);
			}
		};
	}
	//로컬클래스형태
	public Printable getPrinter3() {
		class Printer implements Printable {
			public void print() {
				System.out.println(con);
			}
			
		}
		return new Printer();
	}
	
	// 멤버클래스 형태 -> 로컬클래스 형태로 변경 -> 익명클래스형태로 변경
	// public printable getPrinter()  {
	// 		return new Printer();		멤버클래스 인스턴스 생성및 반환
	// }
	//	private class Printer implements Printable {	// 멤버클래스의 정의
	//	public void print() {
		//	System.out.println(con);
		//};
	//}
}
public class test_lambda01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paper p = new Paper("print this");
		Printable prn = p.getPrinter();
		Printable2 prn2 = p.getPrinter2();
		prn.print();
		prn2.print2();
	}

}
