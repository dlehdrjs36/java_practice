package Generic_Chapter21;

interface Eatable { public String eat(); } //�޼ҵ� ����

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

class Box4<T extends Eatable> { //T�� ��ӹ��� Ŭ������ Eatable�� ���� �Ǿ���.
	T ob;
	public void set (T o) {
		ob = o;
	}
	public T get() {
			System.out.println(ob.eat()); //T�� ��ӹ��� Ŭ������ Eatable�� ���� �Ǿ��� ������ eat�� ȣ�� �� �� ����.
			return ob;
	}
}

public class BoundedInterfaceBox {
	
	public static void main(String[] args) { //���� �޼ҵ� 			������ �ƴϸ� ������ ���� ����.
		Box4<Apple2> box = new Box4<>();
		box.set(new Apple2()); 
		
		Apple2 ap = box.get();
		System.out.println(ap);

	}
}
