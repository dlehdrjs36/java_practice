package IOstream_Chapter32;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
// 816p, 파일 입출력하기. 1바이트씩함. 파일 접근횟수많아짐.
public class BytesFileCopier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("대상 파일: ");
		String src = sc.nextLine();

		System.out.println("사본 이름: ");
		String dst = sc.nextLine();

		try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
			int data;
			while (true) {
				data = in.read(); // 파일로부터 1 바이트를 읽는다.
				if (data == -1) { // 더 이상 읽어 들일 데이터가 없다면,
					break;
				}
				out.write(data); // 파일에 1바이트를 쓴다.
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
