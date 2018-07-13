package Generic_Chapter21;

class Apple {						// 사과 클래스를 생성함 , 리턴값은 I am an apple 임.
	public String toString() {		// 문자형
		return " I am an apple.";
				
	}
	
}

class Orange {						// 오렌지 클래스를 생성함 , 리턴값은 I am an Orange 임.
	public String toString() {		// 문자형
		return " I am an Orange.";
				
	}
	
}

class Box2<T> {					//제네릭 타입의 <T> 박스를 생성.
		private T ob;
		
		public void set(T o) {
			ob = o;
		}
		public T get() {
			return ob;
		}
}

public class FruitAndBox2_Generic {		
	public static void main(String[] args) {		// 메인 메소드
		// TODO Auto-generated method stub
		Box2<Apple> aBox = new Box2<Apple>();
		Box2<Orange> bBox = new Box2<Orange>();
		
		aBox.set(new Apple());
		bBox.set(new Orange());
		
		Apple ap = aBox.get();
		Orange og = bBox.get();
		
		System.out.println(ap);
		System.out.println(og);
	}

}
