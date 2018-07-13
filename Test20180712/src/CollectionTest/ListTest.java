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
		List<Num> nlist = new ArrayList<>();   // == new ArrayList<Num>(), List<Num>이 target type이기때문에 <> 만써도 타입인식됨.
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
		
		// 배열리스트에 값 삽입. 순서대로 값이 저장됨.
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		
		// 배열리스트 출력
		for(int i=0; i<list.size();i++)	{
			System.out.println(list.get(i));
		}
		// 배열리스트의 처음 값 삭제
		list.remove(0);
		System.out.println();
		
		// 배열리스트 출력
		for(int i=0; i<list.size();i++)	{
			System.out.println(list.get(i));
		}
		*/
	}

}
