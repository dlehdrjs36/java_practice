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
	// �͸� Ŭ���� ����
	public Printable getPrinter() {
		return new Printable() {
			public void print() {
				System.out.println("����");
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
	//����Ŭ��������
	public Printable getPrinter3() {
		class Printer implements Printable {
			public void print() {
				System.out.println(con);
			}
			
		}
		return new Printer();
	}
	
	// ���Ŭ���� ���� -> ����Ŭ���� ���·� ���� -> �͸�Ŭ�������·� ����
	// public printable getPrinter()  {
	// 		return new Printer();		���Ŭ���� �ν��Ͻ� ������ ��ȯ
	// }
	//	private class Printer implements Printable {	// ���Ŭ������ ����
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
