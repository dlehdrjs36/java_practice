package Stream_Chapter29;
// p736
import java.util.Arrays;
import java.util.stream.Stream;

public class StringStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = { "YOON", "LEE", "PARK"};
		Stream<String> stm3 = Arrays.stream(names); //��Ʈ�� ����
		stm3.forEach(s -> System.out.println(s)); //�������� ����
	}

}
