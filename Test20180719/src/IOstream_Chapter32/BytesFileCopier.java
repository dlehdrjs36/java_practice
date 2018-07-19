package IOstream_Chapter32;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
// 816p, ���� ������ϱ�. 1����Ʈ����. ���� ����Ƚ��������.
public class BytesFileCopier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��� ����: ");
		String src = sc.nextLine();

		System.out.println("�纻 �̸�: ");
		String dst = sc.nextLine();

		try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
			int data;
			while (true) {
				data = in.read(); // ���Ϸκ��� 1 ����Ʈ�� �д´�.
				if (data == -1) { // �� �̻� �о� ���� �����Ͱ� ���ٸ�,
					break;
				}
				out.write(data); // ���Ͽ� 1����Ʈ�� ����.
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
