package Generic_Chapter21;


class Box<T> {					//���׸� Ÿ���� <T> �ڽ��� ����.
		private T ob;
		
		public void set(T o) {
			ob = o;
		}
		public T get() {
			return ob;
		}
}

public class PrimitivesAndGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box<Integer> iBox = new Box<Integer>();		//���׸�Ÿ���� Integer�������� �ϰ� iBox�� ���ؼ� ������ ��. (iBox��� ��ü�� ����.)
		iBox.set(125);		//���� �ڽ� ����.		125�� ���� Integer�� �־���.
		int num= iBox.get();	//���� ��ڽ�.
		System.out.println(num);

	}

}
