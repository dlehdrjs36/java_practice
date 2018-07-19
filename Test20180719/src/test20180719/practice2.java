package test20180719;

import java.util.Scanner;

public class practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("입금할 돈을 입력하시오 ");

		/*
		 * long won = sc.nextLong(); long rs = won; // 잔돈 System.out.println("입금한돈 : " +
		 * rs); boolean ck = true;
		 * 
		 * while (ck) { if ((rs / 50000) != 0) { System.out.println("50000원 : " + (rs /
		 * 50000) + " 개 "); rs = rs - ((rs / 50000) * 50000); } else if ((rs / 10000) !=
		 * 0) { System.out.println("10000원 : " + (rs / 10000) + " 개 "); rs = rs - ((rs /
		 * 10000) * 10000); } else if ((rs / 5000) != 0) { System.out.println("5000원 : "
		 * + (rs / 5000) + " 개 "); rs = rs - ((rs / 5000) * 5000); } else if ((rs /
		 * 1000) != 0) { System.out.println("1000원 : " + (rs / 1000) + " 개 "); rs = rs -
		 * ((rs / 1000) * 1000); } else if ((rs / 500) != 0) {
		 * System.out.println("500원 : " + (rs / 500) + " 개 "); rs = rs - ((rs / 500) *
		 * 500); } else if ((rs / 100) != 0) { System.out.println("100원 : " + (rs / 100)
		 * + " 개 "); rs = rs - ((rs / 100) * 100); } else if ((rs / 50) != 0) {
		 * System.out.println("50원 : " + (rs / 50) + " 개 "); rs = rs - ((rs / 50) * 50);
		 * } else if ((rs / 10) != 0) { System.out.println("10원 : " + (rs / 10) +
		 * " 개 "); rs = rs - ((rs / 10) * 10); } else if ((rs / 1) != 0) {
		 * System.out.println("1원 : " + (rs / 1) + " 개 "); rs = rs - ((rs / 1) * 1); }
		 * if (rs == 0) { System.out.println("입금금액 분석완료."); ck = false; }
		 * 
		 * }
		 */

		int[] i = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
		int won2 = sc.nextInt();
		int ct = 0; // 화폐단위별 매수(개수)
		int val = won2; // 잔돈
		for (int k=0 ; k<i.length; k++) {
			if ((val/i[k]) != 0) {
				ct = (val/i[k]);
				val = val -(ct*i[k]);
				System.out.println(i[k] + "원 개수:" + " " + ct + "\n남은돈 : " + val);
			}
		}
	}
}
