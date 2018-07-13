package Generic_Chapter21;

class Box3<T> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

class BoxFactory {
	public static <T extends Number> Box3<T> makeBox(T o) {
		Box3<T> box = new Box3<T>();
		box.set(o);
		
		System.out.println("Boxed data: " + o.intValue());
		return box;
	}
}

class Unboxer {
	public static <T extends Number> T openBox(Box3<T> box) {
		System.out.println("Unboxed data: " + box.get().intValue());
		return box.get();
	}
}

public class BoundedGenericMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box3<Integer> sbox = BoxFactory.makeBox(new Integer(5959));
		int n = Unboxer.openBox(sbox);
		System.out.println("Returned data: " + n);

	}

}
