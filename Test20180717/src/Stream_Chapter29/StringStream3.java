package Stream_Chapter29;

import java.util.Arrays;
import java.util.List;

public class StringStream3 {

	public static void main(String[] args) {
		// ����Ʈ������� ��Ʈ�� �����ϱ�.
		
		List<String> list = Arrays.asList("YOON", "LEE", "PARK");
		
		list.stream() //��Ʈ�� ����
			  .forEach(s -> System.out.print(s + "\t")); //�������� ����
	}
}
