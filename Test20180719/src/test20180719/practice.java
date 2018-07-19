package test20180719;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// day1과 day2 더빠른날짜 선택하기 -> day3과 시간차 구하기
		
		LocalDateTime day1 = LocalDateTime.of(2018, 7, 20, 13, 50);
		LocalDateTime day2 = LocalDateTime.of(2018, 7, 21, 8, 40);
		
		// 더 빠른날짜 선택하는 과정
		LocalDateTime day3;
		
		if(day1.isBefore(day2)) {
			day3 = day1;
		}
		else {
			day3 = day2;
		}
		LocalDateTime day4 = LocalDateTime.of(2018, 6, 30, 1, 20);
		
		Duration drDate = Duration.between(day3, day4);
		System.out.println(drDate);
		
		//timezone
		// 프랑스
		// 우리나라
		// 시간차이보기 2018.12.13
		// 시간차이보기 2018.06.25
		DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-d, HH:mm:ssZ VV"); 
		ZonedDateTime date1 = ZonedDateTime.of(
				LocalDateTime.of(2018, 6, 25, 10, 0), ZoneId.of("Asia/Seoul"));
		ZonedDateTime date2 = ZonedDateTime.of(
				LocalDateTime.of(2018, 6, 25, 10, 0), ZoneId.of("Europe/Paris"));
		
		System.out.println(date1.format(fm));
		System.out.println(date2.format(fm));
		
	}
	
}
