package test20180719;

import java.util.Scanner;

public class practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("�Ա��� ���� �Է��Ͻÿ� ");

		/*
		 * long won = sc.nextLong(); long rs = won; // �ܵ� System.out.println("�Ա��ѵ� : " +
		 * rs); boolean ck = true;
		 * 
		 * while (ck) { if ((rs / 50000) != 0) { System.out.println("50000�� : " + (rs /
		 * 50000) + " �� "); rs = rs - ((rs / 50000) * 50000); } else if ((rs / 10000) !=
		 * 0) { System.out.println("10000�� : " + (rs / 10000) + " �� "); rs = rs - ((rs /
		 * 10000) * 10000); } else if ((rs / 5000) != 0) { System.out.println("5000�� : "
		 * + (rs / 5000) + " �� "); rs = rs - ((rs / 5000) * 5000); } else if ((rs /
		 * 1000) != 0) { System.out.println("1000�� : " + (rs / 1000) + " �� "); rs = rs -
		 * ((rs / 1000) * 1000); } else if ((rs / 500) != 0) {
		 * System.out.println("500�� : " + (rs / 500) + " �� "); rs = rs - ((rs / 500) *
		 * 500); } else if ((rs / 100) != 0) { System.out.println("100�� : " + (rs / 100)
		 * + " �� "); rs = rs - ((rs / 100) * 100); } else if ((rs / 50) != 0) {
		 * System.out.println("50�� : " + (rs / 50) + " �� "); rs = rs - ((rs / 50) * 50);
		 * } else if ((rs / 10) != 0) { System.out.println("10�� : " + (rs / 10) +
		 * " �� "); rs = rs - ((rs / 10) * 10); } else if ((rs / 1) != 0) {
		 * System.out.println("1�� : " + (rs / 1) + " �� "); rs = rs - ((rs / 1) * 1); }
		 * if (rs == 0) { System.out.println("�Աݱݾ� �м��Ϸ�."); ck = false; }
		 * 
		 * }
		 */

		int[] i = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
		int won2 = sc.nextInt();
		int ct = 0; // ȭ������� �ż�(����)
		int val = won2; // �ܵ�
		for (int k=0 ; k<i.length; k++) {
			if ((val/i[k]) != 0) {
				ct = (val/i[k]);
				val = val -(ct*i[k]);
				System.out.println(i[k] + "�� ����:" + " " + ct + "\n������ : " + val);
			}
		}
	}
}
