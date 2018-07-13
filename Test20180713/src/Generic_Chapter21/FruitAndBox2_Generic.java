package Generic_Chapter21;

class Apple {						// ��� Ŭ������ ������ , ���ϰ��� I am an apple ��.
	public String toString() {		// ������
		return " I am an apple.";
				
	}
	
}

class Orange {						// ������ Ŭ������ ������ , ���ϰ��� I am an Orange ��.
	public String toString() {		// ������
		return " I am an Orange.";
				
	}
	
}

class Box2<T> {					//���׸� Ÿ���� <T> �ڽ��� ����.
		private T ob;
		
		public void set(T o) {
			ob = o;
		}
		public T get() {
			return ob;
		}
}

public class FruitAndBox2_Generic {		
	public static void main(String[] args) {		// ���� �޼ҵ�
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
