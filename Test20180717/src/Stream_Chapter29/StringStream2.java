package Stream_Chapter29;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringStream2 {

	public static void main(String[] args) {
		// StringStream�� �Ǵٸ� ����
		
		String[] names2 = { "YOON", "LEE", "PARK"};
		
		Arrays.stream(names2) //��Ʈ�� ����
			  .forEach(s -> System.out.println(s)); //�������� ����
	}
}
