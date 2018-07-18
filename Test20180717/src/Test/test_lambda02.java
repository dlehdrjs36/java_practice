package Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*class StrComp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length() - o2.length();
	}
	
}
*/
public class test_lambda02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("robot");
		list.add("apple2");
		list.add("box");
		// StrComp cmp = new StrComp();
		Collections.sort(list, (String o1, String o2) -> {return o1.length() - o2.length();} ); //람다식으로 정의
		System.out.println(list);
		}

}
