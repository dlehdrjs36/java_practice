package Stream_Chapter29;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MyFirstStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 1, 2, 3, 4, 5 };
		IntStream stm1 = Arrays.stream(ar); //�迭 ar�� ���� ��Ʈ�� ����
		IntStream stm2 = stm1.filter(n -> n%2 == 1); //�߰� ���� ����, Ȧ���� ����
		int sum = stm2.sum(); //���� ���� ���� (Ȧ������ ��)
		System.out.println(sum);
		
		// ���� ����� ������ �����
		int sum2 = Arrays.stream(ar) // ��Ʈ�� �����ϰ�,
						.filter(n -> n % 2 == 1) // filter �����Ű��,
						.sum(); // sum�� ������� �� ��� ��ȯ
		System.out.println(sum2);
	}
}
