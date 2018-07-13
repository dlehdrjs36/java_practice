package Generic_Chapter21;

interface Eatable { public String eat(); } //메소드 생성

class Apple2 implements Eatable {
	public String toString() {
		return " I am an apple.";
	}

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return  "It tastes so good!";
	}
	
}

class Box4<T extends Eatable> { //T가 상속받은 클래스가 Eatable로 제한 되었음.
	T ob;
	public void set (T o) {
		ob = o;
	}
	public T get() {
			System.out.println(ob.eat()); //T가 상속받은 클래스가 Eatable로 제한 되었기 때문에 eat을 호출 할 수 있음.
			return ob;
	}
}

public class BoundedInterfaceBox {
	
	public static void main(String[] args) { //메인 메소드 			메인이 아니면 실행이 되지 않음.
		Box4<Apple2> box = new Box4<>();
		box.set(new Apple2()); 
		
		Apple2 ap = box.get();
		System.out.println(ap);

	}
}
