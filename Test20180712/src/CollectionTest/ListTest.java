package CollectionTest;

import java.util.ArrayList;
import java.util.List;

class Num  {
	int num;
	
	public  Num(int i) {
		num = i;
	}
	@Override
	public String toString() {
		return "Num [num=" + num + "]";
	}
	
}

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Num> nlist = new ArrayList<>();   // == new ArrayList<Num>(), List<Num>�� target type�̱⶧���� <> ���ᵵ Ÿ���νĵ�.
		Num num1 = new Num(1);
		Num num2 = new Num(2);
		
		nlist.add(num1);
		nlist.add(num2);
		
		for ( Num k : nlist) {
			System.out.println(k.toString());
		}
		
		for ( Num k : nlist) {
			System.out.println(k.num);
		}

	/*	for( int i = 0; i<nlist.size() ; i++) {
			
			System.out.println(nlist);
		} */
		
		
		
		
		
		
		
		
	/*	List<String> list = new ArrayList<>();
		
		// �迭����Ʈ�� �� ����. ������� ���� �����.
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		
		// �迭����Ʈ ���
		for(int i=0; i<list.size();i++)	{
			System.out.println(list.get(i));
		}
		// �迭����Ʈ�� ó�� �� ����
		list.remove(0);
		System.out.println();
		
		// �迭����Ʈ ���
		for(int i=0; i<list.size();i++)	{
			System.out.println(list.get(i));
		}
		*/
	}

}
