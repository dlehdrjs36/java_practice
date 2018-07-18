package Date_Chapter31;

import java.time.LocalDate;

public class LocalDateDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����
		LocalDate today = LocalDate.now();
		System.out.println("Today: " + today );
		
		// �� ���� ũ��������
		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		System.out.println("Xmas: " + xmas);
		
		// �� ���� ũ�������� �̺�
		LocalDate eve = xmas.minusDays(1);
		System.out.println("Xmas Eve: " + eve);
	}

}
