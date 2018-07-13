package Generic_Chapter21;


class Box<T> {					//제네릭 타입의 <T> 박스를 생성.
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
		Box<Integer> iBox = new Box<Integer>();		//제네릭타입을 Integer형식으로 하고 iBox에 대해서 선언을 함. (iBox라는 객체를 생성.)
		iBox.set(125);		//오토 박싱 진행.		125의 값을 Integer에 넣어줌.
		int num= iBox.get();	//오토 언박싱.
		System.out.println(num);

	}

}
