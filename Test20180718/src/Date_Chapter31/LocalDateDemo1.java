package Date_Chapter31;

import java.time.LocalDate;

public class LocalDateDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 오늘
		LocalDate today = LocalDate.now();
		System.out.println("Today: " + today );
		
		// 올 해의 크리스마스
		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		System.out.println("Xmas: " + xmas);
		
		// 올 해의 크리스마스 이브
		LocalDate eve = xmas.minusDays(1);
		System.out.println("Xmas Eve: " + eve);
	}

}
